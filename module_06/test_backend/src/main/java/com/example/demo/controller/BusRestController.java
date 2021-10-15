package com.example.demo.controller;

import com.example.demo.model.bean.Bus;
import com.example.demo.model.service.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus/api")
public class BusRestController {

    @Autowired
    private IBusService iBusService;

    @GetMapping
    public ResponseEntity<List<Bus>> getAll() {
        List<Bus> buses = iBusService.findAll();
        if (buses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Bus> findById(@PathVariable int id) {
        return new ResponseEntity<>(this.iBusService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBus(@RequestBody Bus bus) {
        this.iBusService.save(bus);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBus(@RequestBody Bus bus, @PathVariable int id) {
        Optional<Bus> updateBus = this.iBusService.findById(id);

        if (updateBus.isPresent()) {
            updateBus.get().setBusEmail(bus.getBusEmail());
            updateBus.get().setBusName(bus.getBusEmail());
            updateBus.get().setBusPhone(bus.getBusPhone());
            updateBus.get().setBusType(bus.getBusType());
            updateBus.get().setDestinationFrom(bus.getDestinationFrom());
            updateBus.get().setDestinationTo(bus.getDestinationTo());
            updateBus.get().setHourFrom(bus.getHourFrom());
            updateBus.get().setHourTo(bus.getHourTo());
            this.iBusService.save(updateBus.get());
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<> (HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        Optional<Bus> deleteBus = this.iBusService.findById(id);

        if (deleteBus.isPresent()) {
            this.iBusService.remove(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
