package com.example.multiFilterSpringSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/transport/end-users/clients/test")
    public ResponseEntity<String> clientTest() {
        return ResponseEntity.ok("Client test endpoint.");
    }

    @GetMapping("/api/transport/end-users/drivers/test")
    public ResponseEntity<String> driverTest() {
        return ResponseEntity.ok("Driver test endpoint.");
    }

    @GetMapping("/api/test")
    public ResponseEntity<String> apiTest() {
        return ResponseEntity.ok("API test endpoint.");
    }

    @GetMapping("/web/test")
    public ResponseEntity<String> webTest() {
        return ResponseEntity.ok("Web test endpoint.");
    }

    @GetMapping("/swagger-ui/docs")
    public ResponseEntity<String> publicEndpointTest() {
        return ResponseEntity.ok("Public test endpoint.");
    }
}
