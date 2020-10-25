package cookies;

public class Store {
    private String name;
    private String address;
    protected String openTime;
    protected String closeTime;
    private double tax;

    public Store(String name, String address, String openTime, String closeTime, double tax){
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.tax = tax;
    }

    public String getName(){return name;}
    public String getAddress(){return address;}

    public String getCloseTime() {
        return closeTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public double getTax(){return tax;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
