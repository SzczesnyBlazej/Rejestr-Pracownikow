package tests;
import classes.*;

import interfaces.IRegister;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static classes.ManualWorker.forceCalculator;
import static org.junit.Assert.*;

public class firmaTest {
    IRegister register;

    @Before
    public void setUpAll(){
        Address address1=new Address("Starowiejska",59,59,"Kartuzy");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address1,Employees.uniqueIDClerk(),12, (float) 300);

        register = new Register();
    }

    @Test
    public void corporateValueClerk(){
        Address address1=new Address("Starowiejska",59,59,"Kartuzy");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address1,Employees.uniqueIDClerk(),12,(float) 300);
        Integer exp=clerk.getExperience();
        Integer inte=clerk.getIntelect();
        assertEquals(36,exp*inte);
    }
    @Test
    public void corporateValueManualWorker(){
        Address address2=new Address("Długa",39,2,"Kartuzy");
        ManualWorker manualWorker =new ManualWorker(Employees.createID(),"Michał","Erdos",22,5,address2, (float) 71,(float) 300);
        Float power=manualWorker.getForce();
        Integer age=manualWorker.getAge();
        float result=(power/age);
        result=result*100;
        result= Math.round(result);
        result/=100;
        assertEquals(new Float(3.23),new Float(result));
    }
    @Test
    public void corporateValueTrader(){
        Float ile=Trader.feeCalculator();
        assertEquals(new Float(600.00),ile);
    }

    @Test
    public void addToRegister(){
        Address address1=new Address("Starowiejska",59,59,"Kartuzy");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address1,Employees.uniqueIDClerk(),70,(float) 300);
        Trader trader=new Trader(Employees.createID(),"Mariusz","Misiak",31,5,address1,"WYSOKA",0.25,(float) 300);
        register.addToRegister(trader);
        register.addToRegister(clerk);
        assertEquals(2, register.getWorkers().size());


    }

    @Test
    public void intelectTest(){
        String ile=Clerk.intelectCalculator();
        assertEquals("True",ile);
    }

    @Test
    public void forceTest(){
        String ile= forceCalculator();
        assertEquals("True",ile);
    }

    @Test
    public void findByCity(){
        Address address1=new Address("Starowiejska",59,59,"Kartuzy");
        Address address2=new Address("Starowiejska",59,59,"Kiełpino");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address1,Employees.uniqueIDClerk(),70,(float) 300);
        ManualWorker manualWorker =new ManualWorker(Employees.createID(),"Michał","Erdos",22,5,address1, (float) 71,(float) 300);
        ManualWorker manualWorker1 =new ManualWorker(Employees.createID(),"Michał","Erdos",22,5,address2, (float) 71,(float) 300);
        register.addToRegister(clerk);
        register.addToRegister(manualWorker);
        register.addToRegister(manualWorker1);

        assertEquals(2, register.getWorkersByCity("Kartuzy").size());

    }


    @Test
    public void effectivenessTest(){
        Float effectiv=Trader.feeCalculator();
        assertEquals(Float.valueOf(600),effectiv);
    }

    @Test
    public void precentage(){
        Address address1=new Address("Krótka",19,2,"Kartuzy");
        Trader trader=new Trader(Employees.createID(),"Mariusz","Misiak",31,5,address1,"WYSOKA",0.25,(float) 300);
        Double fee=trader.fee;
        assertTrue(fee>0&&fee<1);
    }

    @Test
    public void delUser(){
        Address address2=new Address("Starowiejska",59,59,"Kiełpino");
        Clerk clerk=new Clerk(Employees.createID(),"Bogda","Szulc",23,3,address2,Employees.uniqueIDClerk(),70,(float) 300);
        ManualWorker manualWorker =new ManualWorker(Employees.createID(),"Michał","Erdos",22,5,address2, (float) 71,(float) 300);
        ManualWorker manualWorker1 =new ManualWorker(Employees.createID(),"Marcin","Elos",33,2,address2, (float) 71,(float) 300);
        register.addToRegister(clerk);
        register.addToRegister(manualWorker);
        register.addToRegister(manualWorker1);
        assertEquals(3,register.getWorkers().size());

        String id=manualWorker.getIdEmployer();

        register.getWorkers().removeIf(e -> e.getIdEmployer().equals(id));
        assertEquals(2, register.getWorkers().size());

    }

}
