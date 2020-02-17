package main.entity;

import main.utils.Unit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipesTest {

    @Test
    void getId () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        assertEquals(null, recipeTest.getId ());
    }

    @Test
    void setId () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        Long expected = (long) 1;
        recipeTest.setId ((long) 1);
        assertEquals(expected, recipeTest.getId ());
    }

    @Test
    void getName () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        String expected = "Tourte au docker";
        assertEquals(expected, recipeTest.getName ());
    }

    @Test
    void setName () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        String expected = "Tourte au kubernetes";
        recipeTest.setName (expected);
        assertEquals(expected, recipeTest.getName ());
    }

    @Test
    void getPreparation () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        String expected = "Faire docker pull docker";
        assertEquals(expected, recipeTest.getPreparation ());
    }

    @Test
    void setPreparation () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        String expected = "Faire docker pull docker";
        recipeTest.setPreparation (expected);
        assertEquals(expected, recipeTest.getPreparation ());
    }

    @Test
    void getIngredients () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        assertEquals(listIngredientTest, recipeTest.getIngredients ());
    }

    @Test
    void setIngredients () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        List<Ingredients> listIngredientTest = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTest);
        Recipes recipeTest = new Recipes ("Tourte au docker", "Faire docker pull docker", listIngredientTest);
        Ingredients ingredientTestExpected = new Ingredients (foodTest, 40, Unit.GRAMME);
        List<Ingredients> listIngredientTestExpected = new ArrayList<Ingredients>();
        listIngredientTest.add (ingredientTestExpected);
        recipeTest.setIngredients (listIngredientTestExpected);
        assertEquals(listIngredientTestExpected, recipeTest.getIngredients ());
    }
}