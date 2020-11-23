package cookies.recipe;

public abstract class Ingredients {
	private static int INGREDIENTIDCOUNTER = 0;
	private int id;
	private String name;
	private double price;

	public Ingredients(String name, double price) {
		this.name = name;
		this.price = price;
		this.id = INGREDIENTIDCOUNTER;
		INGREDIENTIDCOUNTER++;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return this.id;
	}
}
