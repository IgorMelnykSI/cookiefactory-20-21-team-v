package cookies.recipe;

public class Cooking {
    private String type;
    private double price;

    public Cooking(String type){
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
        if(this.type=="Crunchy")
            this.price=0.3;
        else if(this.type=="Chewy")
            this.price=0.4;
    }
    public double getPrice(){
        return this.price;
    }
}
