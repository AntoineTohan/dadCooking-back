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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/ingredient")
    public String newTIngredient(@RequestBody TIngredients newTIngredient) {
        Food food = foodRepository.findById (newTIngredient.getFoodId ()) .orElseThrow(() -> new IngredientNotFoundException (newTIngredient.getFoodId ()));
        Ingredients ingredient = new Ingredients (food,newTIngredient.getQuantite (),newTIngredient.getUnite ());
        ingredientsRepository.save(ingredient);
        return "Inserted";
    }

    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientsRepository.deleteById(id);
        logger.info("Removed from database! ");
    }
}
