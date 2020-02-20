package main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import main.tobj.TPdfRecipes;
import main.tobj.TRecipes;
import main.entity.Ingredients;
import main.entity.Recipes;
import main.exception.RecipeNotFoundException;
import main.repository.IngredientRepository;
import main.repository.RecipesRepository;
import main.utils.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class RecipesController {
    private static final Logger logger = LogManager.getLogger(RecipesController.class);
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private IngredientRepository ingredientsRepository;


    @GetMapping("/recipes")
    public Iterable<Recipes> all() {
        return recipesRepository.findAll();
    }

    @GetMapping("/recipe/{id}")
    public Recipes one(@PathVariable Long id) {
        return recipesRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException (id));
    }

    @PostMapping(value = "/recipe",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> newRecipe(@RequestBody TRecipes newTRecipe) {
        List<Ingredients> listCurrentIngredients = new ArrayList<> ();
        for (Long ingredientid :newTRecipe.getIngredientsIds ()) {
            Ingredients ingredient = ingredientsRepository.findById (ingredientid) .orElseThrow(() -> new RecipeNotFoundException (ingredientid));
            listCurrentIngredients.add (ingredient);
        }
        Recipes recipe = new Recipes (newTRecipe.getName (),newTRecipe.getPreparation (),listCurrentIngredients);
        recipesRepository.save(recipe);
        return Collections.singletonMap("response", "Inserted");
    }

    @GetMapping(value = "/recipe-get-pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<byte[]> getPdfFile() throws IOException {
        byte[] contents = Files.readAllBytes(Paths.get (System.getProperty ("user.dir") + "/pdf/recipes.pdf"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "recipes.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/recipe-create-pdf", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> newPdfRecipe(@RequestBody TPdfRecipes newTPdfRecipe) {
        List<Recipes> listCurrentRecipes = new ArrayList<> ();
        System.out.println (newTPdfRecipe.getRecipeIds ());
        for (Long recipeid :newTPdfRecipe.getRecipeIds ()) {
            System.out.println (recipeid);
            Recipes recipe = recipesRepository.findById (recipeid) .orElseThrow(() -> new RecipeNotFoundException (recipeid));
            listCurrentRecipes.add (recipe);
            logger.info(recipe);
        }
        try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream ("./pdf/recipes.pdf"));
        document.open();
        for (Recipes recipe :listCurrentRecipes) {
            PdfPTable table = new PdfPTable(1);
            table.setKeepTogether(true);
            PdfPCell cellTitle = new PdfPCell ();
            PdfPCell cellIngredient = new PdfPCell ();
            PdfPCell cellPreparation = new PdfPCell ();

            Font fTitle = new Font();
            fTitle.setStyle(Font.BOLD);
            fTitle.setSize(20);
            Paragraph title = new Paragraph(recipe.getName () + "\n\n" ,fTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            cellTitle.addElement(title);

            Font fIngredients = new Font();
            fIngredients.setSize(16);
            Paragraph ingredients = new Paragraph("\n",fIngredients);
            cellIngredient.addElement(ingredients);
            for (Ingredients ingredient: recipe.getIngredients ()) {
                if(ingredient.getUnite () == Unit.NONE){
                    cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                } else if(ingredient.getUnite () == Unit.GRAMME) {
                    if(ingredient.getQuantite () > 1) {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " grammes de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    } else {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " gramme de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    }
                } else if(ingredient.getUnite () == Unit.KILO) {
                    if(ingredient.getQuantite () > 1) {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " kilos de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    } else {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " kilo de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    }
                } else if(ingredient.getUnite () == Unit.LITRE) {
                    if(ingredient.getQuantite () > 1) {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " litres de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    } else {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " litre de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    }
                }
                else if(ingredient.getUnite () == Unit.MILLILITRE) {
                    if(ingredient.getQuantite () > 1) {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " millilitres de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    } else {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " millilitre de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    }
                }
                else if(ingredient.getUnite () == Unit.CENTILITRE) {
                    if(ingredient.getQuantite () > 1) {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " centilitres de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    } else {
                        cellIngredient.addElement(new Paragraph("- " +  ingredient.getQuantite () + " centilitre de "+ ingredient.getFood ().getName ().toLowerCase (), fIngredients));
                    }
                }
            }
            cellIngredient.addElement(new Paragraph("\n"));

            Font fPreparation = new Font();
            fPreparation.setStyle(Font.ITALIC);
            fPreparation.setSize(14);
            cellPreparation.addElement(new Paragraph("Preparation : \n\n" + recipe.getPreparation () + "\n\n", fPreparation));
            cellPreparation.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT| Rectangle.LEFT| Rectangle.TOP);

            cellTitle.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell (cellTitle);

            cellIngredient.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            cellIngredient.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell (cellIngredient);

            cellPreparation.setBorder(Rectangle.BOTTOM | Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            cellPreparation.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell (cellPreparation);

            document.add(table);
        }
        document.close();
        } catch (DocumentException|FileNotFoundException e) {
            throw new RecipeNotFoundException (e.getMessage ());
        }
        return Collections.singletonMap("response", "Correct pdf generation");
    }

    @DeleteMapping(value = "/recipe/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteRecipe(@PathVariable Long id) {
        recipesRepository.deleteById(id);
        logger.info("Removed from database");
        return Collections.singletonMap("response", "Removed from database");
    }
}
