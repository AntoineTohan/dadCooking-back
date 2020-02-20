package main.controller;

import main.tobj.TFood;
import main.entity.Food;
import main.exception.FoodNotFoundException;
import main.repository.FoodRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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

    @PostMapping(value = "/food",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> newFood(@RequestBody TFood newFood) {
        Food exist = foodRepository.findByName (newFood.getName ());
        if(exist != null) {
            logger.warn("Already in database");
            return Collections.singletonMap("response", "Already in database");
        } else {
            Food foodDTONew = new Food (newFood.getName ());
            foodRepository.save (foodDTONew);
            return Collections.singletonMap("response", "Inserted");
        }
    }

    @DeleteMapping(value = "/food/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        logger.info("Removed from database");
        return Collections.singletonMap("response", "Removed from database");
    }
}
