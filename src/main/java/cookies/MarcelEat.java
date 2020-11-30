package cookies;

public class MarcelEat implements Subject{
    @Override
    public void pickTheOrder(Order order1) {

        Order order=order1;
        goToStore();
        order.pickTheOrder(order);
        goToCustomer();

    }
    void goToStore(){
        System.out.println("MarcelEat arrives at th store");
    }
    void goToCustomer(){
        System.out.println("MarcelEat goes to the customer");
    }
}
