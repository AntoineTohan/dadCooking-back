package main.entity;

import main.utils.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsTest {

    @Test
    void getId () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        assertEquals(null, ingredientTest.getId ());
    }

    @Test
    void setId () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        Long expected = (long) 1;
        ingredientTest.setId ((long) 1);
        assertEquals(expected, ingredientTest.getId ());
    }

    @Test
    void getFood () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        assertEquals(foodTest, ingredientTest.getFood ());
    }

    @Test
    void setFood () {
        Food foodTest = new Food ("Farines");
        Food expected = new Food ("Sel");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        ingredientTest.setFood (expected);
        assertEquals(expected, ingredientTest.getFood ());
    }

    @Test
    void getQuantite () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        assertEquals(30, ingredientTest.getQuantite ());
    }

    @Test
    void setQuantite () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        ingredientTest.setQuantite (20);
        assertEquals(20, ingredientTest.getQuantite ());
    }

    @Test
    void getUnite () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        assertEquals(Unit.KILO, ingredientTest.getUnite ());
    }

    @Test
    void setUnite () {
        Food foodTest = new Food ("Farines");
        Ingredients ingredientTest = new Ingredients (foodTest, 30, Unit.KILO);
        ingredientTest.setUnite (Unit.GRAMME);
        assertEquals(Unit.GRAMME, ingredientTest.getUnite ());
    }
}