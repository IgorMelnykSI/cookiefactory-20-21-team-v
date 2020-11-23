package cookies.order;


import cookies.CookieItem;
import cookies.Order;
import cookies.customer.Member;
import cookies.exceptions.BadMethodCallException;
import cookies.exceptions.ForbiddenCallInStateException;
import cookies.exceptions.OnValidationException;
import cookies.exceptions.StoreAsNotEnoughIngredientsException;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class State {
	protected Order order;

	abstract void valid() throws OnValidationException, StoreAsNotEnoughIngredientsException, ForbiddenCallInStateException;

	abstract void undo() throws ForbiddenCallInStateException, BadMethodCallException;

	public void addItem(CookieItem item) throws ForbiddenCallInStateException, StoreAsNotEnoughIngredientsException {
		addItem(item, 1);
	}

	public void addItem(CookieItem item, int amount) throws ForbiddenCallInStateException, StoreAsNotEnoughIngredientsException {
		throw new ForbiddenCallInStateException(getState(), "d'ajouter un Item");
	}

	public void addItems(Map<CookieItem, Integer> items) throws ForbiddenCallInStateException, StoreAsNotEnoughIngredientsException {
		throw new ForbiddenCallInStateException(getState(), "d'ajouter un Item");
	}

	public void removeItem(CookieItem item) throws ForbiddenCallInStateException {
		throw new ForbiddenCallInStateException(getState(), "de supprimer un Item");
	}

	public void removeItems(CookieItem item, int amount) throws ForbiddenCallInStateException {
		throw new ForbiddenCallInStateException(getState(), "de supprimer une recete");
	}

//	public void applyDiscount(Discount discount) throws ForbiddenCallInStateException, BadMethodCallException {
//		throw new ForbiddenCallInStateException(getState(), "d'ajouter une réduction");
//	}
//
//	public void removeDiscount(Discount discount) throws ForbiddenCallInStateException {
//		throw new ForbiddenCallInStateException(getState(), "de supprimer une réduction");
//	}

	public void removeDiscounts() throws ForbiddenCallInStateException {
		throw new ForbiddenCallInStateException(getState(), "de supprimer toutes les réductions");
	}

	public void setAccount(Member member) throws ForbiddenCallInStateException {
		throw new ForbiddenCallInStateException(getState(), "de modifier le compte associé à cette commande");
	}

	public abstract OrderState getState();

	public void setCollectTime(LocalDateTime collectTime) throws ForbiddenCallInStateException, BadMethodCallException {
		throw new ForbiddenCallInStateException(getState(), "de modifier la date de récupération de la commande");
	}

	public void pay() throws ForbiddenCallInStateException {
		throw new ForbiddenCallInStateException(getState(), "de payer la commande dans cet état");
	}
}
