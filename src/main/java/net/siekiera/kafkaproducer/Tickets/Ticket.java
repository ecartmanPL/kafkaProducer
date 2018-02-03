package net.siekiera.kafkaproducer.Tickets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by W. Siekiera on 20.01.2018
 */
public class Ticket {
    String encryptedEventName;
    Date eventDate;
    String eventLocation;
    Date ticketCreationDate;
    String uniqueTicketNumber;


    public Ticket(Date ticketCreationDate, Date eventDate, String eventLocation, String encryptedEventName) {
        this.ticketCreationDate = ticketCreationDate;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.encryptedEventName = encryptedEventName;
        this.uniqueTicketNumber = UUID.randomUUID().toString();
    }

    public Date getTicketCreationDate() {
        return ticketCreationDate;
    }

    public void setTicketCreationDate(Date ticketCreationDate) {
        this.ticketCreationDate = ticketCreationDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getUniqueTicketNumber() {
        return uniqueTicketNumber;
    }

    public void setUniqueTicketNumber(String uniqueTicketNumber) {
        this.uniqueTicketNumber = uniqueTicketNumber;
    }

    public String getEncryptedEventName() {
        return encryptedEventName;
    }

    public void setEncryptedEventName(String encryptedEventName) {
        this.encryptedEventName = encryptedEventName;
    }

    @Override
    public String toString() {
        String returnValue=null;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        objectMapper.setDateFormat(sdf);
        try {
            returnValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
