package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static HashMap<Integer, Integer> results = new HashMap<>();
    public static Random random = new Random();


    public static void main(String[] args) {

        game(1000);
        Statistic();
    }

    public static void game(int quantity) {
        for (int i = 0; i < quantity; i++) {
            String[] doors = {"Коза", "Коза", "Коза"};
            //автомобиль равновероятно размещён за любой из трёх дверей
            doors[random.nextInt(0, 3)] = "Автомобиль";

            int userChoice = random.nextInt(0, 3);
            int doorNumber = -1;
            int changeDoor = -1;

            System.out.println("Игрок выбрал дверь номером " + (userChoice + 1));


            // ведущий в любом случае обязан открыть дверь с козой (но не ту, которую выбрал игрок)
            // и предложить игроку изменить выбор
            for (int j = 0; j < 3; j++) {
                if (j != userChoice && !doors[j].equals("Автомобиль")) {
                    doorNumber = j;
                    System.out.println("Ведущий открыл дверь с козой под номером " + (doorNumber + 1));
                    break;
                }
            }

            System.out.println("Ведущий предлогает игроку поменять дверь");

            if (random.nextInt(1, 10) % 2 == 0) {
                for (int k = 0; k < 3; k++) {
                    if (k != userChoice && k != doorNumber) {
                    userChoice = k;
                    System.out.println("Игрок изменил свой выбор и открыл дверь номер " + (userChoice + 1));
                    break;
                    }
                }
            }
            else System.out.println("Игрок оставил свой выбор и открыл дверь номер " + (userChoice + 1));

            if (doors[userChoice].equals("Автомобиль")) {
                System.out.println("Игрок выиграл АВТОМОБИЛЬ!!!");
                results.put(i, 1);
            } else {
                System.out.println("Игрок открыл дверь с козой.");
                results.put(i, 0);
            }
            System.out.println();
        }
    }

    public static void Statistic() {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (int i = 0; i < results.size(); i++) {
            descriptiveStatistics.addValue(results.get(i));
        }
        System.out.println("-------------------------------------------------\n\tСтатистика");
        System.out.printf("Количество побед: %.0f (%.1f%%)\n",
                descriptiveStatistics.getSum(),
                (descriptiveStatistics.getSum() / results.size() * 100));
        System.out.printf("Количество поражений: %.0f (%.1f%%)\n\n",
                (results.size() - descriptiveStatistics.getSum()),
                ((results.size() - descriptiveStatistics.getSum()) / results.size() * 100));
    }
}