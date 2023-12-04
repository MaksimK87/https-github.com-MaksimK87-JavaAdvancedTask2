package org.epam.task3;

import java.util.Random;

public class Producer extends Thread {

    private MessageBus messageBus;

    public Producer(MessageBus messageBus) {

        this.messageBus = messageBus;
    }

    @Override
    public void run() {

        final Random random = new Random();
        while (true) {
            String topic = "Topic" + random.nextInt(10);
            String payload = "MessagePayload " + random.nextInt(1000);
            Message message = new Message(topic, payload);
            messageBus.post(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
