package restaurant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
    public boolean searchByName(String nameFood){

        try {
            RandomAccessFile fptr = new RandomAccessFile(filename, "r");
            //fptr is pount to byte number 0;
            byte[] temp = new byte[20];
//            int x=fptr.readInt();
//            System.out.println(x);
//            fptr.seek(4);
//            fptr.read(temp, 0, 20);
//            System.out.println(new String(temp) + " ");
//
//            fptr.seek(fptr.getFilePointer() + 258-20);
//            //move from the current location (end of the first name)
//            //  for 258 bytes (get us the end of the second name)
//            //  then move back 20 bytes (get us the beginning of the second name)
//            fptr.read(temp, 0, 20);
//            System.out.println(new String(temp) + " ");
//
//            fptr.seek(258 + 4);
//            //Move pointer to the end of the first record
//            //then move away from the second ID (integer of 4 bytes)
//            fptr.read(temp, 0, 20);
//            System.out.println(new String(temp) + " ");
//
//            fptr.seek(258*2 + 4);
//            fptr.read(temp, 0, 20);
//            System.out.println(new String(temp) + " ");
            int record = 0;
            while (fptr.getFilePointer() < fptr.length()){
                fptr.seek(258*record + 4); //seek to position of the next record
                fptr.read(temp, 0, 20);
                String foodNameFromFile = new String(temp);
                if (foodNameFromFile.equalsIgnoreCase(nameFood)){
//                    fptr.seek(fptr.getFilePointer() + 20);
                    fptr.seek(258 * record + 4 + 20 + 20);
                    double price = fptr.readDouble();
                    System.out.println("Prince of " + nameFood + " is" + price);
                    return true;
                }
                record++;
            }

            fptr.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void showNamePrice(short fromStar){
        try {
            RandomAccessFile fpt = new RandomAccessFile(filename, "r");
            byte[] temp = new byte[20];
            for (int record = 0; fpt.getFilePointer() < fpt.length() - 258; record++) {
                fpt.seek(record * 258 + 56); //get to star of the next record
                short starFromFile = fpt.readShort();
                if(starFromFile >= fromStar){
                    fpt.seek(record * 258 + 4);
                    fpt.read(temp, 0, 20);
                    fpt.seek(record * 258 + 44);
                    double price = fpt.readDouble();
                    System.out.println((new String(temp)).trim() + ":" + price);
                }
            }

        } catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void readAllRecord(){
        try{
            RandomAccessFile fptr = new RandomAccessFile(filename, "r");
            while(fptr.getFilePointer() < fptr.length()) {
                byte[] temp = new byte[20];
                int id = fptr.readInt();
                System.out.print(id + " ");
                fptr.read(temp, 0, 20);
                System.out.print(new String(temp) + " ");
                fptr.read(temp, 0, 20);
                System.out.print(new String(temp) + " ");
                double p = fptr.readDouble();
                int cal = fptr.readInt();
                short star = fptr.readShort();
                System.out.println(p + " " + cal + " " + star + " ");
                //read 10 ingredients
                String ingredient = "";
                for (int i = 0; i < 10; i++) {
                    fptr.read(temp, 0, 20);
                    ingredient += (new String(temp)).trim() + ", ";
                }
                System.out.println(ingredient);
                //}
            }
        }   catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean writeOneFoodToFile(Food food){
        try {
            RandomAccessFile fpointer = new RandomAccessFile(filename, "rw");
            fpointer.seek(fpointer.length());

            byte[] temp = new byte[30];
//            String stName = "Chanakarn 65130500205";
//            temp = stName.concat("                                             ").getBytes();
//            fpointer.write(temp, 0, 30);

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
