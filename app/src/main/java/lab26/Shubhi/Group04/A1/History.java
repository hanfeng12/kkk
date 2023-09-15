package lab26.Shubhi.Group04.A1;

import java.util.Date;

public class History {
    private Date date;
    private String name;
    private Integer amount;

    public History(){

    }

    public History(Date date, String name, Integer amount) {
        this.date = date;
        this.name = name;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}