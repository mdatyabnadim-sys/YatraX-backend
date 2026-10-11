package com.yatrax.yatrax_backend.repository;

import com.yatrax.yatrax_backend.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByState(String state);
    List<Destination> findByNameContainingIgnoreCase(String keyword);
}
