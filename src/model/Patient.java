package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    int id;
    private String phoneNumber,birthday,blood;
    private double weight, height;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();


    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this,doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient (String name, String email, double height){
        super(name,email);
        this.height = height;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getWeight() {
        return this.weight + " Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height + " m.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday +"\nWeight: "+ getWeight() + "\nHeight: " +
                getHeight()+ "\nBlood: " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente ");
        System.out.println("Historia clinica: EL paciente entró por valoracion con medicina general en urgencias del hospital la otra vida refiriendo fiebre \n" +
                "diciento 'doctor es que se me sube la bilirubina cuando la miro y no me mira y no lo quita la aspirina es un amor  que contamina '");
    }
}