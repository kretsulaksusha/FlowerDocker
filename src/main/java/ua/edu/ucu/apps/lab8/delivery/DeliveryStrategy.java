package ua.edu.ucu.apps.lab8.delivery;

import ua.edu.ucu.apps.lab8.flowers.Order;

public interface DeliveryStrategy {
    String deliver(Order items);
}
