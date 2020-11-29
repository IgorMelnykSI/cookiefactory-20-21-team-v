package cookies.order;

import cookies.Order;

public class FinishState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is finished");
        return "Finished";
    }
}
