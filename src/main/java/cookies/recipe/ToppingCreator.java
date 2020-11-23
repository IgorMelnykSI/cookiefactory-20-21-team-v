package cookies.recipe;

public class ToppingCreator implements IngredientsCreator {
	public Topping createIngredient(String name, double price) {
		return new Topping(name,price);
	}
}
