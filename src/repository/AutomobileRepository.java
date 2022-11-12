package repository;

import automobile.AutoMobile;

import java.util.HashMap;
import java.util.Map;

public class AutomobileRepository {

    private static Map<Integer, AutoMobile> store = new HashMap<>();

    public void save(AutoMobile autoMobile) {
        store.put(autoMobile.getNumber(), autoMobile);
    }

    public static Map<Integer, AutoMobile> getStore() {
        return store;
    }
}
