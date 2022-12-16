package org.example.service;

import org.example.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

/**
 * Kelas implementasi dari kafka service
 * @author Dwi Satria Patra
 */
@Service
@Transactional
public class KafkaMessageServiceImpl implements KafkaMessageService {

    @Autowired
    KafkaProducer kafkaProducer;

    /**
     * Method untuk memproses suatu pesan/message ke apache kafka
     * @param messageBody body dari pesan/message yang akan diproses dalam bentuk Map
     * @return String pesan bahwa pemrosesan pesan/message sukses
     */
    @Override
    public String processMessage(Map<String, Object> messageBody) {
        String message = messageBody.get("message").toString();
        kafkaProducer.sendKafkaTopic(message);
        return "Message processed";
    }
}
