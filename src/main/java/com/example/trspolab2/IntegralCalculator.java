package com.example.trspolab2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class IntegralCalculator {
    private final int numThreads;

    public IntegralCalculator(int numThreads) {
        this.numThreads = numThreads;
    }

    public double calculate(double a, double b, long n, Function f) {
        double h = (b-a)/n;
        double sum = (f.calc(a)+f.calc(b))/2;
        ExecutorService es = Executors.newFixedThreadPool(numThreads);
        List<Future<Double>> futures = new ArrayList<>();

        long step = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            long start = i*step;
            long end = (i+1)*step;

            Callable<Double> task = new IntegralTask(a, h, start, end, f);
            futures.add(es.submit(task));
        }

        es.shutdown();

        try {
            for (Future<Double> future : futures) {
                sum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return sum*h;
    }
}
