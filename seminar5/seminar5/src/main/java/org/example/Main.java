package org.example;

public class Main {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[philosophers.length];

        new DiningPhilosophers().fillForks(forks);
        new DiningPhilosophers().run(philosophers, forks);
    }
}
