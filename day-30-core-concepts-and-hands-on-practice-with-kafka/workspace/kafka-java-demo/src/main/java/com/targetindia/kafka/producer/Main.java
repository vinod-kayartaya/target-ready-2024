package com.targetindia.kafka.producer;

import com.targetindia.utils.KeyboardUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String bootstrapServer = "localhost:9092";
        String topicName = "topic3";

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        String message = KeyboardUtil.getString("Enter message to publish: ");
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, message);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("message published successfully");
            } else {
                System.out.println("there was an error while publishing the message");
                System.out.println(exception.getMessage());
            }
        });
        System.out.println("message sent!");
        producer.close();
    }
}
