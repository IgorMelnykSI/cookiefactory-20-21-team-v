package cookies.recipe;

public abstract class Ingredient {
	private String type;
	private double price;
	private int duplicate = 1;

	public Ingredient(String name, double price) {
		this.type = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void changeDuplicate(int duplicate){
		this.duplicate = duplicate;
	}
}
