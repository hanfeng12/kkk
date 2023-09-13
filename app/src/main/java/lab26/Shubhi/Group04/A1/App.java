package lab26.Shubhi.Group04.A1;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static lab26.Shubhi.Group04.A1.Helper.*;
public class App {
    public static String file = "src/main/resources/Food.txt";
    public static String cartfile = "src/main/resources/Cart.txt";
    public static String historyfile = "src/main/resources/History.txt";
    private static Scanner scanner = new Scanner(System.in);

    static String loginMenu() {
        String loginRole;
        System.out.println("Who are you? (Enter 1. admin, 2. user)");

        switch (scanner.nextInt()) {
            case 1:
                loginRole = "admin";
                break;
            case 2:
                loginRole = "user";
                break;
            default:
                System.out.println("Please enter the correct instruction");
                loginRole = loginMenu();
        }
        return loginRole;
    }

    static void userMenu() {

        while (true) {
            String command = "What option do you like? (Enter the number)";
            String warning = "Please enter a Integer between 0 and 4";
            String prefix_User = "[User]: ";
            System.out.println(command);
            System.out.println("0: quit");
            System.out.println("1: order");
            System.out.println("2: view cart");
            System.out.println("3: view history");
            System.out.println("4: checkout");
            System.out.printf(prefix_User);

            int userInput = -1;

            userInput = scanner.nextInt();

            while (userInput < 0 || userInput > 4) {
                while (!scanner.hasNextInt()) {
                    System.out.println(warning);
                    scanner.nextLine();
                }
                userInput = scanner.nextInt();

                if (userInput < 0 || userInput > 4) {
                    System.out.println(warning);
                    scanner.nextLine();
                }
            }

            switch (userInput) {
                case 0:
                    return;
                case 1:
                    System.out.println(display(getList(file)));
                    System.out.print("What do you want to order? ");
                    String food = scanner.next();
                    List<String> foodList = getFoodName(file);
                    boolean found = false;
                    for (int i = 0; i < foodList.size(); i++){
                        if(foodList.get(i).equals(food)){
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("We do not have this food, sorry. ");
                    } else {
                        Date date = new Date();
                        System.out.print("How many food do you want? ");
                        int amount = scanner.nextInt();
                        writeCart(food,amount,cartfile);
                        writeHistory(date,food,amount,historyfile);
                        System.out.print("The food is add to your cart. ");
                    }
                    System.out.print("What else can I do for you? ");
                    break;

                case 2:
                    HashMap<String, Integer> map = getCart(cartfile);
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " ");
                    }
                    System.out.println("Which food do you want to manage");
                    String change = scanner.next();
                    System.out.println("How much do you want");
                    int amount = scanner.nextInt();
                    if(amount != 0){
                        map.put(change,amount);
                    } else {
                        map.remove(change);
                    }
                    try {
                        Files.write(Paths.get(cartfile), Collections.emptyList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        writeCart(entry.getKey(),entry.getValue(),cartfile);
                    }
                    break;

                case 3:
                    System.out.println(displayHistory(getHisList(historyfile)));
                    break;

                case 4:
                    Double price = 0.0;
                    HashMap<String, Integer> cartMap = getCart(cartfile);
                    List<Food> foodList1 = getList(file);

                    HashMap<String, Double> foodPriceMap = new HashMap<>();
                    for (Food f : foodList1) {
                        foodPriceMap.put(f.getName(), f.getPrice());
                    }

                    for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
                        Double foodPrice = foodPriceMap.get(entry.getKey());
                        if (foodPrice != null) {
                            price += entry.getValue() * foodPrice;
                        }
                    }
                    System.out.println(price);
                    break;
            }
        }
    }

    static void adminMenu(){
        while (true) {
            String command = "What option do you like? (Enter the number)";
            String warning = "Please enter a Integer between 1 and 6";
            String prefix_Admin = "[Admin]: ";
            System.out.println(command);
            System.out.println("0: quit");
            System.out.println("1: display");
            System.out.println("2: conversion");
            System.out.println("3: add currency");
            System.out.println("4: history");
            System.out.println("5: remove currency");
            System.out.println("6: update favorite");
            System.out.printf(prefix_Admin);

            int userInput = -1;

            userInput = scanner.nextInt();

            while (userInput < 0 || userInput > 6) {
                System.out.println(warning);
                userInput = scanner.nextInt();
            }
        }
    }

    public static void main(String[]args) {
        userMenu();
    }

}