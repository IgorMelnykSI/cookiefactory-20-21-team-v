package cookies.manager;

import cookies.MarcelEat;
import cookies.Order;
import cookies.Store;
import cookies.Subject;
import cookies.order.FinishState;

public class StoreManager{

    private Store store;
    private String name;
    private Subject marcelEat;

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

    public void contactMarcelEat(Order or){
        Order order=or;
        if(order.getTheWay()=="MarcelEat"){
            marcelEat=new MarcelEat();
            marcelEat.pickTheOrder(order);
            order.setState(new FinishState());
        }
    }
}
