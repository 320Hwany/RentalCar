package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    public static List<List<String>> reservationList = new ArrayList<>();

    public void saveReservation(List<String> split) {
        reservationList.add(split);
    }

    public List<String> findCancelReservation(List<String> split) {
        for (int i = 0; i < reservationList.size(); i++) {
            String phoneNumber = reservationList.get(i).get(8);
            String year = reservationList.get(i).get(3);
            String month = reservationList.get(i).get(4);
            String day = reservationList.get(i).get(5);
            if (phoneNumber.equals(split.get(1)) && year.equals(split.get(2)) &&
                    month.equals(split.get(3)) && day.equals(split.get(4))) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    public List<String> findCheckInReservation(List<String> split) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (split.get(1).equals(reservationList.get(i).get(8))) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    public void findCheckOutReservation(List<String> split) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (split.get(1).equals(reservationList.get(i).get(8))) {
                reservationList.remove(i);
            }
        }
    }

    public List<String> findReservationNow(List<String> split, LocalDate localDate) {
        for (int i = 0; i < reservationList.size(); i++) {
            Integer year = Integer.valueOf(reservationList.get(i).get(3));
            Integer month = Integer.valueOf(reservationList.get(i).get(4));
            Integer day = Integer.valueOf(reservationList.get(i).get(5));
            if (localDate.isEqual(LocalDate.of(year, month, day))) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    public List<String> cancel(String phoneNumber, String year, String month, String day) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).get(8).equals(phoneNumber) &&
                    reservationList.get(i).get(3).equals(year) &&
                    reservationList.get(i).get(4).equals(month) &&
                    reservationList.get(i).get(5).equals(day)) {
                List<String> split = reservationList.get(i);
                reservationList.remove(i);
                return split;
            }
        }
        return null;
    }

    public List<List<String>> findAllReservation() {
        return reservationList;
    }
}
