package cookies;

import cookies.recipe.Recipe;

public class Store {
    private String name;
    private String address;
    private float tax;
    private int in;

    public Store(String n, String a, float t, int i){
        name=n;
        address=a;
        tax=t;
        in=i;
        }
    public String getName(){return name;}
    public String getAddress(){return address;}
    public float getTax(){return tax;}
    public int getIn(){return in;}
    public void setIn(int t){in=t;}
    public void setName(String n){name=n;}
    public void setAddress(String a){address=a;}



    private void makeCookies(Recipe recipe){

    }

}
