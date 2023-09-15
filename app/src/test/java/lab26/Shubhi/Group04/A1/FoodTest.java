package lab26.Shubhi.Group04.A1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoodTest {

    @Test
    public void testToString() {
        Food ts_food = new Food();
        ts_food.setName("pizza");
        ts_food.setPrice(20.0);
        ts_food.setDescription("Hot sales");
        assertEquals("Food{" +
                "name='" + ts_food.getName() + '\'' +
                ", price=" + ts_food.getPrice() +
                ", description=" + ts_food.getDescription() +
                '}', ts_food.toString());
    }
}