package cookies.recipe;


public class Mix {

    private String type;
    private double price;
    public Mix(String type){
        this.type = type;
        setPrice();
        this.price=getPrice();
    }
    public String getType() {
        return type;
    }
    public void setPrice(){
        if(this.type=="Mixed")
            this.price=0.2;
        else if(this.type=="Topped")
            this.price=0.3;
    }
    public double getPrice(){
        return this.price;
    }
    public void setType(String type) {
        this.type = type;
    }

}
