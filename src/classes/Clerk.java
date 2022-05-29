package classes;


public class Clerk extends Employees {
    public String idPosition;
    public Integer intelect;

    public Clerk(String idEmployer, String name, String surname, Integer age, Integer experience, Address addressWhereHeWork,String idPosition, Integer intelect, Float valueForCompany ) {
        super(idEmployer,
                name,
                surname,
                age,
                experience,
                addressWhereHeWork,
                valueForCompany
        );
        this.idPosition = idPosition;
        this.intelect = intelect;
    }
    public static String intelectCalculator(){
        String out;
        Address address1=new Address("Miejska",1,22,"Warszawa");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address1,Employees.uniqueIDClerk(),71, new Float(300));
        Integer intelect=clerk.getIntelect();
        if(intelect<70||intelect>150){
            out="False";
        }
        else{
            out="True";
        }
        return out;
    }



    public Integer getIntelect() {
        return intelect;
    }


}
