package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncomeRepository {

    public static List<List<String>> incomeRepository = new ArrayList<>();

    public void saveIncome(List<String> split, LocalDate nowLocalDate) {
        List<String> save = new ArrayList<>(Arrays.asList(split.get(0), split.get(1),
                split.get(2), String.valueOf(nowLocalDate.getYear()),
                String.valueOf(nowLocalDate.getMonthValue()),
                String.valueOf(nowLocalDate.getDayOfMonth()),
                split.get(6), split.get(7), split.get(8)));
        incomeRepository.add(save);
    }

    public List<List<String>> findAllIncome() {
        return incomeRepository;
    }
}
