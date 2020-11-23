package cookies.recipe;

public abstract class Ingredients {
	private static int INGREDIENTIDCOUNTER = 0;
	private int id;
	private String type;
	private double price;

	public Ingredients(String name, double price) {
		this.type = name;
		this.price = price;
		this.id = INGREDIENTIDCOUNTER;
		INGREDIENTIDCOUNTER++;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getId() {
		return this.id;
	}
}
