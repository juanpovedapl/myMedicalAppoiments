package ui;

import java.util.*;

import model.Doctor;

import javax.print.Doc;

public class UIPatientMenu {
    public static void showPatientMenu () {
        int response =0;

        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome:" + UIMenu.patientLogged.getName());
            System.out.println("1. Boook an appointment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout             ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    shoPatientMyAppointment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

            }

        }while (response !=0 );
    }

    private static void showBookAppointmentMenu(){
        int response = 0 ;
        do{
            System.out.println(":: Book an appointment:");
            System.out.println(":: Select a date:");
            //Primer Integer :Numeracion o indice del doctor
            //sEGUNDO INTEGER : NUMERACION O indice de las fechas con appointmet de un doctor
            //[doctors]
            //-1. doctor1
               // -1 fecha 1 cada docttor tiene un array de las citas disponibles
               // -2 fecha 2 cada docttor tiene un array de las citas disponibles
            //-2.  doctor2
            //-3.  doctor3

            Map<Integer , Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k= 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j< availableAppointments.size(); j++){
                    k++;
                    System.out.println(k+". "+ availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointment.get(i));

                    doctors.put(Integer.valueOf(k),doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer,Doctor> doctorAvaliableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","","");

            for (Map.Entry<Integer, Doctor> doc :doctorAvaliableSelected.entrySet()) {

                indexDate = doc.getKey();
                doctorSelected = doc.getValue();

            }
            System.out.println(doctorSelected.getName() +
                    "\n.Date:" +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    "\n.Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n1. Yes \n2. change Data");
            
            response= Integer.valueOf(sc.nextLine());

            if (response == 1) {

                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                System.out.println("appoinmet add successfully");
                showPatientMenu();
            }


        }while (response !=0);
    }

    private static void shoPatientMyAppointment(){
        int response = 0;
        do {
            System.out.println("::My appointment");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appiontment");
                break;

            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println( j + ". "+
                        "\nDate: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }

            System.out.println("O. Return");


        }while (response != 0);
    }
}
