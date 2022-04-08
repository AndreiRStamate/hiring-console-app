package com.company;

public interface ISubject {
    void addObserver(User user);
    void removeObserver(User c);
    void notifyAllObservers();
}
