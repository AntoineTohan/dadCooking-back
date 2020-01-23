package main.TObj;

import main.utils.Unit;

public class TIngredients {
    private Long foodId;
    private int quantite;
    private Unit unite;

    public TIngredients (Long foodId, int quantite, Unit unite) {
        this.foodId = foodId;
        this.quantite = quantite;
        this.unite = unite;
    }

    public Long getFoodId () {
        return foodId;
    }

    public void setFoodId (Long foodId) {
        this.foodId = foodId;
    }

    public int getQuantite () {
        return quantite;
    }

    public void setQuantite (int quantite) {
        this.quantite = quantite;
    }

    public Unit getUnite () {
        return unite;
    }

    public void setUnite (Unit unite) {
        this.unite = unite;
    }
}
