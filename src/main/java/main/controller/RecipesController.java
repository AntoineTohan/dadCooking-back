package main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import main.TObj.TPdfRecipes;
import main.TObj.TRecipes;
import main.entity.Ingredients;
import main.entity.Recipes;
import main.exception.RecipeNotFoundException;
import main.repository.IngredientRepository;
import main.repository.RecipesRepository;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipesController {
    private static final Logger logger = LogManager.getLogger(RecipesController.class);
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private IngredientRepository ingredientsRepository;


    @GetMapping("/recipes")
    Iterable<Recipes> all() {
        return recipesRepository.findAll();
    }

    @GetMapping("/recipe/{id}")
    Recipes one(@PathVariable Long id) {
        return recipesRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException (id));
    }

    @PostMapping("/recipe")
    String newRecipe(@RequestBody TRecipes newTRecipe) {
        List<Ingredients> listCurrentIngredients = new ArrayList<Ingredients> ();
        for (Long ingredientid :newTRecipe.getIngredientsIds ()) {
            Ingredients ingredient = ingredientsRepository.findById (ingredientid) .orElseThrow(() -> new RecipeNotFoundException (ingredientid));
            listCurrentIngredients.add (ingredient);
        }
        Recipes recipe = new Recipes (newTRecipe.getName (),newTRecipe.getPreparation (),listCurrentIngredients);
        recipesRepository.save(recipe);
        return "Inserted";
    }

    @GetMapping(value = "/recipe-get-pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<byte[]> getPdfFile() throws IOException {
        byte[] contents = Files.readAllBytes(Paths.get (System.getProperty ("user.dir") + "/pdf/recipes.pdf"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "recipes.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }

    @PostMapping(value = "/recipe-create-pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    String newPdfRecipe(@RequestBody TPdfRecipes newTPdfRecipe) {
        List<Recipes> listCurrentRecipes = new ArrayList<Recipes> ();
        for (Long recipeid :newTPdfRecipe.getRecipeIds ()) {
            Recipes recipe = recipesRepository.findById (recipeid) .orElseThrow(() -> new RecipeNotFoundException (recipeid));
            listCurrentRecipes.add (recipe);
            logger.info(recipe);
        }
        try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream ("./pdf/recipes.pdf"));
        document.open();
        PdfPTable table = new PdfPTable(1);

        for (Recipes recipe :listCurrentRecipes) {
            PdfPCell cell = new PdfPCell ();
            cell.addElement(new Phrase("Name: " + recipe.getName ()));
            cell.addElement(new Phrase("Ingredient : " ));
            for (Ingredients ingredient: recipe.getIngredients ()) {
                cell.addElement(new Phrase("- " +  ingredient.getQuantite () + " " + ingredient.getUnite () + " "+ ingredient.getFood ().getName ()));
            }
            cell.addElement(new Phrase("Preparation: " + recipe.getPreparation ()));
            cell.setColspan (1);
            table.addCell (cell);
        }
        document.add(table);
        document.close();
        } catch (DocumentException e) {
            e.printStackTrace ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        return "Correct pdf generation ! ";
    }

    @DeleteMapping("/recipe/{id}")
    void deleteRecipe(@PathVariable Long id) {
        recipesRepository.deleteById(id);
        logger.info("Removed from database! ");
    }
}
