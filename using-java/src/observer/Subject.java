package observer;

public interface Subject {
    void registerObserver(String product, Observer observer);
    void removeObserver(String product, Observer observer);
    void notifyObserver(String product);
}
