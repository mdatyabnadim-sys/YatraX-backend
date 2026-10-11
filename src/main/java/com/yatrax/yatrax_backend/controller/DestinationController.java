package com.yatrax.yatrax_backend.controller;

import com.yatrax.yatrax_backend.model.Destination;
import com.yatrax.yatrax_backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "*")
public class DestinationController {

    @Autowired private DestinationService service;

    @GetMapping
    public List<Destination> getAll() {
        return service.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Destination create(@RequestBody Destination d) {
        return service.create(d);
    }
}
