package main.tobj;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TPdfRecipesTest {

    @Test
    void getRecipeIds () {
        List<Long> recipeIds = new ArrayList<> ();
        recipeIds.add((long)1);
        recipeIds.add((long)2);
        recipeIds.add((long)3);
        TPdfRecipes pdfRecipesest = new TPdfRecipes (recipeIds);
        assertEquals(recipeIds, pdfRecipesest.getRecipeIds ());
    }

    @Test
    void setRecipeIds () {
        List<Long> recipeIds = new ArrayList<> ();
        recipeIds.add((long)1);
        recipeIds.add((long)2);
        recipeIds.add((long)3);
        TPdfRecipes pdfRecipes = new TPdfRecipes (recipeIds);
        List<Long> recipeIdsSet = new ArrayList<> ();
        recipeIds.add((long)4);
        pdfRecipes.setRecipeIds (recipeIdsSet);
        assertEquals(recipeIdsSet, pdfRecipes.getRecipeIds ());
    }
}