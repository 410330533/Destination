package com.wzj.destination.baidu;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerProducerBlocking {
    private static final int MAX_SIZE = 5;
    private static final LinkedBlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(5);
    private AtomicInteger count = new AtomicInteger(0);
    public void produce(int number){
        if (buffer.size() == MAX_SIZE){
            System.out.println("缓冲区已满，阻塞生产者 "+number);

        }
        try {
            int n = count.getAndIncrement();
            buffer.put(n);
            System.out.println("生产者 " + number + " 生产了一个产品 "+ (n));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume(int number){

        if (buffer.size() == 0) {
            System.out.println("缓冲区为空，阻塞消费者" + number);

        }
        try {
            int n = buffer.take();
            System.out.println("消费者 " + number +" 消费了一个产品 " + n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        ConsumerProducerBlocking consumerProducer = new ConsumerProducerBlocking();
        for (int i = 0; i < 10; i++){
            final int number = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    consumerProducer.produce(number);
                }
            }).start();
        }
        for (int i = 0; i < 10; i++){
            final int number = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    consumerProducer.consume(number);
                }
            }).start();
        }
    }
}
