package repository;

import java.util.ArrayList;
import java.util.List;

public class IncomeRepository {

    public static List<List<String>> incomeRepository = new ArrayList<>();

    public void saveIncome(List<String> split) {
        incomeRepository.add(split);
    }

    public List<List<String>> findAllIncome() {
        return incomeRepository;
    }
}
