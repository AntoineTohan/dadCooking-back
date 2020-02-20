package main.tobj;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TRecipesTest {

    @Test
    void getId () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        Long expected = (long) 1;
        TRecipes recipeTest = new TRecipes (expected, "Test", "Preparation",ingredientIds);
        assertEquals(expected, recipeTest.getId ());
    }

    @Test
    void setId () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        Long id = (long) 1;
        TRecipes recipeTest = new TRecipes (id, "Test", "Preparation",ingredientIds);
        Long expected = (long) 2;
        recipeTest.setId (expected);
        assertEquals(expected, recipeTest.getId ());
    }

    @Test
    void getPreparation () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        String expected = "Preparation";
        TRecipes recipeTest = new TRecipes ((long) 1, "Test", expected,ingredientIds);
        assertEquals(expected, recipeTest.getPreparation ());
    }

    @Test
    void setPreparation () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        String preparation = "Preparation";
        TRecipes recipeTest = new TRecipes ((long) 1, "Test", preparation,ingredientIds);
        String expected = "Preparation 2";
        recipeTest.setPreparation (expected);
        assertEquals(expected, recipeTest.getPreparation ());
    }

    @Test
    void getName () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        String expected = "Test";
        TRecipes recipeTest = new TRecipes ((long) 1, expected, "Preparation",ingredientIds);
        assertEquals(expected, recipeTest.getName ());
    }

    @Test
    void setName () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);

        String name = "Test";
        TRecipes recipeTest = new TRecipes ((long) 1, name, "Preparation",ingredientIds);
        String expected = "Test 2";
        recipeTest.setName (expected);
        assertEquals(expected, recipeTest.getName ());
    }

    @Test
    void getIngredientsIds () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);
        TRecipes recipeTest = new TRecipes ((long) 1, "Test", "Preparation",ingredientIds);
        assertEquals(ingredientIds, recipeTest.getIngredientsIds ());
    }

    @Test
    void setIngredientsIds () {
        List<Long> ingredientIds = new ArrayList<> ();
        ingredientIds.add((long)1);
        ingredientIds.add((long)2);
        ingredientIds.add((long)3);
        TRecipes recipeTest = new TRecipes ((long) 1, "Test", "Preparation",ingredientIds);
        List<Long> expected = new ArrayList<> ();
        ingredientIds.add((long)4);
        ingredientIds.add((long)5);
        recipeTest.setIngredientsIds (expected);
        assertEquals(expected, recipeTest.getIngredientsIds ());
    }
}