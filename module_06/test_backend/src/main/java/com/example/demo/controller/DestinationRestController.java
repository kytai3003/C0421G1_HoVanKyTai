package com.example.demo.controller;

import com.example.demo.model.bean.Bus;
import com.example.demo.model.bean.Destination;
import com.example.demo.model.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/destination/api")
public class DestinationRestController {

    @Autowired
    private IDestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<Destination>> getAll() {
        List<Destination> destinations = destinationService.findAll();
        if (destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }
}
