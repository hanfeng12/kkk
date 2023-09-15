package lab26.Shubhi.Group04.A1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelperTest {

    @TempDir
    File ts_Dir;

    private File ts_File;

    @BeforeEach
    public void setUp() {
        ts_File = new File(ts_Dir, "test.txt");
    }

    @Test
    public void testDisplay() {
        List<Food> foods = List.of(new Food("pizza", 20.0, "Hot sales"));
        String ts_display = Helper.display(foods);
        assertFalse(ts_display.contains("pizzaaaa"));
        assertFalse(ts_display.contains("200000.00"));
        assertFalse(ts_display.contains("Hooooot sales"));
    }

    @Test
    public void testGetList() {
        Helper.writeFile(List.of(new Food("pizza", 20.0, "Hot sales")), ts_File.getAbsolutePath());

        List<Food> ts_food = Helper.getList(ts_File.getAbsolutePath());
        assertNotEquals(0, ts_food.size());
        assertNotEquals("pizzaaaaaa", ts_food.get(0).getName());
        assertNotEquals(200.0, ts_food.get(0).getPrice());
        assertNotEquals("Hot salesssssss", ts_food.get(0).getDescription());
    }


    @Test
    public void testGetFoodName() {

        Helper.writeFile(List.of(new Food("pizza", 20.0, "Hot sales")), ts_File.getAbsolutePath());

        List<String> foodNames = Helper.getFoodName(ts_File.getAbsolutePath());
        assertSame(1, foodNames.size());
    }

    @Test
    public void testWriteCart() {
        Helper.writeCart("pizza", 1, ts_File.getAbsolutePath());
        assertTrue(ts_File.exists());

    }

    @Test
    public void testWriteHistory() {
        Date ts_date = new Date();
        Helper.writeHistory(ts_date, "pizza", 1, ts_File.getAbsolutePath());
        assertTrue(ts_File.exists());
    }

    @Test
    public void testGetCart() throws IOException {
        Files.write(ts_File.toPath(), "pizza,20".getBytes());
        HashMap<String, Integer> cart = Helper.getCart(ts_File.getAbsolutePath());
        assertEquals(1, cart.size());
        assertTrue(cart.containsKey("pizza"));
        assertEquals(20, cart.get("pizza"));
    }

    @Test
    public void testDisplayHistory() {
        List<History> histories = List.of(new History(new Date(), "pizza", 20));
        String ts_display = Helper.displayHistory(histories);
        assertTrue(ts_display.contains("pizza"));
        assertTrue(ts_display.contains("20"));
    }

    @Test
    public void testGetHisList() throws IOException {
        Files.write(ts_File.toPath(), "2020-12-12 00:00:00,pizza,5".getBytes());
        List<History> ts_histories = Helper.getHisList(ts_File.getAbsolutePath());
        assertEquals(1, ts_histories.size());
        assertEquals("pizza", ts_histories.get(0).getName());
    }
}


