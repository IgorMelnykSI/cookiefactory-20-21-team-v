package cookies.recipe;

public class Dough {
    private String type;
    private double price;

    public Dough(String type,double price){
        this.type = type;
        this.price= price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
