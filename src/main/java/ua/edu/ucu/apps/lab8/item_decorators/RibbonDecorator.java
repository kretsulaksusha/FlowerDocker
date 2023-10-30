package ua.edu.ucu.apps.lab8.item_decorators;

import lombok.Getter;

@Getter
public class RibbonDecorator extends ItemDecorator {
    private Item item;

    public RibbonDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return "Ribbon decoration.";
    }
    
    @Override
    public double getPrice() {
        return 40 + item.getPrice();
    }
    
}
