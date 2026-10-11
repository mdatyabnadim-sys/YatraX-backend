package com.yatrax.yatrax_backend;

import com.yatrax.yatrax_backend.model.Destination;
import com.yatrax.yatrax_backend.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YatraxBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(YatraxBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedDatabase(DestinationRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Destination(null, "Taj Mahal", "Uttar Pradesh", 
                    "The iconic ivory-white marble mausoleum built by Emperor Shah Jahan.", 
                    4.8, "https://images.unsplash.com/photo-1564507592333-c60657eea523?w=1600", 50.0));
                repo.save(new Destination(null, "Jaipur", "Rajasthan", 
                    "The Pink City, capital of Rajasthan - a royal blend of majestic forts, ornate palaces, vibrant bazaars.", 
                    4.7, "https://images.unsplash.com/photo-1599661046289-e31897846e41?w=1600", 100.0));
                repo.save(new Destination(null, "Kerala", "Kerala", 
                    "God's Own Country - serene backwaters, palm-lined canals, Ayurvedic traditions.", 
                    4.9, "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=1600", 0.0));
                repo.save(new Destination(null, "Ladakh", "Ladakh", 
                    "A high-altitude desert in the Himalayas - dramatic landscapes, ancient monasteries, crystal-clear lakes.", 
                    4.9, "https://www.peakadventuretour.com/assets/imgs/leh-ladakh-tourism-01.webp", 20.0));
                repo.save(new Destination(null, "Goa", "Goa", 
                    "Sun, beaches, nightlife and Portuguese heritage.", 
                    4.6, "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=1600", 0.0));
                repo.save(new Destination(null, "Kashmir", "Jammu & Kashmir", 
                    "Paradise on Earth - snow-capped mountains, serene lakes, and beautiful valleys.", 
                    4.9, "https://images.unsplash.com/photo-1566837945700-30057527ade0?w=1600", 0.0));
                System.out.println("Database was empty. Seeded 6 destinations successfully!");
            }
        };
    }
}
