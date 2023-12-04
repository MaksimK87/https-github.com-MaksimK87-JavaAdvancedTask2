package org.epam.task3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MessageBus {

    private HashMap<String, List<Consumer>> consumers = new HashMap<>();

    public void subscribe(String topic, Consumer consumer) {

        consumers.computeIfAbsent(topic, s -> new LinkedList<>()).add(consumer);
    }

    public void post(Message message) {

        List<Consumer> topicConsumers = consumers.get(message.getTopic());
        if (topicConsumers != null) {
            topicConsumers.forEach(consumer -> consumer.consume(message));
        }
    }

}
