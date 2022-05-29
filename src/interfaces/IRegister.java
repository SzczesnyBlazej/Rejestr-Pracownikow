package interfaces;
import classes.*;
import java.util.List;



public interface IRegister {

    public abstract <T extends Employees> void addToRegister(T worker);

    public abstract <T extends Employees> void addToRegister(List<T> workers);

    public <T extends Employees> List<T> getWorkersByCity(String address);
    public <T extends Employees> List<T> getWorkersByID();

    public List<Employees> getWorkers();




}
