package org.example;

 /*
    Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
    Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
    а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Pair<T, U> {
    T t;
    U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T getFirst() {
        return t;
    }

    public U getSecond() {
        return u;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t + "(" + t.getClass().getSimpleName() + ")" +
                ", u=" + u +"(" + u.getClass().getSimpleName() + ")" +
                '}';
    }
}

