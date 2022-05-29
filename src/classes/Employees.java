package classes;

import interfaces.IRegister;

import java.util.UUID;

public abstract  class Employees {
    private String idEmployer;
    private String name;
    private String surname;
    private Integer age;
    private Integer experience;
    private Address addressWhereHeWork;
    private Float valueForCompany;





    public Employees(String idEmployer, String name, String surname, Integer age, Integer experience, Address addressWhereHeWork, Float valueForCompany) {
        this.idEmployer = idEmployer;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.addressWhereHeWork = addressWhereHeWork;
        this.valueForCompany=valueForCompany;


    }

    private static long idCounterClerk = 0;
    public static String uniqueIDClerk() {
        return String.valueOf(idCounterClerk++);
    }
    private static long idCounter = 0;

    public static synchronized String createID()
    {
        return String.valueOf(idCounter++);
    }

    public String getIdEmployer() {
        return idEmployer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getExperience() {
        return experience;
    }

    public Address getAddressWhereHeWork() {
        return addressWhereHeWork;
    }

    public Float getValueForCompany() {
        return valueForCompany;
    }


}

