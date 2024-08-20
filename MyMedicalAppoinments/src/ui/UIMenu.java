package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static Doctor doctorLogged;
    public static  Patient patientLogged;
    /**
     * Class: UIMenu
     * Description: Show the main menu
     */
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    UIDoctorMenu.showDoctorMenu();
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("Alejandro Martínez", "amartinez@email.com", ""));
        doctors.add(new Doctor("Karen Sosa", "ksosa@email.com", ""));
        doctors.add(new Doctor("Rocío Gómez", "rgomez@email.com", ""));

        ArrayList<Patient> patiens = new ArrayList<Patient>();
        patiens.add(new Patient("Anahí Salgado", "asalgado@email.com"));
        patiens.add(new Patient("Roberto Rodríguez", "rrodriguez@email.com"));
        patiens.add(new Patient("carlos Sánchez", "csanchez@email.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: [email@email.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1){
                for (Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        // Get user data
                        doctorLogged = d;
                        // Show Doctor Menu
                        System.out.println(doctorLogged);
                        System.out.println(d.getAddress() + " - " + email);
                    } else {
                        System.out.println(email);
                    }
                }
            }
            if (userType == 2){
                for( Patient p: patiens){
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }

            }
        } while (!emailCorrect);

    }

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i + ". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
