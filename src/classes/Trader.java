package classes;

public class Trader extends Employees {
    public String effective;
    public double fee;


    public Trader(String idEmployer, String name, String surname, Integer age, Integer experience, Address addressWhereHeWork, String effective, double fee,Float valueForCompany ) {
        super(idEmployer,
                name,
                surname,
                age,
                experience,
                addressWhereHeWork,
                valueForCompany
        );
        this.effective = effective;
        this.fee = fee;
    }

    public static Float feeCalculator(){
        Address address3=new Address("Krótka",19,2,"Kartuzy");
        Trader trader=new Trader(Employees.createID(),"Mariusz","Misiak",31,5,address3,"WYSOKA",3, (float) 300);
        Integer exp=trader.getExperience();
        String fee=trader.getEffective();
        Float out= Float.valueOf(0);
        if(fee=="NISKA"){
            Integer results=60;
            out= Float.valueOf(results*exp);

        }
        else if(fee=="ŚREDNIA"){
            Integer results=90;
            out= Float.valueOf(results*exp);

        }
        else if(fee=="WYSOKA"){
            Integer results=120;
            out= Float.valueOf(results*exp);

        }
        return out;
    }


    public String getEffective() {
        return effective;
    }


}
