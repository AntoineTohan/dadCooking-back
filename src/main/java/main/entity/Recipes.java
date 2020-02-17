package main.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String preparation;
    @ManyToMany
    List<Ingredients> ingredients;

    public Recipes (String name, String preparation, List<Ingredients> ingredients) {
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public Recipes () {
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

    public List<Ingredients> getIngredients () {
        return ingredients;
    }

    public void setIngredients (List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
