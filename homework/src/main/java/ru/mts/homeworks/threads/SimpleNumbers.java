package ru.mts.homeworks.threads;

import org.junit.jupiter.api.ClassOrderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleNumbers {
    public void generateNumbers(int n, int threadNum){
        List<Integer> numList = new ArrayList<>();
        List<Integer> simpleList = new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        List<Future<List<Integer>>> futures = new ArrayList<>();

        Random rand = new Random();
        for (int indx = 0; indx < n; indx++) {
            numList.add(rand.nextInt(100)+1);
        }

        int chunckSize = numList.size()/threadNum;
        for (int count = 0; count < threadNum; count++) {
            int startIndx = count * chunckSize;
            int endIndx = (count+1) * chunckSize;

            List<Integer> threadList = new ArrayList<>();
            Future<List<Integer>> future = exec.submit(()->{
                for (int indx = startIndx; indx < endIndx; indx++) {
                    if(numList.get(indx) %2==0){
                        threadList.add(numList.get(indx));
                    }
                }
                return threadList;
            });
            futures.add(future);
        }
        for (Future<List<Integer>> future:futures) {
            try{
                for (int i = 0; i < future.get().size(); i++) {
                    simpleList.add(future.get().get(i));
                }

            }
            catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
        System.out.println("Cписок простых чисел "+simpleList.toString());
        exec.shutdown();
    }
}
