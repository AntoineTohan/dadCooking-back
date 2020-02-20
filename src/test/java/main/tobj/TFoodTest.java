package main.tobj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TFoodTest {

    @Test
    void getId () {
        TFood foodTest = new TFood ("Farines");
        assertEquals(null, foodTest.getId ());
    }

    @Test
    void setId () {
        Long expected = (long) 1;
        TFood foodTest = new TFood ("Farines");
        foodTest.setId ((long) 1);
        assertEquals(expected, foodTest.getId ());
    }

    @Test
    void getName () {
        String expected = "Farine";
        TFood foodTest = new TFood ("Farine");
        assertEquals(expected, foodTest.getName ());
    }

    @Test
    void setName () {
        String expected = "sel";
        TFood foodTest = new TFood ("Farine");
        foodTest.setName (expected);
        assertEquals(expected, foodTest.getName ());
    }
}