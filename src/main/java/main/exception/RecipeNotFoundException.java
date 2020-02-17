package main.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException (Long id) {
        super("Could not find recipe " + id);
    }
    public RecipeNotFoundException (String message) {
        super("Error generating pdf due to : " + message);
    }
}