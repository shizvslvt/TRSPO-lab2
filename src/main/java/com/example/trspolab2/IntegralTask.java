package com.example.trspolab2;

import java.util.concurrent.Callable;

public class IntegralTask implements Callable<Double> {
    private final double a;
    private final double h;
    private final long start;
    private final long end;
    private final Function function;
    private double threadSum;

    public IntegralTask(double a, double h, long start, long end, Function function) {
        this.a = a;
        this.h = h;
        this.start = start;
        this.end = end;
        this.function = function;
        this.threadSum = 0.0;
    }

    @Override
    public Double call() {
        System.out.println(Thread.currentThread() + ": start = " + start + ", end = " + end);
        for (long i = start; i < end; i++) {
            threadSum += function.calc(a + i * h);
        }
        return threadSum;
    }

}
