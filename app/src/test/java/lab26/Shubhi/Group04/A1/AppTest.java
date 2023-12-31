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
    public void testloginMenuAdmin() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String ts_role = App.loginMenu();
        assertTrue(outContent.toString().contains("Who are you? (Enter 1. admin, 2. user)"));
        assertEquals("admin", ts_role);
    }

    @Test
    public void testloginMenuUser() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String ts_role = App.loginMenu();
        assertTrue(outContent.toString().contains("Who are you? (Enter 1. admin, 2. user)"));
        assertEquals("user", ts_role);
    }

    @Test
    public void testLoginMenuInvalidThenAdmin() {
        String input = "3\n1\n";
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
        String input = "0\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String role = App.loginMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Who are you? (Enter 1. admin, 2. user)"));
        assertTrue(output.contains("Please enter the correct instruction"));
        assertEquals("user", role);
    }

    @Test
    public void testAdminMenuQuit() {
        String input = "123\n321\n0\n";  // Simulating quit option
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("[Admin]: "));
        assertTrue(output.contains("What option do you like? (Enter the number)"));
    }


    @Test
    public void testAdminMenuAddFood() {
        String input = "123\n321\n2\nfoodName\n5\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("What option do you like? (Enter the number)"));
    }

    @Test
    public void testAdminMenuWrongpasswd() {
        String input = "wrongpasswd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Please enter food:"));
    }


    @Test
    public void testAdminMenuViewCart() {
        String input = "123\n321\n2\nfoodName\n5\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Which food do you want to manage"));
    }

    @Test
    public void testAdminMenuViewHistory() {
        String input = "123\n321\n3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Good morning"));
    }

    @Test
    public void testAdminMenuCheckout() {
        String input = "123\n321\n4\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.adminMenu();
        String output = outContent.toString();
        assertFalse(output.contains("Good evening"));
    }
    @Test
    public void testUserMenuQuit() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertTrue(output.contains("[User]: "));
        assertTrue(output.contains("What option do you like? (Enter the number)"));
    }


    @Test
    public void testUserMenucheckout() {
        String input = "4\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertTrue(output.contains("There are no food in your cart"));
    }

    @Test
    public void testUserMenuViewCart() {
        String input = "2\nfoodName\n5\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertTrue(output.contains("Which food do you want to manage"));
    }

    @Test
    public void testUserMenuViewHistory() {
        String input = "3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertFalse(output.contains("What else can I do for you?"));
    }


    @Test
    public void testUserMenuCheckout() {
        String input = "4\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        App.userMenu();
        String output = outContent.toString();
        assertFalse(output.contains("What else can I do for you?"));
    }

    
}



