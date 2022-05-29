package classes;

public class Address {
    private String nameOfStreet;
    private Integer numberOfHouse;
    private Integer numberOfLocal;
    private String cityName;

    public Address(String nameOfStreet, Integer numberOfHouse, Integer numberOfLocal, String cityName) {
        this.nameOfStreet = nameOfStreet;
        this.numberOfHouse = numberOfHouse;
        this.numberOfLocal = numberOfLocal;
        this.cityName = cityName;
    }
    public String getCityName() {
        return cityName;
    }




}
