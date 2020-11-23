//package cookies.order;
//
//import cookies.CookieItem;
//import cookies.Order;
//import cookies.exceptions.ForbiddenCallInStateException;
//import cookies.exceptions.OnValidationException;
//import cookies.exceptions.StoreAsNotEnoughIngredientsException;
//
//import java.util.Map;
//
//public class EditionState extends State {
//	public EditionState(Order order) {
//		this.order = order;
//	}
//
//	@Override
//	public void valid() throws OnValidationException, StoreAsNotEnoughIngredientsException {
//		if(this.order.getCookieItems().size() > 0) {
//			if(!this.order.getPickUpStore().areRecipesAvailable(this.order.getRecipes())) {
//				throw new StoreAsNotEnoughIngredientsException("Le magasin n'a plus assez d'ingrdients pour assurer " +
//						"votre commande.");
//			}
//			checkPacks();
//			this.order.setState(new DiscountState(this.order));
//		} else
//			throw new OnValidationException("Vous devez avoir au moins une recette pour pouvoir valider votre commande.");
//	}
//
//	@Override
//	void undo() throws ForbiddenCallInStateException {
//		throw new ForbiddenCallInStateException(getState(), "revenir en arrire.");
//	}
//
//	private void checkPacks() {
//		while (true) {	// while we can fill some packs
//			Pack bestPack = null;
//			// searching for the best pack
//			for (Pack pack : this.order.getStore().getPacks()) {
//				if (bestPack != null && bestPack.getCapacity() < pack.getCapacity()
//						&& order.getNumberOfRecipes() >= pack.getCapacity()
//						|| order.getNumberOfRecipes() >= pack.getCapacity()) {
//					bestPack = pack;
//				}
//			}
//			if (bestPack == null)
//				return;
//
//			final Pack finalBestPack;
//			try {
//				finalBestPack = bestPack.clone();    // cloning the orginal pack
//			} catch (CloneNotSupportedException e) {
//				e.printStackTrace();
//				return;
//			}
//
//			finalBestPack.fill(order.getItems());
//			order.addPack(finalBestPack);
//		}
//	}
//
//	@Override
//	public void addItem(CookieItem item, int amount) {
//		Integer val = this.order.getItems().putIfAbsent(item, amount);
//		if(val != null)
//			this.order.getItems().replace(item, val, val + amount);
//
//		this.order.setPrice(this.order.getDutyFreePrice() + item.getPrice() * amount);
//	}
//
//	@Override
//	public void addItems(Map<CookieItem, Integer> items) {
//		items.forEach(this::addItem);
//	}
//
//	@Override
//	public void removeItem(CookieItem item) {
//		removeItems(item, 1);
//	}
//
//	@Override
//	public void removeItems(CookieItem item, int amount) {
//		if(this.order.getItems().containsKey(item)) {
//			Integer val = this.order.getItems().get(item);
//			if (val - amount > 0) {
//				order.getItems().replace(item, val, val - amount);
//				this.order.setPrice(this.order.getDutyFreePrice() - item.getPrice() * amount);
//			} else {
//				val = this.order.getItems().remove(item);
//				this.order.setPrice(this.order.getDutyFreePrice() - item.getPrice() * val);
//			}
//		}
//	}
//
//	@Override
//	public void setAccount(Account account) {
//		this.order.setAccount(account);
//	}
//
//	@Override
//	public OrderState getState() {
//		return OrderState.EDITION;
//	}
//}
