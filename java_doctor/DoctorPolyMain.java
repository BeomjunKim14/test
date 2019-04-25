package java_doctor;


public class DoctorPolyMain{
    public static void main(String [] args){
        Doctor [] doctors = new Doctor[2];

        doctors[1] = new Surgeon();
        doctors[0] = new FamilyDoctor();

        for(int i = 0 ; i< doctors.length ; i++){
            doctors[i].treatPatient();
        }
        FamilyDoctor fd =(FamilyDoctor)doctors[0];
        fd.giveAdvice();
        if (doctors[0] instanceof FamilyDoctor){
            
        }
    }
}