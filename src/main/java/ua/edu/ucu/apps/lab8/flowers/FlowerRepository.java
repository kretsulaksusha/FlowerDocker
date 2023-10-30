package ua.edu.ucu.apps.lab8.flowers;

import org.springframework.data.jpa.repository.JpaRepository;

// Data Access layer

public interface FlowerRepository extends JpaRepository<Flower, Integer> {
    
}
