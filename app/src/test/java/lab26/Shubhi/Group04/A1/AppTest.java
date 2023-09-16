/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab26.Shubhi.Group04.A1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testLoginMenuAdmin() {
        App.reinitializeScanner();
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String role = App.loginMenu();  // Replace with your actual method
        assertTrue(outContent.toString().contains("Who are you? (Enter 1. admin, 2. user)"));
        assertEquals("admin", role);
    }

    @Test
    public void testLoginMenuUser() {
        App.reinitializeScanner();
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String role = App.loginMenu();  // Replace with your actual method
        assertTrue(outContent.toString().contains("Who are you? (Enter 1. admin, 2. user)"));
        assertEquals("user", role);
    }

    @Test
    public void testLoginMenuInvalidThenAdmin() {
        String input = "3\n1\n";  // Simulating invalid input followed by admin input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String role = App.loginMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Who are you? (Enter 1. admin, 2. user)"));
        assertTrue(output.contains("Please enter the correct instruction"));
        assertEquals("admin", role);
    }
//
    @Test
    public void testLoginMenuInvalidThenUser() {
        String input = "0\n2\n";  // Simulating invalid input followed by user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String role = App.loginMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Who are you? (Enter 1. admin, 2. user)"));
        assertTrue(output.contains("Please enter the correct instruction"));
        assertEquals("user", role);
    }

    @Test
    public void testAdminMenuQuit() {
        String input = "0\n";  // Simulating quit option
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("[Admin]: "));
        assertTrue(output.contains("What option do you like? (Enter the number)"));
    }


    @Test
    public void testAdminMenuAddFood() {
        // Simulating add food option followed by food name, price, and description
        String input = "5\nnewFood\n10.0\ndescription\n0\n";  // Added "0\n" to simulate quitting after adding food
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Please enter the food name:"));
        assertTrue(output.contains("Please enter food price:"));
        assertTrue(output.contains("Please enter food description:"));
    }

    @Test
    public void testAdminMenuRemoveFood() {
        // Simulating remove food option followed by food name and then quitting
        String input = "7\nfoodToRemove\n0\n";  // "7\n" for remove food option, followed by food name to remove, and "0\n" to simulate quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Please enter food:"));
    }


    @Test
    public void testAdminMenuViewCart() {
        // Simulating view cart option, managing a food, and then quitting
        String input = "2\nfoodName\n5\n0\n";  // "2\n" for view cart option, "foodName\n" for the food to manage, "5\n" for the new amount, and "0\n" to simulate quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Which food do you want to manage"));
    }


    @Test
    public void testAdminMenuViewHistory() {
        // Simulating view history option and then quitting
        String input = "3\n0\n";  // "3\n" for view history option and "0\n" to simulate quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Good morning"));
    }

    @Test
    public void testAdminMenuCheckout() {
        // Simulating checkout option and then quitting
        String input = "4\n0\n";  // "4\n" for checkout option and "0\n" to simulate quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Good evening"));
    }
    @Test
    public void testUserMenuQuit() {
        String input = "0\n";  // Simulating quit option
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertTrue(output.contains("[User]: "));
        assertTrue(output.contains("What option do you like? (Enter the number)"));
    }

    @Test
    public void testUserMenuOrder() {
        String input = "1\nfoodName\n5\n0\n";  // Simulating order option, followed by food name, amount, and then quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Hi"));
    }

    @Test
    public void testUserMenuViewCart() {
        String input = "2\nfoodName\n5\n0\n";  // Simulating view cart option, managing a food, and then quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Which food do you want to manage"));
    }

    @Test
    public void testUserMenuViewHistory() {
        String input = "3\n0\n";  // Simulating view history option and then quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertFalse(output.contains("What else can I do for you?"));
    }

    @Test
    public void testUserMenuCheckout() {
        String input = "4\n0\n";  // Simulating checkout option and then quitting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertFalse(output.contains("What else can I do for you?"));
    }








}



