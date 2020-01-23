package main.TObj;

import java.util.List;

public class TRecipes {

    private Long id;
    private String name;
    private String preparation;
    private List<Long> ingredientsIds;

    public TRecipes (Long id, String name, String preparation, List<Long> ingredientsIds) {
        this.id = id;
        this.name = name;
        this.preparation = preparation;
        this.ingredientsIds = ingredientsIds;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPreparation () {
        return preparation;
    }

    public void setPreparation (String preparation) {
        this.preparation = preparation;
    }

    public List<Long> getIngredientsIds () {
        return ingredientsIds;
    }

    public void setIngredientsIds (List<Long> ingredientsIds) {
        this.ingredientsIds = ingredientsIds;
    }
}
