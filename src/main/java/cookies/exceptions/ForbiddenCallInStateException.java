package cookies.exceptions;



import cookies.order.State;

public class ForbiddenCallInStateException extends Exception {
	public ForbiddenCallInStateException(State state, String message) {
		super("In this validation state (" + state + "), you do not have the rightDans " + message + ".\n");
	}
}
