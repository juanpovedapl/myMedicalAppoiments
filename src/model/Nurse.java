package model;

public class Nurse extends User {
    private String speciality;

    Nurse (String name, String email, String speciality){
        super(name, email);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Verde");
        System.out.println("Departamento: Nutriologia, Pediatria");
    }
}
