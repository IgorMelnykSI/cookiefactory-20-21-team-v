package cookies.manager;

import cookies.Store;

public class StoreManager{

    private Store store;
    private String name;

    public StoreManager(String name,Store store){
        this.name = name;
        this.store = store;
    }

    public void changeOpenTime(String openTime){
        this.store.setOpenTime(openTime);
    }

    public void changeCloseTime(String closeTime){
        this.store.setCloseTime(closeTime);
    }

    public void changeTax(double tax){
        this.store.setTax(tax);
    }

    public void setStoreProblem(boolean i){
        store.setHasProblem(i);
    }

}
