package com.wzj.destination.baidu;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
    private static final int MAX_SIZE = 5;
    private int count = 0;
    private static final LinkedList<Integer> buffer = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();
    public void produce(int number){
        lock.lock();

        while (buffer.size() == MAX_SIZE){
            System.out.println("缓冲区已满，阻塞生产者 "+number);
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(count++);
        System.out.println("生产者 " + number + " 生产了一个产品 "+ (count - 1));
        empty.signal(); //唤醒所有在empty上等待的消费者，告诉他们现在buffer不为空了

        lock.unlock();
    }

    public void consume(int number){

        lock.lock();

        while (buffer.size() == 0){
            System.out.println("缓冲区为空，阻塞消费者"+number);
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int n = buffer.remove();
        System.out.println("消费者 " + number +" 消费了一个产品 " + n);
        full.signal(); //唤醒所有在full上等待的生产者，告诉他们现在buffer不为满了

        lock.unlock();

    }

    public static void main(String[] args) {
        ConsumerProducer consumerProducer = new ConsumerProducer();
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
