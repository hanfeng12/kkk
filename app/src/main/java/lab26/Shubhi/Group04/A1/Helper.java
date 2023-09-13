package lab26.Shubhi.Group04.A1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {
    public static String display(List<Food> foods) {
        String result = "";
        for (Food food: foods) {
            result+=(food.getName() + "   ");
            result+=String.format("%7.2f %s",food.getPrice(), food.getDescription());
            result+="\n";
        }
        result+="\n";
        return result;
    }

    public static List<Food> getList (String fileName){
        List<Food> result = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] cols = sc.nextLine().split(",");
                Food food = new Food();
                food.setName(cols[0]);
                food.setPrice(Double.valueOf(cols[1]));
                food.setDescription(cols[2]);
                result.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeFile(List<Food> foods,String filename) {
        StringBuilder sb = new StringBuilder();
        for (Food food : foods) {
            sb
                    .append(food.getName())
                    .append(",")
                    .append(food.getPrice())
                    .append(",")
                    .append(food.getDescription())
                    .append("\n");
        }
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(sb.toString().getBytes());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List getFoodName(String FileName) {
        File currencyFile = new File(FileName);
        List<String> FoodName = new ArrayList<>();
        try{
            Scanner fileReader = new Scanner(currencyFile);
            while(fileReader.hasNextLine()) {
                String[] ls = fileReader.nextLine().split(",");
                FoodName.add(ls[0]);
            }

            return FoodName;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return FoodName;
    }

    public static void writeCart(String name,int amount ,String filename) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(name)
                .append(",")
                .append(amount)
                .append("\n");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHistory(Date date,String name, int amount ,String filename) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sb
                .append(sdf.format(date))
                .append(",")
                .append(name)
                .append(",")
                .append(amount)
                .append("\n");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Integer> getCart(String fileName) {
        File cartFile = new File(fileName);
        HashMap<String, Integer> cart = new HashMap<>();
        try (Scanner fileReader = new Scanner(cartFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                try {
                    cart.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public static String displayHistory(List<History> histories) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (History his: histories) {
            result+=(his.getName() + "   ");
            result+=(his.getAmount()+ "   " + sdf.format(his.getDate()));
            result+="\n";
        }
        result+="\n";
        return result;
    }

    public static List<History> getHisList (String fileName){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<History> result = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] cols = sc.nextLine().split(",");
                History history = new History();
                history.setDate(sdf.parse(cols[0]));
                history.setName(cols[1]);
                history.setAmount(Integer.parseInt(cols[2]));
                result.add(history);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}