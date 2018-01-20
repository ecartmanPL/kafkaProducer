package net.siekiera.kafkaproducer.StringProducer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class StringProducer {

    private Properties properties;
    private Producer<String, String> producer;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setProducer(Producer<String, String> producer) {
        this.producer = producer;
    }

    public void produce(String topic, String value) {
        producer.send(new ProducerRecord<>(topic, value));
    }

    public void close() {
        producer.close();
    }
}
