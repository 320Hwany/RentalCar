package repository;

import java.util.ArrayList;
import java.util.List;

public class RenterRepository {

    public static List<List<String>> renterRepository = new ArrayList<>();

    public void saveRenter(List<String> split) {
        renterRepository.add(split);
    }

    public void cancelRenter(List<String> split) {
        renterRepository.remove(split);
    }

    public List<List<String>> findAllRenter() {
        return renterRepository;
    }

    public List<String> findCheckIn(List<String> split) {
        for (int i = 0; i < renterRepository.size(); i++) {
            if (renterRepository.get(i).get(8).equals(split.get(1))) {
                return renterRepository.get(i);
            }
        }
        return null;
    }
}
