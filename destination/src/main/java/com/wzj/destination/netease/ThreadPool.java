package com.wzj.destination.netease;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    ExecutorService executorService1 = Executors.newFixedThreadPool(5);
    ExecutorService executorService2 = Executors.newCachedThreadPool();
    ExecutorService executorService3 = Executors.newScheduledThreadPool(5);



    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
            0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new PriorityThreadFactory());

    public static class PriorityThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(@NonNull Runnable r) {
           Thread thread = new Thread(r);
           thread.setPriority(4);
           return thread;
        }
    }
}
