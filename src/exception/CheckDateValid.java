package exception;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class CheckDateValid {

    public boolean checkDate(List<String> split) throws DateTimeException{

        if (split.get(0).equals("r")) {
            String year = split.get(3);
            String month = split.get(4);
            String day = split.get(5);
            try {
                LocalDate localDate =
                        LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
            } catch (DateTimeException e) {
                System.out.println("유효하지 않은 날짜입니다.");
                return false;
            }
        } else if (split.get(0).equals("c")) {
            String year = split.get(2);
            String month = split.get(3);
            String day = split.get(4);
            try {
                LocalDate localDate =
                        LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
            } catch (DateTimeException e) {
                System.out.println("유효하지 않은 날짜입니다.");
                return false;
            }
        }
        return true;
    }
}
