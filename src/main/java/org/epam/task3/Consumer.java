package org.epam.task3;

public class Consumer {

    private final String name;

    public Consumer(String name) {

        this.name = name;
    }

    public void consume(Message message) {

        System.out.println(
                "Consumer name: " + name + " ,Topic: " + message.getTopic() + ", Payload: " + message.getPayload());
    }
}
