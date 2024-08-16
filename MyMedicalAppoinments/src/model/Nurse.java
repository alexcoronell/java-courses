package model;

public class Nurse extends User {

    private String specialty;

    public Nurse(String name, String email){
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Green Cross Hospital Employee");
        System.out.println("Department: Nutrition");
        System.out.println("Department: Pediatrics");
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
