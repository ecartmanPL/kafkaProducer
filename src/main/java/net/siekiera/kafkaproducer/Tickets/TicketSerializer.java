package net.siekiera.kafkaproducer.Tickets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by W. Siekiera on 20.01.2018
 */
public class TicketSerializer implements Serializer<Ticket> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Ticket ticket) {
        byte[] returnValue = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        objectMapper.setDateFormat(sdf);
        try {
            returnValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ticket).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public void close() {

    }
}
