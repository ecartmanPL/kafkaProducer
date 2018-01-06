package net.siekiera.kafkaproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;
public class SimpleProducer{
    private String test;
    private Properties properties;
    private Producer<String, String> producer;
    @Value("${bootstrap.servers}")
    private String bootstrapServers="abc";
    @Value("${acks}")
    private String acks;
    @Value("${retries}")
    private String retries;
    @Value("${batch.size}")
    private String batchSize;
    @Value("${linger.ms}")
    private String lingerMs;
    @Value("${buffer.memory}")
    private String bufferMemory;
    @Value("${key.serializer}")
    private String keySerializer;
    @Value("${value.serializer}")
    private String valueSerializer;

    @PostConstruct
    public void init() {
        properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("acks", acks);
        properties.put("retries", retries);
        properties.put("batch.size", batchSize);
        properties.put("linger.ms", lingerMs);
        properties.put("buffer.memory", bufferMemory);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);
        producer = new KafkaProducer<String, String>(properties);
    }

    public void produce(String topic, Integer partition, String key, String value) {
        producer.send(new ProducerRecord<String, String>(topic, partition, key, value));
    }

    public void close() {
        producer.close();
    }

    public void setTest(String test) {
        this.test = test;
    }
}
