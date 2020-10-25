package cookies.manager;

import cookies.Store;
import cookies.recipe.Recipe;


public class StoreManager extends Store {

    private float tax;
    private String[] day={"mon","tue","wed","thur","fri","sat","sun"};
    private String[] openHour;


    public StoreManager(String n, String a, float t, int i){
        super(n, a, t, i);
        openHour= new String[]{"8:00-16:30","8:00-16:30","8:00-16:30","8:00-16:30","8:00-16:30","9:00-16:00","8:00-12:30"};
    }

    public float getTax(){return tax;}
    public void setTax(float t){tax=t;}
    public String getDay(int i){if (i<0 || i>6){return "wrong day please try again";}else {return day[i];}}
    public String getOpenHour(int i){if (i<0 || i>6){return "wrong day please try again";}else {return openHour[i];}}
    public void setOpenHour(int i,String s){if (i<0 || i>6){System.out.println("wrong day please try again");}else {openHour[i]=s;}}

}
