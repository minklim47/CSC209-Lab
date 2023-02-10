package restaurant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    Food[] foods;
    int amountOfFood;
    String filename;
    public Menu(){
        foods = new Food[30];
        amountOfFood = 0;
        filename = "menu.dat";
    }
    public int addNewFood(Food newFood){
        foods[amountOfFood] = newFood;
        amountOfFood++;
        writeOneFoodToFile(newFood);
        return amountOfFood;
    }
    public boolean removeFood(int foodID) {
        for (int i = 0; i < amountOfFood; i++){
            if (foods[i].ID == foodID){
                for (int j = i + 1; j < amountOfFood - 1; j++){
                    foods[j] = foods[j+1];
                }
                amountOfFood--;
                return true;
            }
        }
        return false;
    }
    public void showAllFood(){
        for (int i = 0; i < amountOfFood; i++){
            System.out.print(foods[i].ID + ")" + foods[i].name + " ");
        }
        System.out.println("");
    }
//    int ID;               4 bytes
//    String name;          20 bytes
//    String category;      20 bytes
//    double price;         8 bytes
//    int calories;         4 bytes
//    short star;           2 bytes
//    Vector ingredients;   20 * 10 = 200 bytes
// Therefore 1 record = 4+20+20+8+4+2+200 = 258 bytes
    public boolean writeOneFoodToFile(Food food){
        try {
            RandomAccessFile fpointer = new RandomAccessFile(filename, "rw");
            fpointer.seek(fpointer.length());

            byte[] temp = new byte[30];
            String stName = "Chanakarn 65130500205";
            temp = stName.concat("                                             ").getBytes();

            fpointer.write(temp, 0, 30);
            fpointer.writeInt(food.ID);
            temp = food.name.concat("                               ").getBytes();
            fpointer.write(temp, 0, 20);

            if (food.category != null){
                temp = food.category.concat("                                  ").getBytes();
            } else {
                temp = "".concat("                                      ").getBytes();
            }
            fpointer.write(temp,0,20);
            fpointer.writeDouble(food.price);
            fpointer.writeInt(food.calories);
            fpointer.writeShort(food.star);
            int i = 0, j;
            for (j = 0; j < food.ingredients.size(); j++){
                String t = ((String) food.ingredients.elementAt(j));
                temp = t.concat("                            ").getBytes();
                fpointer.write(temp, 0, 20);
            }
            for (i += j; i < 10; i++){
                temp = "                                ".getBytes();
                fpointer.write(temp, 0, 20);
            }
        } catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
