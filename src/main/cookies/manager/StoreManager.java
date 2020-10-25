package cookies.manager;

import cookies.recipe.Recipe;

import java.util.HashMap;

public class StoreManager {
    private String name;
    private String address;
    private float tax;
    private String[] day={"mon","tue","wed","thur","fri","sat","sun"};
    private String[] openHour;
    private int in;

    public StoreManager(String n, String a, float t, int i){
        name=n;
        address=a;
        tax=t;
        in=i;
        openHour= new String[]{"8:00-16:30","8:00-16:30","8:00-16:30","8:00-16:30","8:00-16:30","9:00-16:00","8:00-12:30"};
    }
    public String getName(){return name;}
    public String getAddress(){return address;}
    public float getTax(){return tax;}
    public int getIn(){return in;}
    public void setIn(int t){in=t;}
    public void setName(String n){name=n;}
    public void setAddress(String a){address=a;}
    public void setTax(float t){tax=t;}
    public String getDay(int i){if (i<0 || i>6){return "wrong day please try again";}else {return day[i];}}
    public String getOpenHour(int i){if (i<0 || i>6){return "wrong day please try again";}else {return openHour[i];}}
    public void setOpenHour(int i,String s){if (i<0 || i>6){System.out.println("wrong day please try again");}else {openHour[i]=s;}}


    private void makeCookies(Recipe recipe){

    }
}
