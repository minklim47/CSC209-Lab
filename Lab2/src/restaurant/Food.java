package restaurant;

import java.util.Vector;

public class Food {
    int ID;
    String name;
    String category;
    double price;
    int calories;
    short star;
    Vector ingredients;

    public Food(int ID, String name, double price, int calories, short star) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.star = star;
        ingredients = new Vector(10);
    }

    public void setCategory(String category) {
        String[] validCategory = {"noodle", "appetizer", "beef", "pork",
                "vegetarian", "chicken", "seafood", "dessert", "drink"};
        for (String a: validCategory) {
            if (category.equalsIgnoreCase(a)){
                this.category = category;
                return;
            }
        }
        System.out.println("Not valid category");
    }

    public int addIngredient(String newIngredient){
        ingredients.add(newIngredient);
        return ingredients.size();
    }
    public String toString(){
        return name + " " + price + " baht with " + star + "*.";
    }
}
