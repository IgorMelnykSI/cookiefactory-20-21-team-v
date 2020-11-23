package cookies.exceptions;


import cookies.order.OrderState;

public class ForbiddenCallInStateException extends Exception {
	public ForbiddenCallInStateException(OrderState state, String message) {
		super("In this validation state (" + state + "), you do not have the rightDans " + message + ".\n");
	}
}
