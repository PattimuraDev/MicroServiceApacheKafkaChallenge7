package org.example.service;

import java.util.Map;

/**
 * Interface service yang menghandle semua permintaan ke apache kafka
 * @author Dwi Satria Patra
 */
public interface KafkaMessageService {
    String processMessage(Map<String, Object> messageBody);
}
