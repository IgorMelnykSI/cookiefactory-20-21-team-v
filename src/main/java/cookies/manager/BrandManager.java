package cookies.manager;

import cookies.CookieFactory;



public class BrandManager {
    private String name;
    private CookieFactory factory;



    public BrandManager(String name){
        this.name = name;
        this.factory = new CookieFactory();
    }


    public CookieFactory getFactory() {
        return factory;
    }

}
