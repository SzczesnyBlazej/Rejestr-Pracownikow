package classes;

public class ManualWorker extends Employees {
    public Float force;

    public ManualWorker(String idEmployer, String name, String surname, Integer age, Integer experience, Address addressWhereHeWork, Float force, Float valueForCompany ) {
        super(idEmployer,
                name,
                surname,
                age,
                experience,
                addressWhereHeWork,
                valueForCompany
        );
        this.force = force;
    }
    public static String forceCalculator(){
        float force;
        String result;
        Address address1=new Address("Miejska",1,22,"Warszawa");
        ManualWorker manualWorker =new ManualWorker(Employees.createID(),"Michał","Erdos",22,5,address1, (float) 71, (float) 300);
        force=manualWorker.getForce();
        if(force>100||force<1){
            result="False";
        }
        else{
            result="True";
        }
        return result;

    }

    public Float getForce() {
        return force;
    }

}
