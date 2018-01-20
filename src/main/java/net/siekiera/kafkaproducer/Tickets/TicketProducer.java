package net.siekiera.kafkaproducer.Tickets;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by W. Siekiera on 20.01.2018
 */
public class TicketProducer {
    private Properties properties;
    private Producer<Integer, Ticket> producer;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setProducer(Producer<Integer, Ticket> producer) {
        this.producer = producer;
    }

    public void produce(String topic, Ticket value) {
        //tutaj skonczylem
        producer.send(new ProducerRecord<>(topic, value));
    }

    public void close() {
        producer.close();
    }
}
