package HospitalSystem;

import java.util.ArrayList;

/**
 * This is a Doctor
 */
public class Doctor
{
    private String name;
    private String expertise;
    private ArrayList<Patient> patients;

    /**
     * Create a new Doc
     * @param name is a NAME
     * @param expertise IS A EXPERTISE
     */
    public Doctor(String name , String expertise)
    {
        this.name = name;
        this.expertise = expertise;
        patients = new ArrayList<>();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return expertise
     */
    public String getExpertise() {
        return expertise;
    }

    /**
     * add a new Patient to doctor
     */
    public void addPatient(Patient patient)
    {
        patients.add(patient);
    }

    /**
     * Print Docotr Details
     */
    public void print()
    {
        System.out.println("Doctor: " + this.name + "--- expertise:" + this.expertise);
    }

    /**
     * to String
     */
    @Override
    public String toString() {
        return "Doctor: " + this.name + "--- expertise:" + this.expertise;
    }
}
