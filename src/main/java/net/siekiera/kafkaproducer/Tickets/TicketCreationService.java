package net.siekiera.kafkaproducer.Tickets;

import net.siekiera.kafkaproducer.EncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by W. Siekiera on 20.01.2018
 */
@Service
public class TicketCreationService {
    // Probability to generate valid ticket. One valid ticket will be generated for every n tickets.
    private Integer n = 300;
    private Random random = new Random();
    private final Logger logger = LoggerFactory.getLogger(TicketCreationService.class);
    @Value("${proper.event.name}")
    private String properEventName;
    @Autowired
    EncryptionService encryptionService;

    public Ticket createTicket() {
        if (random.nextInt(n)==0) {
            return createValidTicket();
        } else {
            return createInvalidTicket();
        }
    }

    private Ticket createValidTicket() {
        Calendar calendar = new GregorianCalendar(2018, 0, 20, 20, 00);
        String encryptedEventName = encryptionService.encrypt(properEventName);
        Ticket ticket = new Ticket(new Date(), calendar.getTime(), "Salka 605", encryptedEventName);
        logger.info("Valid ticket created:\n" + ticket.toString());
        return ticket;
    }

    private Ticket createInvalidTicket() {
        String encryptedEventName = encryptionService.encrypt(UUID.randomUUID().toString());
        return new Ticket(new Date(), createReasonableDate(), createReasonableLocation(), encryptedEventName);
    }

    private Date createReasonableDate() {
        Integer year = 2018;
        Integer month = random.nextInt(12);
        Integer day = random.nextInt(31)+1;
        Integer hour = random.nextInt(9)+8;//should be 08:00 - 16:00
        Integer minute = random.nextInt(4) * 15;//should be 0, 15, 30 or 45
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
