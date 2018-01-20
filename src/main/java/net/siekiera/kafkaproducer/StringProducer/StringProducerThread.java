package net.siekiera.kafkaproducer.StringProducer;

import java.util.Date;
import java.util.UUID;


public class StringProducerThread implements Runnable {

    public StringProducerThread(StringProducer producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    StringProducer producer;
    String topic;

    @Override
    public void run() {
        System.out.println("Started thread for topic " + topic);
        for (int i = 0; i < 1000; i++) {
            Date date = new Date();
            System.out.println("Producing. Topic=" + topic + " step#" + i);

            producer.produce(topic, date.toString() + ":" + UUID.randomUUID().toString());
        }
        System.out.println("Finished thread for topic " + topic);
    }


    public void shutdown() {
        System.out.println("Shutdown method called on thread for topic " + topic);
    }
}
