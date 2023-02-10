package restaurant;

public class Restaurant {
    public static void main(String[] args){
        Food padthai = new Food(1, "padthai", 49,200 ,(short)4);
        System.out.println(padthai.toString());
        padthai.setCategory("noodle");
        padthai.addIngredient("shrimp");
        padthai.addIngredient("noodle");
        padthai.addIngredient("bean sprout");
        padthai.addIngredient("egg");
        System.out.println(padthai.ingredients.elementAt(0) +
                " " + padthai.ingredients.elementAt(2));
        Food tomyum = new Food(2, "Tomyum", 249.50, 500, (short)5);
        tomyum.setCategory("seafood");
        tomyum.addIngredient("shrimp");
        tomyum.addIngredient("lemon");
        tomyum.addIngredient("chilli pepper");

        Food coke = new Food(3, "Coca Cola", 20, 150, (short)3);
        Food pepsi = new Food(4, "Pepsi", 20, 150, (short)3);
        Food Fanta = new Food(5, "Fanta", 20, 150, (short)2);

        Menu menu = new Menu();
        menu.addNewFood(padthai);
        menu.addNewFood(pepsi);
        menu.addNewFood(tomyum);
        menu.addNewFood(coke);
        menu.addNewFood(Fanta);
        menu.showAllFood();
//        menu.removeFood(2);
        menu.showAllFood();
    }
}
