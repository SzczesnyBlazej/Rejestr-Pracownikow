package classes;


import interfaces.IRegister;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Register implements IRegister {



    private List<Employees> workers;

    public Register() {
        workers = new ArrayList<>();
    }



    public <T extends Employees> List<T> getWorkersByCity(String address) {
        List<T> results = new ArrayList<>();
        for (Employees worker: workers) {
            if (worker.getAddressWhereHeWork().getCityName().equals(address)) {
                results.add((T) worker);
            }

        }

        return results;
    }

    public <T extends Employees> List<T> getWorkersByID() {
        List<T> results = new ArrayList<>();
        for (Employees worker: workers) {
            worker.getIdEmployer();
            {
                results.add((T) worker);
            }
        }
        return results;
    }



    @Override
    public List<Employees> getWorkers() {

        return workers;
    }

    public void setWorkers(List<Employees> workers) {
        this.workers = workers;
    }

    public <T extends Employees> void addToRegister(T worker) {
        workers.add(worker);
    }

    public <T extends Employees> void addToRegister(List<T> workers) {
        for (T worker: workers) {
            addToRegister(worker);
        }

    }
    public static void main(String[] args) {

        IRegister register = new Register();

        Scanner scan = new Scanner(System.in);
        //ADD START EMPLOYER
        Address address20=new Address("Starowiejska",59,1,"Kartuzy");
        Address address19=new Address("Krótka",33,11,"Kiełpino");
        Clerk clerk1=new Clerk(Employees.createID(),"Błażej","Szczesny",21,3,address20,Employees.uniqueIDClerk(),80,new Float(210));
        ManualWorker manualWorker1=new ManualWorker(Employees.createID(),"Marian","Kozik",44,15,address20,new Float(100),new Float((15*100)/44));
        Trader trader1 = new Trader(Employees.createID(),"Michał","Kwiatek",33,12,address19,"NISKA",0.2,new Float(60*12));
        register.addToRegister(clerk1);
        register.addToRegister(manualWorker1);
        register.addToRegister(trader1);


        Integer wyjscie = 1;

        while (wyjscie != 0) {
            System.out.println("Co chcesz wykonać?:");
            System.out.println("   B - Dodanie pacownika biurowego");
            System.out.println("   F - Dodanie pracownik fizycznego");
            System.out.println("   H - Dodanie handlarz");
            System.out.println("   D - Usuń pracownika");
            System.out.println("   ZM - Podaj pracowników z miasta");
            System.out.println("   SN - Podaj pracowników posortowanych po nazwisku");
            System.out.println("   SW - Podaj pracowników posortowanych po wieku");
            System.out.println("   SD - Podaj pracowników posortowanych po doświadczeniu");
            System.out.println("   CV - Podaj pracowników posortowanych po wartości dla firmy");
            System.out.println("   W - Wyjście");
            String worker = scan.nextLine();


            switch (worker) {
                case "B":
                    System.out.println("Podaj adres pracownika:(ulica)");
                    String street = scan.nextLine();

                    System.out.println("Podaj adres pracownika:(numer domu)");
                    Integer housenumber = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(numer lokalu)");
                    Integer localnumber = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(miasto)");
                    String city = scan.nextLine();
                    Address address1 = new Address(street, housenumber, localnumber, city);

                    System.out.println("Podaj imię pracownika");
                    String name = scan.nextLine();

                    System.out.println("Podaj nazwisko pracownika");
                    String surname = scan.nextLine();

                    System.out.println("Podaj wiek pracownika");
                    Integer age = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj doświadczenie pracownika");
                    Integer exp = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj intelekt pracownika");
                    Integer intelect = Integer.valueOf(scan.nextLine());
                    if (intelect < 70 || intelect > 150) {
                        System.out.println("Podany intelekt jest niepoprawny");
                        break;
                    }
                    float valuec = exp * intelect;

                    Clerk clerk = new Clerk(Employees.createID(), name, surname, age, exp, address1, Employees.uniqueIDClerk(), intelect, valuec);

                    register.addToRegister(clerk);

                    break;

                case "F":
                    System.out.println("Podaj adres pracownika:(ulica)");
                    String streetf = scan.nextLine();

                    System.out.println("Podaj adres pracownika:(numer domu)");
                    Integer housenumberf = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(numer lokalu)");
                    Integer localnumberf = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(miasto)");
                    String cityf = scan.nextLine();
                    Address address2 = new Address(streetf, housenumberf, localnumberf, cityf);

                    System.out.println("Podaj imię pracownika");
                    String namef = scan.nextLine();

                    System.out.println("Podaj nazwisko pracownika");
                    String surnamef = scan.nextLine();

                    System.out.println("Podaj wiek pracownika");
                    Integer agef = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj doświadczenie pracownika");
                    Integer expf = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj siłę pracownika");
                    Float forcef = Float.valueOf(scan.nextLine());

                    float valuef = (expf * forcef) / agef;


                    ManualWorker manualWorker = new ManualWorker(Employees.createID(), namef, surnamef, agef, expf, address2, forcef, valuef);
                    register.addToRegister(manualWorker);
                    break;

                case "H":
                    System.out.println("Podaj adres pracownika:(ulica)");
                    String streeth = scan.nextLine();

                    System.out.println("Podaj adres pracownika:(numer domu)");
                    Integer housenumberh = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(numer lokalu)");
                    Integer localnumberh = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj adres pracownika:(miasto)");
                    String cityh = scan.nextLine();

                    Address address3 = new Address(streeth, housenumberh, localnumberh, cityh);

                    System.out.println("Podaj imię pracownika");
                    String nameh = scan.nextLine();

                    System.out.println("Podaj nazwisko pracownika");
                    String surnameh = scan.nextLine();

                    System.out.println("Podaj wiek pracownika");
                    Integer ageh = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj doświadczenie pracownika");
                    Integer exph = Integer.valueOf(scan.nextLine());

                    System.out.println("Podaj efektywność pracownika(WYSOKA/NISKA/ŚREDNIA)");
                    String effective = scan.nextLine();

                    System.out.println("Podaj wysokość prowizji pracownika");
                    Double fee = Double.valueOf(scan.nextLine());

                    Float out = Trader.feeCalculator();

                    Trader trader = new Trader(Employees.createID(), nameh, surnameh, ageh, exph, address3, effective, fee, out);
                    System.out.println(trader);
                    register.addToRegister(trader);
                    break;
                case "D":
                    System.out.println("Lista id które możesz usunąć:");
                    System.out.println("Jakie id chcesz usunąć?:");
                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty");
                        break;
                    }
                    for (Employees e : register.getWorkers()) {
                        System.out.println("ID."+e.getIdEmployer()+". " + e.getName() + " " + e.getSurname() + " " + e.getAddressWhereHeWork().getCityName());

                    }

                    int id = Integer.valueOf(scan.nextLine());

                    System.out.println("Pracownik który został usunięty:");
                    System.out.println(register.getWorkers().get(id).getName()+" "+register.getWorkers().get(id).getSurname()+" "+register.getWorkers().get(id).getAddressWhereHeWork().getCityName()+"\n");
                    register.getWorkers().remove(id);

                    break;
                case "W":
                    System.out.println("Zakończyłeś działanie \n");
                    wyjscie = 0;
                    break;
                case "ZM":

                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty \n");
                        break;
                    } else
                        System.out.println("Podaj miasto");
                    String miasto = scan.nextLine();
                    List<Employees> employeesList = register.getWorkersByCity(miasto);
                    for (Employees e : employeesList) {
                        System.out.println(e.getName() + " " + e.getSurname() + " " + e.getAddressWhereHeWork().getCityName());
                    }
                    break;
                case "SN":
                    List<Employees> employeersList = register.getWorkers().stream().sorted(Comparator.comparing(Employees::getSurname)).collect(Collectors.toList());

                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty \n");
                        break;
                    } else
                        for (Employees e : employeersList) {
                            System.out.println(e.getName() + " " + e.getSurname());
                        }
                    break;
                case "SW":
                    List<Employees> employeerwList = register.getWorkers().stream().sorted(Comparator.comparing(Employees::getAge)).collect(Collectors.toList());
                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty \n");
                        break;
                    } else
                        for (Employees e : employeerwList) {
                            System.out.println(e.getName() + " " + e.getSurname() + " " + e.getAge());
                        }
                    break;
                case "SD":

                    List<Employees> employeerdList = register.getWorkers().stream().sorted(Comparator.comparing(Employees::getExperience).reversed()).collect(Collectors.toList());
                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty \n");
                        break;
                    } else

                        for (Employees e : employeerdList) {
                            System.out.println(e.getName() + " " + e.getSurname() + " " + e.getExperience());
                        }
                    break;
                case "CV":
                    List<Employees> employeerValue = register.getWorkers().stream().sorted(Comparator.comparing(Employees::getValueForCompany).reversed()).collect(Collectors.toList());
                    if (register.getWorkersByID().size() == 0) {
                        System.out.println("Rejestr jest pusty \n");
                        break;
                    } else
                        for (Employees e : employeerValue) {
                            System.out.println(e.getName() + " " + e.getSurname() + " " + e.getValueForCompany());
                        }
                    break;

                case "\n":

                default:
                    System.out.println("Podałeś niewłaściwą opcję \n");
                    break;
            }
        }
    }


}

