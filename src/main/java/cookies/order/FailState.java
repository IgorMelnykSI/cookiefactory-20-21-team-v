package cookies.order;

public class FailState implements State {
    @Override
    public String handle() {
        System.out.println("The order is failed");
        return "Failed";
    }
}
