package ru.mts.homeworks.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    public void calculate(int number, int threadNum){
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        List<Future<Integer>> futures = new ArrayList<>();
        Long factorialResult = 1L;

        int numSize = number/threadNum;
        for(int count = 1; count<=threadNum; count++){
            int startIndx = count>1?count * numSize:1;
            int endIndx = (count == threadNum)?number+1:(count+1) * numSize;
            Future<Integer> future = executorService.submit(()->{
                int result = 1;
                for (int num = startIndx ; num < endIndx; num++) {
                    result = result * num;
                }

                return result;
            });

            futures.add(future);
        }

        for (Future<Integer> future: futures) {
            try {
                Integer futValue = future.get();
                factorialResult *= futValue;
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }

        }
        System.out.println("Факториал числа "+number+" равен "+factorialResult);
        executorService.shutdown();
    }
}
