package observer;

import java.util.*;

// Concrete Subject
public class Store implements Subject{
    private Map<String, List<Observer>> productObservers = new HashMap<>();
    private Set<String> availableProducts = new HashSet<>();

    @Override
    public void registerObserver(String product, Observer observer) {
        productObservers.computeIfAbsent(product, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(String product, Observer observer) {
        List<Observer> observers = productObservers.get(product);
        if (observers != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String product) {
        List<Observer> observers = productObservers.get(product);
        if (observers != null) {
            for (Observer observer: observers) {
                observer.update(product);
            }
        }
    }

    public void addNewProduct(String product) {
        System.out.println("\n[STORE]: New product available: " + product);
        availableProducts.add(product);
        notifyObserver(product);
    }

    public boolean isProductAvailable(String product) {
        return availableProducts.contains(product);
    }
}
