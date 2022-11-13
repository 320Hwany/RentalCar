package exception;

import java.time.LocalDate;

public class CheckDateOrder {

    public static void dateOrder(LocalDate localDate, LocalDate nowLocalDate) {

        if (nowLocalDate != null && nowLocalDate.isAfter(localDate)) {
            throw new IllegalStateException("현재 날짜보다 이전 날짜로 설정하실 수 없습니다.");
        }
    }

    public boolean checkOrder(LocalDate localDate, LocalDate nowLocalDate) {
        try {
            dateOrder(localDate, nowLocalDate);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
