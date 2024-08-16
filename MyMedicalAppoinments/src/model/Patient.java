package model;

public class Patient extends User {

    private String birthday;
    private double weight;
    private double height;
    private String blood;

    /**
     * @class Patient
     * @param String name, String email
     */
    public Patient(String name, String email){
        super(name, email);
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return height + " Mts";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getWeight(){
        return this.weight + " Kg.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + weight + "\nHeight: " + height + "\nBlood. " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Patient");
        System.out.println("Complete history from birth");
    }
}
