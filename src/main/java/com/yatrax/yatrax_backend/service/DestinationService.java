package com.yatrax.yatrax_backend.service;

import com.yatrax.yatrax_backend.model.Destination;
import com.yatrax.yatrax_backend.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DestinationService {
    @Autowired private DestinationRepository repo;
    public List<Destination> getAllDestinations() { return repo.findAll(); }
    public Destination create(Destination d) { return repo.save(d); }
    public Destination getById(Long id) { return repo.findById(id).orElse(null); }
    public List<Destination> search(String keyword) { return repo.findByNameContainingIgnoreCase(keyword); }
}
