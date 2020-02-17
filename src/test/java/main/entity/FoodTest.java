package main.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void getId () {
        Food foodTest = new Food ("Farines");
        assertEquals(null, foodTest.getId ());
    }

    @Test
    void setId () {
        Long expected = (long) 1;
        Food foodTest = new Food ("Farines");
        foodTest.setId ((long) 1);
        assertEquals(expected, foodTest.getId ());
    }

    @Test
    void getName () {
        String expected = "Farine";
        Food foodTest = new Food ("Farine");
        assertEquals(expected, foodTest.getName ());
    }

    @Test
    void setName () {
        String expected = "sel";
        Food foodTest = new Food ("Farine");
        foodTest.setName (expected);
        assertEquals(expected, foodTest.getName ());
    }
}