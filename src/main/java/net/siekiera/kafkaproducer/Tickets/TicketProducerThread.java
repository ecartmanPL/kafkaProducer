package net.siekiera.kafkaproducer.Tickets;

/**
 * Created by W. Siekiera on 20.01.2018
 */
public class TicketProducerThread implements Runnable {
    TicketProducer producer;
    String topic;
    TicketCreationService ticketCreationService;

    public TicketProducerThread(TicketProducer producer, String topic, TicketCreationService ticketCreationService) {
        this.producer = producer;
        this.topic = topic;
        this.ticketCreationService = ticketCreationService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3600; i++) {
            Ticket ticket = ticketCreationService.createTicket();
            producer.produce(topic, ticket);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void shutdown() {
        System.out.println("Shutdown method called on thread for topic " + topic);
    }
}
