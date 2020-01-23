package main.entity;

import main.utils.Unit;

import javax.persistence.*;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Food food;
    private int quantite;
    @Enumerated(EnumType.STRING)
    private Unit unite;

    public Ingredients (Food food, int quantite, Unit unite) {
        this.food = food;
        this.quantite = quantite;
        this.unite = unite;
    }

    public Ingredients () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Food getFood () {
        return food;
    }

    public void setFood (Food food) {
        this.food = food;
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
