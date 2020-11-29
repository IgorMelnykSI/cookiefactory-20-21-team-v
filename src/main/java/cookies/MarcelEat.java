package cookies;

public class MarcelEat implements Subject{
    Order order;
    @Override
    public void pickTheOrder(Order order) {

        this.order=order;
        goToStore();
        this.order.pickTheOrder(order);
        goToCustomer();

    }
    void goToStore(){
        System.out.println("MarcelEat arrives at th store");
    }
    void goToCustomer(){
        System.out.println("MarcelEat goes to the customer");
    }
}
