package automobile;

import java.time.LocalDate;
import java.time.Period;

public class SUV implements AutoMobile{

    private int number;
    private int hp;
    private int price;
    private int day;
    private int pay;

    private boolean rent = false;
    private boolean reserved = false;
    private LocalDate startDay;
    private LocalDate endDay;

    public SUV(int number, int hp) {
        this.number = number;
        this.hp = hp;
    }

    @Override
    public int calculatePrice() {
        Period period = startDay.until(endDay);
        day = period.getDays();
        if (hp < 150) {
            if (day <= 5) {
                pay = day * 20000;
            } else {
                pay = (5 * 20000) + ((day - 5) * 10000);
            }
        } else if (hp >= 150 && hp <250) {
            if (day <= 5) {
                pay = day * 40000;
            } else {
                pay = (5 * 40000) + ((day - 5) * 30000);
            }
        } else if (hp >= 250 && hp <350) {
            if (day <= 5) {
                pay = day * 60000;
            } else {
                pay = (5 * 60000) + ((day - 5) * 50000);
            }
        } else if (hp >= 350) {
            if (day <= 5) {
                pay = day * 80000;
            } else {
                pay = (5 * 80000) + ((day - 5) * 70000);
            }
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
        return "s";
    }

    @Override
    public int getUnit() {
        return hp;
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
