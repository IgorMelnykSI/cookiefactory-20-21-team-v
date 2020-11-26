package cookies.order;

public class DeliveryState implements State {
    @Override
    public String handle() {
        System.out.println("The order is under delivery");
        return "Delivering";
    }
}
