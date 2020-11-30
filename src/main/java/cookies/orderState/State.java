package cookies.orderState;

import cookies.Order;

public interface State {
    String handle(Order order);
}
