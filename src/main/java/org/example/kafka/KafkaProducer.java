package org.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kelas untuk menghandle kafka producer
 * @author Dwi Satria Patra
 */
@Component
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic}")
    private String kafkaTopic;

    /**
     * Method untuk mengirim sebuah message ke suatu topic apache kafka
     * @param message parameter untuk pesan/message yang ingin dikirimkan
     */
    public void sendKafkaTopic(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }
}

