package ua.edu.ucu.apps.lab8.item_decorators;

import lombok.Getter;

@Getter
public class BasketDecorator extends ItemDecorator {
    private Item item;

    public BasketDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return "Basket decoration.";
    }

    @Override
    public double getPrice() {
        return 4 + item.getPrice();
    }
    
}
