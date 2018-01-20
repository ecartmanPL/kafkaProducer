package net.siekiera.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Topics {
    @Value("#{${topics}}")
    private Map<String, String> topics;

    public Map<String, String> getTopics() {
        return topics;
    }
}
