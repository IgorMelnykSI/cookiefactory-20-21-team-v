package cookies.order;

public class MakeState implements State {
    @Override
    public String handle() {
        System.out.println("The order is being maked");
        return "Making";
    }
}
