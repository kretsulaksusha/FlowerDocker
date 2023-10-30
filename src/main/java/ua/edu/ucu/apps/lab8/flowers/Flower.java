package ua.edu.ucu.apps.lab8.flowers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// For DB we need to convert class flower to table using @Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Entity
public class Flower {
    @Id
    private Integer id;
    private FlowerType flowerType;
    private FlowerColor color;
    private double sepalLength;
    private double price;

    // copy constructor
    public Flower(Flower flower) {
        this.price = flower.price;
        this.color = flower.color;
        this.sepalLength = flower.sepalLength;
        this.flowerType = flower.flowerType;
    }

    public String getColor() {
        return color.toString();
    }
}
