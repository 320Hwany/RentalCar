package repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public static Map<String, LocalDate> userRepository = new HashMap<>();
    
    public void save(String phoneNumber, LocalDate localDate) {
        userRepository.put(phoneNumber, localDate);
    }

    public boolean findUser(String phoneNumber) {
        if (userRepository.get(phoneNumber) != null) {
            return true;
        }
        return false;
    }
    public void cancel(String phoneNumber) {
        userRepository.remove(phoneNumber);
    }

    public void selfCancel(LocalDate localDate, int plusDay) {
        for (String key : userRepository.keySet()) {
            if (userRepository.get(key) != null) {
                LocalDate reservedLocalDate = userRepository.get(key);
                Period period = Period.between(reservedLocalDate, localDate);
                if (period.getDays() >= plusDay) {
                    userRepository.remove(key);
                }
            }
        }
    }
}
