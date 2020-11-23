package cookies.recipe;

public abstract class Ingredient {
	private static int INGREDIENTIDCOUNTER = 0;
	private int id;
	private String type;
	private double price;

	public Ingredient(String name, double price) {
		this.type = name;
		this.price = price;
		this.id = INGREDIENTIDCOUNTER;
		INGREDIENTIDCOUNTER++;
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
