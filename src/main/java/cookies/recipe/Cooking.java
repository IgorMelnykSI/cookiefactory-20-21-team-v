package cookies.recipe;

public class Cooking {
    private String type;
    private double price;

    public Cooking(String type,double price){
         this.type = type;
         this.price= price;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
