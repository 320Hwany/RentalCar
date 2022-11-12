package automobile;

import java.time.LocalDate;
import java.time.Period;

public class Car implements AutoMobile{

    private int number;
    private int cc;
    private int price;
    private int day;
    private int pay;

    private boolean rent = false;

    private boolean reserved = false;
    private LocalDate startDay;
    private LocalDate endDay;

    public Car(int number, int cc) {
        this.number = number;
        this.cc = cc;
    }

    @Override
    public int calculatePrice() {
        Period period = startDay.until(endDay);
        day = period.getDays();
        if (cc < 1000) {
            if (day <= 5) {
                pay = day * 30000;
            } else {
                pay = (5 * 30000) + ((day - 5) * 20000);
            }
        } else if (cc >= 1000 && cc <2000) {
            if (day <= 5) {
                pay = day * 40000;
            } else {
                pay = (5 * 40000) + ((day - 5) * 30000);
            }
        } else if (cc >= 2000 && cc <3000) {
            if (day <= 5) {
                pay = day * 50000;
            } else {
                pay = (5 * 50000) + ((day - 5) * 40000);
            }
        } else if (cc >= 3000) {
            if (day <= 5) {
                pay = day * 60000;
            } else {
                pay = (5 * 60000) + ((day - 5) * 60000);
            }
        }
        return pay;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return "c";
    }

    @Override
    public int getUnit() {
        return cc;
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
}
