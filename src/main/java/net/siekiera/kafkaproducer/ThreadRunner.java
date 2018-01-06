package net.siekiera.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

public class ThreadRunner implements Runnable {


    public ThreadRunner(Integer partition, Integer threadNumber, SimpleProducer producer) {
        this.partition = partition;
        this.threadNumber = threadNumber;
        this.producer = producer;
    }

    Integer partition;
    Integer threadNumber;
    SimpleProducer producer;

    @Override
    public void run() {
        System.out.println("Started thread nr " + threadNumber);
        for (int i=0; i<10; i++) {
            Random rnd = new Random();
            System.out.println("Producing. Thread#" + threadNumber + "step#" + i);
            producer.produce("testTopic", partition, threadNumber.toString(), UUID.randomUUID().toString());
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished loop in thread" + threadNumber);
    }

    public void shutdown() {
        System.out.println("Shutdown method called on thread nr " + threadNumber);
    }
}
