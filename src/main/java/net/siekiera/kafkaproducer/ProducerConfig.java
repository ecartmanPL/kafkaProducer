package net.siekiera.kafkaproducer;

import net.siekiera.kafkaproducer.StringProducer.StringProducer;
import net.siekiera.kafkaproducer.Tickets.Ticket;
import net.siekiera.kafkaproducer.Tickets.TicketProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ProducerConfig {
    @Value("${bootstrap.servers}")
    private String bootstrapServers;
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
    @Value("${string.serializer}")
    private String stringSerializer;
    @Value("${integer.serializer}")
    private String integerSerializer;
    @Value("${ticket.serializer}")
    private String ticketSerializer;
    @Bean
    public StringProducer createStringProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("acks", acks);
        properties.put("retries", retries);
        properties.put("batch.size", batchSize);
        properties.put("linger.ms", lingerMs);
        properties.put("buffer.memory", bufferMemory);
        properties.put("key.serializer", stringSerializer);
        properties.put("value.serializer", stringSerializer);
        Producer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        StringProducer stringProducer = new StringProducer();
        stringProducer.setProperties(properties);
        stringProducer.setProducer(kafkaProducer);

        return stringProducer;
    }

    @Bean
    public TicketProducer createTicketProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("acks", acks);
        properties.put("retries", retries);
        properties.put("batch.size", batchSize);
        properties.put("linger.ms", lingerMs);
        properties.put("buffer.memory", bufferMemory);
        properties.put("key.serializer", integerSerializer);
        properties.put("value.serializer", ticketSerializer);
        Producer<Integer, Ticket> kafkaProducer = new KafkaProducer<Integer, Ticket>(properties);

        TicketProducer ticketProducer = new TicketProducer();
        ticketProducer.setProperties(properties);
        ticketProducer.setProducer(kafkaProducer);

        return ticketProducer;
    }
}
