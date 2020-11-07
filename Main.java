package HospitalSystem;

public class Main {

    public static void main(String[] args)
    {
        HealthSytemManager healthSytemManager = new HealthSytemManager();

        Doctor doctor1 = new Doctor("Dr.Professor","Brain surgeon");
        Patient patient1 = new Patient("sina","2000","Male","Military","Bachelor","Tehran");
//        Case sinaCase2 = new Case("Blood","NOTHING","Test","Test","Test","Test" , doctor1);
        Illness COVID19 = new Illness("COVID-19", "HIGH");
        Case ahmadCase = new Case(COVID19,"He's dying","There is No Hope","Faith","2020",doctor1);



        healthSytemManager.addPatient(patient1);
        healthSytemManager.addDoctor(doctor1);
        healthSytemManager.addCaseToPatient(sinaCase,patient1);
        healthSytemManager.pharmacyMethod(patient1);
//        patient1.print();
//        doctor1.print();
//        sinaCase.print();

    }
}
