package main.controller;

import main.tobj.TIngredients;
import main.entity.Food;
import main.entity.Ingredients;
import main.exception.IngredientNotFoundException;
import main.repository.FoodRepository;
import main.repository.IngredientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class IngredientsController {
    private static final Logger logger = LogManager.getLogger(IngredientsController.class);
    @Autowired
    private IngredientRepository ingredientsRepository;
    @Autowired
    private FoodRepository foodRepository;


    @GetMapping("/ingredients")
    public Iterable<Ingredients> all() {
        return ingredientsRepository.findAll();
    }

    @GetMapping("/ingredient/{id}")
    public Ingredients one(@PathVariable Long id) {
        return ingredientsRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException (id));
    }

    @PostMapping(value = "/ingredient",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> newTIngredient(@RequestBody TIngredients newTIngredient) {
        Food food = foodRepository.findById (newTIngredient.getFoodId ()) .orElseThrow(() -> new IngredientNotFoundException (newTIngredient.getFoodId ()));
        Ingredients ingredient = new Ingredients (food,newTIngredient.getQuantite (),newTIngredient.getUnite ());
        Ingredients existIngredient = ingredientsRepository.findByFoodAndQuantiteAndUnite (food,ingredient.getQuantite (), ingredient.getUnite () );
        if(existIngredient != null) {
            logger.warn("Already in database");
            return Collections.singletonMap("response", "Already in database");
        } else {
            ingredientsRepository.save(ingredient);
            return Collections.singletonMap("response", "Inserted");
        }
    }

    @DeleteMapping(value = "/ingredient/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteIngredient(@PathVariable Long id) {
        ingredientsRepository.deleteById(id);
        logger.info("Removed from database");
        return Collections.singletonMap("response", "Removed from database");
    }
}
