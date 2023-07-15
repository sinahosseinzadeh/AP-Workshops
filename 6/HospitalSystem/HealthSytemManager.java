//package HospitalSystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a Health System Manager
 */
public class HealthSytemManager
{
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private HashMap<Patient,ArrayList<Case>> cases;
    private ArrayList<Illness> illnesses;

    /**
     * Create a new Health system manager
     */
    public HealthSytemManager()
    {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        cases = new HashMap<>();
    }

    /**
     * Add a new Patient to system
     */
    public void addPatient(Patient patient)
    {
        patients.add(patient);
        cases.put(patient,new ArrayList<>());
    }

    /**
     * Add a new Doctor
     */
    public void addDoctor(Doctor doctor)
    {
        doctors.add(doctor);
    }

    /**
     * Search for a patient
     */
    public void searchPatient(String name)
    {
        for (Patient patient : patients)
        {
            if (patient.getName().equals(name))
            {
                patient.print();
            }
        }
    }

    /**
     * Add patient a case
     */
    public void addCaseToPatient(Case caseToAdd , Patient patient)
    {

        cases.get(patient).add(caseToAdd);
    }

    /**
     * Search for a doctor
     */
    public void searchDoctor(Doctor doctor)
    {
        for (Doctor doctor1 : doctors)
        {
            if (doctor1.getName().equals(doctor.getName()))
            {
                doctor1.print();
                break;
            }
        }
    }

    /**
     * Get Patient Medicine name
     */
    public void pharmacyMethod(Patient patient)
    {
        for (int i = 0 ; i<cases.get(patient).size(); i++)
        {
            cases.get(patient).get(i).print();
        }
    }

    /**
     * Add Doctor to Patient
     */
    public void addDocToPatient(Patient patient, Doctor doctor)
    {
        for (Patient patient1: patients)
        {
            if (patient1.equals(patient))
            {
                patient1.addDoc(doctor);
            }
        }
    }

    /**
     * Add a new Illness
     */
    public void addIllness(Illness illness)
    {
        illnesses.add(illness);
    }


}
