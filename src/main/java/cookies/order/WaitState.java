package cookies.order;

public class WaitState implements State {
    @Override
    public String handle() {
        System.out.println("The order is waiting for pick up");
        return "Wait for pick up";
    }
}
