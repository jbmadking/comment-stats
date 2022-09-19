package com.ikhokha.techcheck;

import java.util.HashMap;
import java.util.Map;

public class Report {

    public Map<String, Integer> countMap = new HashMap<>();

    public synchronized void addOccurrence(String key) {

        countMap.putIfAbsent(key, 0);
        countMap.put(key, countMap.get(key) + 1);
    }
}

