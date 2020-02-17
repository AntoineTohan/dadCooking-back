package main.controller;

import main.tobj.TFood;
import main.entity.Food;
import main.exception.FoodNotFoundException;
import main.repository.FoodRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    private static final Logger logger = LogManager.getLogger(FoodController.class);
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/foods")
    public Iterable<Food> all() {
        return foodRepository.findAll();
    }

    @GetMapping("/food/{id}")
    public Food one(@PathVariable Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundException (id));
    }

    @PostMapping("/food")
    public String newFood(@RequestBody TFood newFood) {
        Food exist = foodRepository.findByName (newFood.getName ());
        if(exist != null) {
            logger.warn("Already in database !");
            return "Already in database !";
        } else {
            Food foodDTONew = new Food (newFood.getName ());
            foodRepository.save (foodDTONew);
            return "Inserted";
        }
    }

    @DeleteMapping("/food/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        logger.info("Removed from database! ");
    }
}
