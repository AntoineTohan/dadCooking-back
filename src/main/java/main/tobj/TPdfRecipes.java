package main.tobj;

import java.util.List;

public class TPdfRecipes {

    private List<Long> recipeIds;

    public TPdfRecipes () {
    }

    public TPdfRecipes (List<Long> recipeIds) {
        this.recipeIds = recipeIds;
    }

    public List<Long> getRecipeIds () {
        return recipeIds;
    }

    public void setRecipeIds (List<Long> recipeIds) {
        this.recipeIds = recipeIds;
    }
}
