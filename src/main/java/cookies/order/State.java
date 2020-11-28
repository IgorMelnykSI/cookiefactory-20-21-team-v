package cookies.order;

import cookies.Order;

public interface State {
    String handle(Order order);
}
