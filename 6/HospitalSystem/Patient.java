//package HospitalSystem;

import java.util.ArrayList;

/**
 * This is a Patient
 * @author Sina
 * @version 0.1
 */
public class Patient
{
    //Patient Fields
    private String name;
    private String birthDay;
    private String gender;
    private String insuranceType;
    private String education;
    private String address;
    private ArrayList<Doctor> doctors;

    /**
     * Create a new Patient
     */
    public Patient(String name,String birthDay,String gender,String insuranceType,String education,String address)
    {
        doctors = new ArrayList<>();
        this.name = name;
        this.birthDay = birthDay;
        this.insuranceType = insuranceType;
        this.gender = gender;
        this.education = education;
        this.address = address;
    }

    /**
     * @return birthDay
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return doctors
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * @return insuranceType
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * Add a new Doctor
     */
    public void addDoc(Doctor doctor)
    {
        doctors.add(doctor);
    }

    /**
     * Print Doctors
     */
    public void printDoctors()
    {
        for (Doctor doctor : doctors)
        {
            doctor.print();
        }
    }

    /**
     * Print Patient details
     */
    public void print()
    {
        System.out.println(   name+"\t"+
          birthDay+"\t"+
          gender+"\t"+
          insuranceType+"\t"+
          education+"\t"+
          address
);
        }

}
