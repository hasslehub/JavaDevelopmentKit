package org.example;

import java.util.concurrent.Semaphore;
public class Philosopher implements Runnable {

    private final Fork leftFork;
    private final Fork rightFork;
    private final String name;
    protected Semaphore ready;


    public Philosopher(Fork leftFork, Fork rightFork, String name, Semaphore ready) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
        this.ready = ready;
    }

    protected void action(String action) throws InterruptedException {
        System.out.println(action);
        Thread.sleep((long) (Math.random() * 200));
    }


    @Override
    public void run() {
        int countEating = 0;
        int maxCountEating = 3;
        try {
            action(name + " тихо размышляет");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (countEating != maxCountEating) {
            try {
                if (rightFork.isFree() && leftFork.isFree()) {
                    ready.acquire();
                    rightFork.setFree(false);
                    leftFork.setFree(false);
                    countEating++;
                    synchronized (leftFork) {
                        action(name + " взял левую вилку");
                        synchronized (rightFork) {
                            action(name + " взял правую вилку и начал есть " +  countEating + " раз");
                        }
                    }
                    endEating();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void endEating() throws InterruptedException {
        action(name + " поел, положил вилки и продолжил тихо размышлять");
        rightFork.setFree(true);
        leftFork.setFree(true);
        ready.release();
    }
}
