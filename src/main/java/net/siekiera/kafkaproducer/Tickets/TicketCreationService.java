package net.siekiera.kafkaproducer.Tickets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by W. Siekiera on 20.01.2018
 */
@Service
public class TicketCreationService {
    Integer probabilityToGenerateValidTicket = 3600;
    private Integer totalValidTicketsProduced = 0;
    Random random = new Random();
    Logger logger = LoggerFactory.getLogger(TicketCreationService.class);

    public Ticket createTicket() {
        if (random.nextInt(probabilityToGenerateValidTicket)==0) {
            totalValidTicketsProduced++;
            return createValidTicket();
        } else {
            return createInvalidTicket();
        }
    }

    private Ticket createValidTicket() {
        logger.info("Creating VALID ticket! Total valid tickets="+totalValidTicketsProduced);
        Calendar calendar = new GregorianCalendar(2018, 0, 20, 20, 00);
        return new Ticket(new Date(), calendar.getTime(), "Salka 605", "VALID TICKET!");
    }

    private Ticket createInvalidTicket() {
        return new Ticket(new Date(), createReasonableDate(), createReasonableLocation(), "invalid ticket");
    }

    private Date createReasonableDate() {
        Integer year = 2018;
        Integer month = random.nextInt(12);
        Integer day = random.nextInt(31)+1;
        Integer hour = random.nextInt(9)+8;//should be 08:00 - 16:00
        Integer minute = random.nextInt(60);
        Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);
        return calendar.getTime();
    }

    private String createReasonableLocation() {
        Integer floorNumber = random.nextInt(9)+1;
        Integer roomNumber = random.nextInt(8)+1;
        StringBuilder sb = new StringBuilder();
        sb.append("Salka ");
        sb.append(floorNumber);
        sb.append("0");
        sb.append(roomNumber);
        return sb.toString();
    }
}
