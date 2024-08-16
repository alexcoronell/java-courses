package model;

import java.util.Date;
import java.util.ArrayList;

public class Doctor extends User {

    private String specialty;

    /**
     * @class Patient
     * @param String name, String email
     */
    public Doctor(String name, String email, String specialty){
        super(name, email);
        this.specialty = specialty;
    }

    // Methods

    /**
     * Description: Show the property name in console
     */
    public void showName() {
        System.out.println(this.getName());
    }

//    public void showId(){
//        System.out.println("ID Doctor: " + id);
//    }

    ArrayList<AvailableAppointment> availableAppointment = new ArrayList<AvailableAppointment>();

    public void availableAppointment(Date date, String time){
        availableAppointment.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialty: " + specialty + "\nAvailable: " + availableAppointment.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Red Cross Hospital Employee");
        System.out.println("Department: Traumatology");
        System.out.println("Department: Hematology");
    }

    public static class AvailableAppointment{
        private int id_availableAppointment;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments: \nDate: " + date + "\nTime: " + time;
        }
    }

}
