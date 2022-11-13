package service;

import java.util.Comparator;
import java.util.List;

public class CustomComparator implements Comparator<List<String>> {

    @Override
    public int compare(List<String> o1, List<String> o2) {
        String FirstStringO1 = o1.get(5);
        String FirstStringO2 = o2.get(5);
        int day = FirstStringO1.compareTo(FirstStringO2);

        String SecondString_o1 = o1.get(4);
        String SecondString_o2 = o2.get(4);
        int month = SecondString_o1.compareTo(SecondString_o2);

        String ThirdString_o1 = o1.get(3);
        String ThirdString_o2 = o2.get(3);

        int year = ThirdString_o1.compareTo(ThirdString_o2);

        if (year != 0) {
            return year;
        } else if (month != 0) {
            return month;
        }
        return day;
    }
}
