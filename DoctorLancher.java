public class DoctorLancher{
   
   
   
    public static void main(String[] args){
        //create obj
        Doctor dt = new Doctor();
        Surgeon sg = new Surgeon();
        FamilyDoctor fd = new FamilyDoctor();

        //initialize
        dt.worksAtHospital = true;
        sg.worksAtHospital = true;
        fd.worksAtHospital = false;

        //method
        sg.treatPatient();
        fd.treatPatient();
        fd.giveAdvice();
        dt.treatPatient();
    }
    
}