package java.manager;

import java.recipe.Recipe;
import java.util.HashMap;

class StoreManager {
    private String name;
    private String address;
    private float tax;
    private HashMap<String,Integer> openHours;
    private int in;

    StoreManager(String n,String a,float t,int i){
        name=n;
        address=a;
        tax=t;
        in=i;
        openHours.put("monday",10);
        openHours.put("tuesday",10);
        openHours.put("wednesday",10);
        openHours.put("thursday",10);
        openHours.put("friday",10);
        openHours.put("saturday",8);
        openHours.put("sunday",4);
    }
    private String getName(){return name;}
    private String getAddress(){return address;}
    private float getTax(){return tax;}
    private int getIn(){return in;}
    private void setIn(int t){in=t;}
    private void setName(String n){name=n;}
    private void setAddress(String a){address=a;}
    private void setTax(float t){tax=t;}


    private void makeCookies(Recipe recipe){

    }
}
