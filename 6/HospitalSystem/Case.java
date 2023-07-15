//package HospitalSystem;

/**
 * This is a case
 */
public class Case
{
    private Illness illnessType;
    private String patientDetails;
    private String doctorAc;
    private String medicine;
    private String date;
    private Doctor doctor;

    /**
     * Create a new Case
     */
    public Case(Illness illness,String patientDetails,String doctorAc,String medicine,String date,Doctor doctor)
    {
        this.illnessType = illness;
        this.patientDetails = patientDetails;
        this.doctorAc = doctorAc;
        this.medicine = medicine;
        this.date = date;
        this.doctor = doctor;
    }

    /**
     * @return illnessType
     */
    public Illness getIllnessType() {
        return illnessType;
    }
    /**
     * @return patientDetails
     */
    public String getPatientDetails() {
        return patientDetails;
    }
    /**
     * @return date
     */
    public String getDate() {
        return date;
    }
    /**
     * @return doctorAc
     */
    public String getDoctorAc() {
        return doctorAc;
    }
    /**
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }
    /**
     * @return medicine
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * Print Case
     */
    public void print()
    {
        System.out.println(illnessType.getName()+"\t"+illnessType.getSecurity()+"\t"+patientDetails+"\t"+doctorAc  + "\t"+medicine +"\t"+date + "\t" + doctor.toString());
    }
}
