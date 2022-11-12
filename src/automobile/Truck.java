package automobile;

import java.time.LocalDate;
import java.time.Period;

public class Truck implements AutoMobile {

    private int number;
    private int ton;
    private int price;
    private int day;
    private int pay;

    private boolean rent = false;
    private boolean reserved = false;
    private LocalDate startDay;
    private LocalDate endDay;

    public Truck(int number, int ton) {
        this.number = number;
        this.ton = ton;
    }

    @Override
    public boolean getRent() {
        return rent;
    }

    @Override
    public boolean getReserved() {
        return reserved;
    }

    @Override
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int calculatePrice() {
        Period period = startDay.until(endDay);
        day = period.getDays();
        if (ton < 1) {
            pay = price * 20000;
        } else if (ton >= 1 && ton < 4) {
            pay = price * 40000;
        } else if (ton >= 4) {
            pay = price * 60000;
        }
        return pay;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getName() {
        return "t";
    }

    @Override
    public int getUnit() {
        return ton;
    }

    @Override
    public LocalDate getStartLocalDate() {
        return startDay;
    }

    @Override
    public void setStartLocalDate(LocalDate startLocalDate) {
        this.startDay = startLocalDate;
    }

    @Override
    public LocalDate getEndLocalDate() {
        return endDay;
    }

    @Override
    public void setEndLocalDate(LocalDate endLocalDate) {
        this.endDay = endLocalDate;
    }
}
