package question2;

public interface Subject {
    void addObserver(Student observer);
    void removeObserver(Student observer);
    void notifyObservers();
}
