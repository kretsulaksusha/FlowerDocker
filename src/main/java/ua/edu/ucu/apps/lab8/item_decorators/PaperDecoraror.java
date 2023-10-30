package ua.edu.ucu.apps.lab8.item_decorators;

import lombok.Getter;

@Getter
public class PaperDecoraror extends ItemDecorator {
    private Item item;

    public PaperDecoraror(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return "Paper decoration.";
    }
    
    @Override
    public double getPrice() {
        return 13 + item.getPrice();
    }

}
