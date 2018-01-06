package net.siekiera.kafkaproducer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class CmdRunner implements CommandLineRunner {
    @Autowired
    SimpleProducer producer;

    @Override
    public void run(String... strings) throws Exception {
        final List<Thread> threads = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0; i<4; i++)
        {
            executorService.submit(new ThreadRunner(i, i, producer));
        }
        System.out.println("Threads running!");
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println("Finished!");
    }
}
