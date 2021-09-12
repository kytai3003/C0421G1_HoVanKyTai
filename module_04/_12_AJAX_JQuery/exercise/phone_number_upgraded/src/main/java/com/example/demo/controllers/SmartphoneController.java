package com.example.demo.controllers;

import com.example.demo.model.entity.Smartphone;
import com.example.demo.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }


    //Cap nhat object
    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editById(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Smartphone smartphoneUpdate = smartphoneService.findById(id).get();

        if (smartphoneUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneUpdate.setModel(smartphone.getModel());
        smartphoneUpdate.setPrice(smartphone.getPrice());
        smartphoneUpdate.setProducer(smartphone.getProducer());

        this.smartphoneService.save(smartphoneUpdate);
        return new ResponseEntity<>(smartphoneUpdate, HttpStatus.OK);
    }
}
