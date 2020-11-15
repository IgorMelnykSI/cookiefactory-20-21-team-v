package cookies.recipe;

public class Flavour {
    private String type;
    private final double price=0.1;

    public Flavour(String type){
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice(){
        return this.price;
    }
}
