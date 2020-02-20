package main.repository;

import main.entity.Food;
import main.entity.Ingredients;
import main.utils.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredients, Long> {
    Ingredients findByFoodAndQuantiteAndUnite(Food food, int quantity, Unit unite);
}
