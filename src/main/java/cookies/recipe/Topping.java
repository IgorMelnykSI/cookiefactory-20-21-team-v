package cookies.recipe;

public class Topping {
    private String type;
    private double price;

    public Topping(String type){
        this.type = type;
        setPrice();
        this.price=getPrice();
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(){
        if(this.type=="White chocolate"||this.type=="Milk chocolate")
            this.price=0.2;
        else if(this.type=="M&M’s™")
            this.price=0.3;
        else if(this.type=="Reese’s buttercup")
            this.price=0.4;
    }

    public double getPrice(){
        return this.price;
    }

}
