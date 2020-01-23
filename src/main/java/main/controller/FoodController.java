package main.controller;

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
    Iterable<Food> all() {
        return foodRepository.findAll();
    }

    @GetMapping("/food/{id}")
    Food one(@PathVariable Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundException (id));
    }

    @PostMapping("/food")
    String newFood(@RequestBody Food newFood) {
        Long exist = foodRepository.countByName(newFood.getName ());
        if(exist > 0) {
            logger.warn("Already in database !");
            return "Already in database !";
        } else {
            foodRepository.save (newFood);
            return "Inserted";
        }
    }

    @DeleteMapping("/food/{id}")
    void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        logger.info("Removed from database! ");
    }
}
