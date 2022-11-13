package automobile;

import java.time.LocalDate;

public interface AutoMobile {

    int calculatePrice();

    void setNumber(int number);

    int getNumber();
    String getName();

    int getUnit();

    LocalDate getStartLocalDate();

    void setStartLocalDate(LocalDate startLocalDate);

    LocalDate getEndLocalDate();

    void setEndLocalDate(LocalDate endLocalDate);

    boolean getRent();

    boolean getReserved();

    void setReserved(boolean reserved);

    void setRent(boolean rent);

    int getPrice();

    void setPrice(int price);

    int getDay();
}





