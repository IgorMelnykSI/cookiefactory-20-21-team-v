package java.customer;

public class Member extends Tourist{

    private int id;
    private boolean isLoyal;
    private static int numberOfAccount = -1;
    private int cookiesOrdered;  //the number of my ordered cookies
    private double loyalDiscount;
    private String name;

    public Member(String name){
        this.name = name;
        this.isLoyal = false;
        this.id = ++numberOfAccount;
        cookiesOrdered = 0;
    }

    public void registerLoyal(){
        isLoyal = true;
        loyalDiscount = 0.1;
    }

    public boolean hasDiscount(){     // check if the client has discount
        return loyalDiscount > 0;
    }

    /**
     * get and reset the loyalty discount
     */
    public double applyLoyaltyDiscount() {
        if(this.hasDiscount()){
            this.loyalDiscount = 0;
            this.cookiesOrdered = 0;
            return 0.1;
        }
        return 0;
    }

    public int  getId() {
        return id;
    }

    public boolean isLoyal() {
        return isLoyal;
    }

    public String getName() {
        return name;
    }

    public int getCookiesOrdered() {
        return cookiesOrdered;
    }
}
