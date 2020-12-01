package cookies;

import cookies.recipe.Recipe;

public interface Observed_Subject {
    void addObserverStore(Observer store);
    void deleteObserverStore(String name);
}
