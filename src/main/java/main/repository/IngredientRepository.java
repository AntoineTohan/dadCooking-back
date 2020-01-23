package main.repository;

import main.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredients, Long> {

}
