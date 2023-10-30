package ua.edu.ucu.apps.lab8.flowers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.apps.lab8.item_decorators.ItemDecorator;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }
    
    @GetMapping("/list")
    public List<Flower> flowerList() {
        return flowerService.getFlowers();
    }

    @PostMapping("/add")
    // @RequestBody : annotation maps the HttpRequest body to a transfer or 
    // domain object, enabling automatic deserialization of the inbound 
    // HttpRequest body onto a Java object.
    // Simply:
    // @RequestBody : json to Flower
    public void addFlower(@RequestBody Flower flower) {
        flowerService.add(flower);
    }

    @GetMapping("/decorator")
    public String decorator() {
        ItemDecorator bucket = flowerService.decorate(
            new Flower(1, FlowerType.CHAMOMILE, FlowerColor.WHITE, 
            0.5, 35));
        return """
            <p style=\"font-size: 24px; font-family: ui-rounded;\">
            Price for the flower bucket decorated with paper and ribbon:\s"""
            + bucket.getPrice() + ".</p>";
    }
}
