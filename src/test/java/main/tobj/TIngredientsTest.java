package main.tobj;

import main.utils.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TIngredientsTest {

    @Test
    void getFoodId () {
        Long expected = (long) 1;
        TIngredients ingredientTest = new TIngredients (expected,200, Unit.KILO);
        assertEquals(expected, ingredientTest.getFoodId ());
    }

    @Test
    void setFoodId () {
        Long id = (long) 1;
        TIngredients ingredientTest = new TIngredients (id,200, Unit.KILO);
        Long expected = (long) 2;
        ingredientTest.setFoodId (expected);
        assertEquals(expected, ingredientTest.getFoodId ());
    }

    @Test
    void getQuantite () {
        Long id = (long) 1;
        TIngredients ingredientTest = new TIngredients (id,200, Unit.KILO);
        int expected = 200;
        assertEquals(expected, ingredientTest.getQuantite ());
    }

    @Test
    void setQuantite () {
        Long id = (long) 1;
        TIngredients ingredientTest = new TIngredients (id,200, Unit.KILO);
        int expected = 300;
        ingredientTest.setQuantite (expected);
        assertEquals(expected, ingredientTest.getQuantite ());
    }

    @Test
    void getUnite () {
        Long id = (long) 1;
        TIngredients ingredientTest = new TIngredients (id,200, Unit.KILO);
        Unit expected = Unit.KILO;
        assertEquals(expected, ingredientTest.getUnite ());
    }

    @Test
    void setUnite () {
        Long id = (long) 1;
        TIngredients ingredientTest = new TIngredients (id,200, Unit.KILO);
        Unit expected = Unit.GRAMME;
        ingredientTest.setUnite (expected);
        assertEquals(expected, ingredientTest.getUnite ());
    }
}