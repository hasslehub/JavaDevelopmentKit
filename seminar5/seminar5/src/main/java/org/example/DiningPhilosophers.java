package org.example;

import java.util.concurrent.Semaphore;

//  Обедающие философы
//a. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//b. Вилки лежат на столе между каждой парой ближайших философов.
//c. Каждый философ может либо есть, либо размышлять.
//d. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//e. Взятие каждой вилки и возвращение её на стол являются раздельными действиями, которые должны выполняться одно за другим.
public class DiningPhilosophers {

    public void fillForks(Fork[] forks){
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }
    }
    public void run(Philosopher[] philosophersArr, Fork[] forks){
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < philosophersArr.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1) % forks.length];

            if (i == philosophersArr.length-1){
                philosophersArr[i] = new Philosopher(rightFork, leftFork, "Философ № " + (i+1), semaphore);
            } else {
                philosophersArr[i] = new Philosopher(leftFork, rightFork, "Философ № " + (i+1), semaphore);
            }

            Thread thread = new Thread(philosophersArr[i]);
            thread.start();
        }
    }
}
