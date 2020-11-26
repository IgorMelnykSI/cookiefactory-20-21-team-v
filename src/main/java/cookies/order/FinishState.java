package cookies.order;

public class FinishState implements State {
    @Override
    public String handle() {
        System.out.println("The order is finished");
        return "Fnished";
    }
}
