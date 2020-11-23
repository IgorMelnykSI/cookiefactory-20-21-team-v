package cookies.recipe;

public class DoughCreator implements IngredientsCreator {
	public Dough createIngredient(String name, double price) {
		return new Dough(name,price);
	}
}
