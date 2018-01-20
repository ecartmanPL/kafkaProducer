package net.siekiera.kafkaproducer;

import net.siekiera.kafkaproducer.Tickets.TicketCreationService;
import net.siekiera.kafkaproducer.Tickets.TicketProducer;
import net.siekiera.kafkaproducer.Tickets.TicketProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class CmdRunner implements CommandLineRunner {
    @Autowired
    TicketProducer producer;
    @Autowired
    Topics topics;
    @Autowired
    TicketCreationService ticketCreationService;

    @Override
    public void run(String... strings) {
        int numberOfTopics = topics.getTopics().size();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTopics);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, String> topic : topics.getTopics().entrySet()) {
            futures.add(executorService.submit(new TicketProducerThread(producer, topic.getKey(), ticketCreationService)));
        }
        for (int i=0; i<numberOfTopics; i++) {
            try {
                futures.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Threads running!");
        executorService.shutdown();
        System.out.println("Finished!");
    }
}
