package org.example.service;

import org.example.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Service
@Transactional
public class KafkaMessageServiceImpl implements KafkaMessageService {

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public String processMessage(Map<String, Object> messageBody) {
        String message = messageBody.get("message").toString();
        kafkaProducer.sendKafkaTopic(message);
        return "Message processed";
    }
}
