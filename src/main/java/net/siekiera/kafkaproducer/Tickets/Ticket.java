package net.siekiera.kafkaproducer.Tickets;

import java.util.Date;
import java.util.UUID;

/**
 * Created by W. Siekiera on 20.01.2018
 */
public class Ticket {
    String eventName;
    Date eventDate;
    String eventLocation;
    Date ticketCreationDate;
    String uniqueTicketNumber;


    public Ticket(Date ticketCreationDate, Date eventDate, String eventLocation, String eventName) {
        this.ticketCreationDate = ticketCreationDate;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventName = eventName;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
