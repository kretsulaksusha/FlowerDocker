package ua.edu.ucu.apps.lab8.flowers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.ucu.apps.lab8.item_decorators.FlowerBucket;
import ua.edu.ucu.apps.lab8.item_decorators.ItemDecorator;
import ua.edu.ucu.apps.lab8.item_decorators.PaperDecoraror;
import ua.edu.ucu.apps.lab8.item_decorators.RibbonDecorator;

// Business layer
@Service
public class FlowerService {
    public FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    public void add(Flower flower) {
        flowerRepository.save(flower);
    }

    public ItemDecorator decorate(Flower flower) {
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(new FlowerPack(flower, 15));

        ItemDecorator decorated_bucket = new RibbonDecorator(new PaperDecoraror(bucket));
        return decorated_bucket;
    }
}
