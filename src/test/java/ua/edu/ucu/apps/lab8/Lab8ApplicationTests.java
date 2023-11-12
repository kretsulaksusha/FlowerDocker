package ua.edu.ucu.apps.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import ua.edu.ucu.apps.lab8.flowers.Flower;
import ua.edu.ucu.apps.lab8.flowers.FlowerColor;
import ua.edu.ucu.apps.lab8.flowers.FlowerPack;
import ua.edu.ucu.apps.lab8.flowers.FlowerType;
import ua.edu.ucu.apps.lab8.item_decorators.BasketDecorator;
import ua.edu.ucu.apps.lab8.item_decorators.FlowerBucket;
import ua.edu.ucu.apps.lab8.item_decorators.ItemDecorator;
import ua.edu.ucu.apps.lab8.item_decorators.PaperDecoraror;
import ua.edu.ucu.apps.lab8.item_decorators.RibbonDecorator;

// @SpringBootTest
class Lab8ApplicationTests {

	@Test
	void testDecorators() {

		// Ribbon - 40
		// Basket - 4
		// Paper - 13

		Flower flower = new Flower(1, FlowerType.CHAMOMILE, FlowerColor.WHITE, 
									0.5, 35);

		FlowerBucket bucket = new FlowerBucket();
        bucket.add(new FlowerPack(flower, 15));

		// Ribbon
        ItemDecorator ribbon_dec = new RibbonDecorator(bucket);
		assertEquals(565, ribbon_dec.getPrice());
		// Paper
        ItemDecorator paper_dec = new PaperDecoraror(bucket);
		assertEquals(538, paper_dec.getPrice());
		// Basket
        ItemDecorator basket_dec = new BasketDecorator(bucket);
		assertEquals(529, basket_dec.getPrice());
		// Ribbon & Paper
        ItemDecorator rib_paper_dec = new RibbonDecorator(new PaperDecoraror(bucket));
		assertEquals(578, rib_paper_dec.getPrice());
		// Paper & Basket
        ItemDecorator paper_basket_dec = new PaperDecoraror(new BasketDecorator(bucket));
		assertEquals(542, paper_basket_dec.getPrice());
		// Ribbon & Basket
        ItemDecorator rib_basket_dec = new RibbonDecorator(new BasketDecorator(bucket));
		assertEquals(569, rib_basket_dec.getPrice());

		// All decorators
        ItemDecorator decorated_bucket = new RibbonDecorator(new PaperDecoraror(new BasketDecorator(bucket)));
		// All decorators in different order
        ItemDecorator decorated_bucket_rev = new BasketDecorator(new RibbonDecorator(new PaperDecoraror(bucket)));
		assertEquals(decorated_bucket.getPrice(), decorated_bucket_rev.getPrice());
	}

}
