package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.service.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaController {

    @Autowired
    KafkaMessageService kafkaMessageService;

    /**
     * Method controller untuk kebutuhan mengirim message apacha kafka
     * @param body parameter untuk body dari pesan/message
     * @return response entity hasil dari response endpoint API
     */
    @Operation(summary = "Endpoint untuk mengirim kafka message")
    @ApiResponse(
            responseCode = "200",
            description = "Message berhasil dikirim"
    )
    @PostMapping("/post-message")
    public ResponseEntity<Map> postMessage(@RequestBody Map<String, Object> body) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (body.containsKey("message")) {
                String result = kafkaMessageService.processMessage(body);
                System.out.println(body.get("message"));
                response.put("status", "OK");
                response.put("message", "Message Sent Successfully!");
            } else {
                throw new Exception("Failed to Send Message!");
            }
        } catch (Exception e) {
            response.put("status", "Failed!");
            response.put("message", e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
