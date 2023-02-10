
package petworld;

import java.util.Date;
public class Pet{
    String name;
    private Date dateOfBirth;
    private String[] colors;
    private int ID;
    private String type;
    private String gender;
    private Vaccine[] vaccines;

    private int vaccineCount;

    public Pet(String name, int ID, String gender){
        this.name = name;
        this.ID = ID;
        this.gender = gender;
        vaccines = new Vaccine[100];
        vaccineCount = 0;
    }
    public int vaccinate(Vaccine v){
        vaccines[vaccineCount] = v;
        vaccineCount++;
        return vaccineCount;
    }
    public void setGender(String gender){
        if (gender.equalsIgnoreCase("female")|| gender.equalsIgnoreCase("male")){
            this.gender = gender;
        }
        else {
            System.out.println("Animals only have male or female gender.");
        }
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getColors() {
        return colors;
    }

    public int getID() {
        return ID;
    }

    public Vaccine[] getVaccines() {
        return vaccines;
    }

    public int getVaccineCount() {
        return vaccineCount;
    }

    public String getGender(){
        return gender;
    }
    public String getType(){
        return type;
    }
    public boolean setType(String type) {
        String[] typeList = {"dog","cat","fish","rabbit", "bird",
                            "chicken", "python", "raptor","worm", "cricket"};
        for (int i = 0; i < typeList.length; i++){
            if (type.equalsIgnoreCase(typeList[i])){
                this.type = type;
                return true;
            }
        }
        this.type = "unknown";
        return false;
    }
    public void showAllPreventDiseases(){
        if (this.vaccineCount == 0){
            System.out.println("No diseases prevented");
        }
        else {
            for (int i = 0; i < vaccineCount; i++) {
                System.out.println(vaccines[i].getPreventedDisease());
            }
        }
    }
}