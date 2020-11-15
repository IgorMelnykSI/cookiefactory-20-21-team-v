package cookies.recipe;

public class Dough {
    private String type;
    private double price;

    public Dough(String type){
        this.type = type;
        setPrice();
        this.price=getPrice();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(){
        if(this.type=="Plain")
            this.price=2.0;
        else if(this.type=="Chocolate")
            this.price=2.4;
        else if(this.type=="Peanut butter")
            this.price=2.5;
        else if(this.type=="Oatmeal")
            this.price=2.6;
    }

    public double getPrice(){
        return this.price;
    }
}
