package service;

import automobile.AutoMobile;
import repository.*;

import java.time.LocalDate;
import java.util.List;

public class RentalService {

    ReservationRepository reservationRepository = new ReservationRepository();
    RenterRepository renterRepository = new RenterRepository();
    IncomeRepository incomeRepository = new IncomeRepository();
    UserRepository userRepository = new UserRepository();
    PrintInfoService printInfoService = new PrintInfoService();
    LocalDate nowLocalDate;

    public void reservation(List<String> split) {
        String result = "예약 가능한 차량이 없습니다.";

        for (Integer key : AutomobileRepository.getStore().keySet()) {
            AutoMobile autoMobile = AutomobileRepository.getStore().get(key);
            String name = autoMobile.getName();

            Integer year = Integer.valueOf(split.get(3));
            Integer month = Integer.valueOf(split.get(4));
            Integer day = Integer.valueOf(split.get(5));
            Integer plusDay = Integer.valueOf(split.get(6));
            LocalDate localDate = LocalDate.of(year, month, day);

            userRepository.selfCancel(localDate, plusDay);
            LocalDate startLocalDate = LocalDate.of(year, month, day);
            LocalDate endLocalDate = startLocalDate.plusDays(plusDay);
            if (split.get(1).equals(name) && Integer.valueOf(split.get(2)).equals(autoMobile.getUnit()) &&
                    (autoMobile.getEndLocalDate().isBefore(startLocalDate) ||
                            autoMobile.getStartLocalDate().isAfter(endLocalDate)) &&
            userRepository.findUser(split.get(8)) == false) {

                autoMobile.setReserved(true);
                autoMobile.setRent(false);
                String printResult = printInfoService.printInfoTypeA(split.get(1), result, split);

                result = printResult + "예약";
                reservationRepository.saveReservation(split);
                userRepository.save(split.get(8), localDate);
                autoMobile.setStartLocalDate(startLocalDate);
                autoMobile.setEndLocalDate(endLocalDate);
            }
        }
        System.out.println(result);
    }

    public void cancelReservation(List<String> split) {
        String result = "예약자 현황에 정보가 없습니다. 정보를 다시 확인해주세요";
        String phoneNumber = split.get(1);
        String year = split.get(2);
        String month = split.get(3);
        String day = split.get(4);
        List<String> cancelReservation = reservationRepository.findCancelReservation(split);
        if (cancelReservation != null) {
            AutoMobile autoMobile = findAutoMobile(cancelReservation);
            if(autoMobile != null) {
                    autoMobile.setStartLocalDate(LocalDate.of(1,1,1));
                    autoMobile.setEndLocalDate(LocalDate.of(1,1,1));
                    autoMobile.setReserved(false);
            }
        }

        List<String> cancel = reservationRepository.cancel(phoneNumber, year, month, day);
        if (cancel != null) {
            String printResult = printInfoService.printInfoTypeA(cancel.get(1), result, cancel);
            result = printResult + "취소";
            userRepository.cancel(phoneNumber);
        }
        System.out.println(result);
    }

    public void checkOut(List<String> split) {
        String result = "대여 불가 차량입니다";
        List<String> reservationNow = reservationRepository.findReservationNow(split, nowLocalDate);
        if (reservationNow != null && reservationNow.get(8).equals(split.get(1))) {
            AutoMobile autoMobile = findAutoMobile(reservationNow);
            if(autoMobile != null && autoMobile.getRent() == false) {
                String printResult = printInfoService.printInfoTypeB(result, autoMobile, reservationNow);
                result = printResult + "대여";
                reservationRepository.findCheckOutReservation(split);
                renterRepository.saveRenter(reservationNow);
                autoMobile.setRent(true);
                autoMobile.setReserved(true);
            }
        }
        System.out.println(result);
    }

    public void checkIn(List<String> split) {
        String result = "반납 불가 차량입니다";
        List<String> checkIn = renterRepository.findCheckIn(split);
        if (checkIn != null) {
            AutoMobile autoMobile = findAutoMobile(checkIn);
            autoMobile.setEndLocalDate(nowLocalDate);
            int calculatePrice = autoMobile.calculatePrice();
            autoMobile.setPrice(calculatePrice);
            if (autoMobile != null && autoMobile.getRent() == true) {
                String printResult = printInfoService.printInfoTypeC(result, autoMobile, checkIn, nowLocalDate);
                result = printResult + "반납";
                renterRepository.cancelRenter(split);
                incomeRepository.saveIncome(checkIn);
                userRepository.cancel(split.get(1));
                autoMobile.setRent(false);
            }
        }
        System.out.println(result);
    }

    public void viewAllReservedVehicles(List<String> split) {
        String result = "";
        List<List<String>> allRenter = reservationRepository.findAllReservation();
        for (int i = 0; i < allRenter.size(); i++) {
            AutoMobile autoMobile = findAutoMobile(allRenter.get(i));
            if (autoMobile != null && autoMobile.getReserved() == true) {
                String printResult = printInfoService.printInfoTypeD(autoMobile.getName(), result, allRenter.get(i));
                result = printResult;
            }
            System.out.println(result);
        }
    }

    public void viewAllRentedVehicles(List<String> split) {
        List<List<String>> allRenter = renterRepository.findAllRenter();
        for (int i = 0; i < allRenter.size(); i++) {
            String result = "";
            AutoMobile autoMobile = findAutoMobile(allRenter.get(i));
            String printResult = printInfoService.printInfoTypeB(result, autoMobile, allRenter.get(i));
            result = printResult;
            System.out.println(result);
        }
    }

    public void income() {
        List<List<String>> allIncome = incomeRepository.findAllIncome();
        int year = nowLocalDate.getYear();
        int month = nowLocalDate.getMonthValue();
        int totalPrice = 0;
        System.out.println(year + "년 " + month + "월 대여 수입");
        for (int i = 0; i < allIncome.size(); i++) {
            AutoMobile autoMobile = findAutoMobile(allIncome.get(i));
            if (autoMobile.getName().equals("c") && Integer.valueOf(allIncome.get(i).get(4))
                    == nowLocalDate.getMonthValue()) {
                System.out.println("car " + autoMobile.getUnit() + "cc, " +
                        allIncome.get(i).get(3) + "년" + allIncome.get(i).get(4) + "월" +
                        allIncome.get(i).get(5) + "일(" + allIncome.get(i).get(6) + "일), " +
                        autoMobile.getPrice() + "원");
                totalPrice += autoMobile.getPrice();
            } else if (autoMobile.getName().equals("s")  && Integer.valueOf(allIncome.get(i).get(4))
                    == nowLocalDate.getMonthValue()) {
                System.out.println("SUV " + autoMobile.getUnit() + "hp, " +
                        allIncome.get(i).get(3) + "년" + allIncome.get(i).get(4) + "월" +
                        allIncome.get(i).get(5) + "일(" + allIncome.get(i).get(6) + "일), " +
                        autoMobile.getPrice() + "원");
                totalPrice += autoMobile.getPrice();
            } else if (autoMobile.getName().equals("t")  && Integer.valueOf(allIncome.get(i).get(4))
                    == nowLocalDate.getMonthValue()) {
                System.out.println("truck " + autoMobile.getUnit() + "hp, " +
                        allIncome.get(i).get(3) + "년" + allIncome.get(i).get(4) + "월" +
                        allIncome.get(i).get(5) + "일(" + allIncome.get(i).get(6) + "일), " +
                        autoMobile.getPrice() + "원");
                totalPrice += autoMobile.getPrice();
            }
        }
        System.out.println("총 수입 : " + totalPrice);
    }

    public void setDate(List<String> split) {
        Integer year = Integer.valueOf(split.get(1));
        Integer month = Integer.valueOf(split.get(2));
        Integer day = Integer.valueOf(split.get(3));

        LocalDate localDate = LocalDate.of(year, month, day);
        nowLocalDate = localDate;
    }

    public AutoMobile findAutoMobile(List<String> reservationList) {
        for (Integer key : AutomobileRepository.getStore().keySet()) {
            AutoMobile autoMobile = AutomobileRepository.getStore().get(key);
            if (reservationList.get(1).equals(autoMobile.getName()) &&
                    Integer.valueOf(reservationList.get(2)).equals(autoMobile.getUnit())) {
                return autoMobile;
            }
        }
        return null;
    }
}
