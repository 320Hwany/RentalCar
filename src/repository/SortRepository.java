package repository;

import service.CustomComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortRepository{

    public static List<List<String>> sortRepository = new ArrayList<>();

    public void add(List<String> split) {
        sortRepository.add(split);
    }

    public void sort() {
        Collections.sort(sortRepository, new CustomComparator());
    }

    public List<List<String>> findAll() {
        return sortRepository;
    }
    public void clear() {
        sortRepository.clear();
    }
}
