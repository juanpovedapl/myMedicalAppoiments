package ui;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UIMenu {
    public final static String[] MONTHS= {"enero", "febrero", "marzo",
            "abril", "mayo", "junio",
            "julio", "agosto", "septiembre",
            "octubre", "noviembre", "diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
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
                    System.out.println("model.Doctor");
                    response =0;
                    authUser(1);
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
    private  static void authUser(int userType){
        //userTYpe = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor("Laura camila Poveda","camila9792@peliona.com","Medico general"));
                doctors.add(new Doctor("Jesus Poveda","chuchin@malgenios.com","Cirujia General"));
        doctors.add(new Doctor("Juan Pablo Poveda","aa9792@gmail.com","Doctorado en el amor"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Andres Corso","corso@enfermo.com",1.65));
        patients.add(new Patient("Fabricio Roca","Roca@colicos.com",1.89));
        patients.add(new Patient("Aureliano Buendia","AuBuendia@macondo.com",1.65));

        boolean emailCorrecto = false;
        do{
            System.out.println("Insert your email: []alguien@ejemplo.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor doctor: doctors){
                    if (doctor.getEmail().equals(email)){
                        emailCorrecto=true;
                        // Obtener los datos del usuario logueado
                        doctorLogged =doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2){
                for (Patient patient: patients){
                    if (patient.getEmail().equals(email)){
                        emailCorrecto=true;
                        // Obtener los datos del usuario logueado
                        patientLogged =patient;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!emailCorrecto);
    }
    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + "." + MONTHS[i]);
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
