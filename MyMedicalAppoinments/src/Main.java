import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import static ui.UIMenu.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Doctor myDoctor = new Doctor("John Doe", "jdoe@email.com", "Pediatrician");
        myDoctor.availableAppointment(new Date(), "4pm");
        myDoctor.availableAppointment(new Date(), "10pm");
        myDoctor.availableAppointment(new Date(), "1pm");

        System.out.println(myDoctor);

        /*
        System.out.println(myDoctor.getAvailableAppointment());
        for (Doctor.AvailableAppointment availableAppointment: myDoctor.getAvailableAppointment()){
            System.out.println(availableAppointment.getDate() + " " + availableAppointment.getTime());
        }
         */

        //Polimorfismo
        User user1 = new Doctor("Name Patient", "email@email", "Nutrition");
        user1.showDataUser();
        User user2 = new Patient("Name Patient", "email@email");
        user2.showDataUser();

        // Clases anónimas
        User user3 = new User("Anonymous class", "ac@email.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Blue Cross Hospital");
                System.out.println("Department: Geriatrics");
            }
        };

        user3.showDataUser();

        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {
                System.out.println();
            }
        }

        Patient patient = new Patient("Alex", "alex@email.com");
        patient.setWeight(70.5);
        patient.setPhoneNumber("12345678");

        Patient patient2 = new Patient("John", "john@email.com");
        System.out.println(patient.toString());

        //showMenu();

    }
}
