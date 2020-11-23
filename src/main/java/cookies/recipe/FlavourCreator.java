package cookies.recipe;

public class FlavourCreator implements IngredientsCreator {
	public Flavour createIngredient(String name, double price) {
		return new Flavour(name,price);
	}
}
