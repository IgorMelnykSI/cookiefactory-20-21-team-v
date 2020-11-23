package cookies.order;

public enum OrderState {
	EDITION("edit"),
	COLLECT_TIME("edit date of collect"),
	PAYMENT("payment"),
	VALIDATED("validated"),
	COLLECTED("collected");

	private String state;

	OrderState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}
