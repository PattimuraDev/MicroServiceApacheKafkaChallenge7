package org.example.service;

import java.util.Map;

public interface KafkaMessageService {
    String processMessage(Map<String, Object> messageBody);
}
