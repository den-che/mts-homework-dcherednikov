package ru.mts.homeworks.app;

import ru.mts.homeworks.threads.Factorial;
import ru.mts.homeworks.threads.SafeCounter;
import ru.mts.homeworks.threads.SimpleNumbers;

public class ThreadApplication {
    public static void main(String[] args) throws InterruptedException{
        SafeCounter safeCounter = new SafeCounter();
        System.out.println("Задание №2 Потокобезопасный счетчик");
        safeCounter.count(2,4);

        Factorial factorial = new Factorial();
        System.out.println("Задание №4 Параллельное вычисление факторила");
        factorial.calculate(20,3);

        System.out.println("Задание №5 Параллельная генерация простых чисел");
        SimpleNumbers simpleNumbers = new SimpleNumbers();
        simpleNumbers.generateNumbers(6,3);

    }
}
