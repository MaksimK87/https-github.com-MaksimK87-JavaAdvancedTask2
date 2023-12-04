package org.epam.task3;

public class Task3Main {

    public static void main(String[] args) {

        MessageBus messageBus = new MessageBus();
        Consumer consumer1 = new Consumer("Consumer1");
        Consumer consumer2 = new Consumer("Consumer2");
        messageBus.subscribe("Topic1", consumer1);
        messageBus.subscribe("Topic1", consumer2);
        messageBus.subscribe("Topic2", consumer1);
        Producer producer = new Producer(messageBus);
        producer.start();
    }
}
