package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BasicController {

    private final String instanceUuid = UUID.randomUUID().toString();

    @GetMapping
    public ResponseEntity<String> basic(){

        return ResponseEntity.ok("Testing my jenkins connection to EKS. Gateway server ID: " + instanceUuid);
    }
}
