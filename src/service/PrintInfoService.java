package service;

import automobile.AutoMobile;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PrintInfoService {

    public String printInfoTypeA(String name, String result, List<String> a) {
        if (name.equals("c")) {
            result = ("car " + a.get(2) + "cc, " + a.get(3) + "년" + a.get(4) +
                    "월" + a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + "(" + a.get(8) + ") ");
        } else if (name.equals("s")) {
            result = ("SUV " + a.get(2) + "hp, " + a.get(3) +"년"+ a.get(4) +
                    "월"+ a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + "(" + a.get(8) + ") ");
        } else if (name.equals("t")) {
            result = ("Truck " + a.get(2) + "ton, " + a.get(3) +"년"+ a.get(4) +
                    "월"+ a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + "(" + a.get(8) + ") ");
        }
        return result;
    }

    public String printInfoTypeB(String result, AutoMobile autoMobile, List<String> b) {
        if (autoMobile.getName().equals("c")) {
            result = "car " + autoMobile.getUnit() + "cc(" + autoMobile.getNumber() + "), " +
                    b.get(3) + "년 " + b.get(4) + "월 " + b.get(5)
                    + "일(" + b.get(6) + "일)," + b.get(7) +
                    "(" + b.get(8) + ") ";
        } else if (autoMobile.getName().equals("s")) {
            result = "SUV " + autoMobile.getUnit() + "hp(" + autoMobile.getNumber() + "), " +
                    b.get(3) + "년 " + b.get(4) + "월 " + b.get(5)
                    + "일(" + b.get(6) + "일)," + b.get(7) +
                    "(" + b.get(8) + ") ";
        } else if (autoMobile.getName().equals("t")) {
            result = "Truck " + autoMobile.getUnit() + "ton(" + autoMobile.getNumber() + "), " +
                    b.get(3) + "년 " + b.get(4) + "월 " + b.get(5)
                    + "일(" + b.get(6) + "일)," + b.get(7) +
                    "(" + b.get(8) + ") ";
        }
        return result;
    }

    public String printInfoTypeC(String result, AutoMobile autoMobile, List<String> b,
                                 LocalDate localDate) {
        LocalDate now = localDate;
        Period period = Period.between(autoMobile.getStartLocalDate(), now);
        int day = period.getDays();
        if (autoMobile.getName().equals("c")) {
            result = "car " + autoMobile.getUnit() + "cc(" + autoMobile.getNumber() + "), " +
                   now.getYear() + "년 " + now.getMonthValue() + "월 " + now.getDayOfMonth()
                    + "일(" + day + "일)," + b.get(7) +
                    "(" + b.get(8) + "), ";
        } else if (autoMobile.getName().equals("s")) {
            result = "SUV " + autoMobile.getUnit() + "hp(" + autoMobile.getNumber() + "), " +
                    now.getYear() + "년 " + now.getMonthValue()  + "월 " + now.getDayOfMonth()
                    + "일(" + day + "일)," + b.get(7) +
                    "(" + b.get(8) + "), ";
        } else if (autoMobile.getName().equals("t")) {
            result = "Truck " + autoMobile.getUnit() + "ton(" + autoMobile.getNumber() + "), " +
                    now.getYear() + "년 " + now.getMonthValue()  + "월 " + now.getDayOfMonth()
                    + "일(" + day + "일)," + b.get(7) +
                    "(" + b.get(8) + "), ";
        }
        return result;
    }

    public String printInfoTypeD(String name, String result, List<String> a) {
        if (name.equals("c")) {
            result = ("car " + a.get(2) + "cc, " + a.get(3) + "년" + a.get(4) +
                    "월" + a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + ", " + a.get(8));
        } else if (name.equals("s")) {
            result = ("SUV " + a.get(2) + "hp, " + a.get(3) +"년"+ a.get(4) +
                    "월"+ a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + ", " + a.get(8));
        } else if (name.equals("t")) {
            result = ("Truck " + a.get(2) + "ton, " + a.get(3) +"년"+ a.get(4) +
                    "월"+ a.get(5) + "일(" + a.get(6) + "일), " +
                    a.get(7) + ", " + a.get(8));
        }
        return result;
    }
}
