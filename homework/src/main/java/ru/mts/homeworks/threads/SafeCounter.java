package ru.mts.homeworks.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeCounter {
        public void count(int num, int threadNum) throws InterruptedException{
             List<Thread> threads = new ArrayList<>();
            final AtomicInteger counter = new AtomicInteger(0);
                for (int i = 0; i < threadNum; i++) {
                    Thread thread = new Thread(()->{
                        for (int j = 0; j < num; j++) {
                            counter.getAndIncrement();
                        }
                    });
                    threads.add(thread);
                    thread.start();
                }

                System.out.println("Результат counter "+counter);
        }

}

