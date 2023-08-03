package app.task3;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger cnt = new AtomicInteger(0);
    static String title;

    public static void main(String[] args) {

        Map<String, Integer[]> weeklyTemperature = getData();
        title = "Initial temperature list:";
        getOutput(title, weeklyTemperature);
        title = "Days with temperature range 8-13:";
        getOutput(title, dataHandler(weeklyTemperature));
    }

    private static Map<String, Integer[]> getData() {
        Integer[] monday = new Integer[]{7, 9, 12, 16, 14};
        Integer[] tuesday = new Integer[]{8, 10, 11, 13, 10};
        Integer[] wednesday = new Integer[]{10, 13, 16, 16, 15};
        Integer[] thursday = new Integer[]{11, 13, 18, 20, 20};
        Integer[] friday = new Integer[]{10, 11, 12, 15, 10};
        Integer[] saturday = new Integer[]{7, 9, 10, 8, 7};
        Integer[] sunday = new Integer[]{8, 11, 11, 12, 10};

        Map<String, Integer[]> list = new LinkedHashMap<>();
        list.put("Monday", monday);
        list.put("Tuesday", tuesday);
        list.put("Wednesday", wednesday);
        list.put("Thursday", thursday);
        list.put("Friday", friday);
        list.put("Saturday", saturday);
        list.put("Sunday", sunday);

        return list;
    }

    private static Map<String, Integer[]> dataHandler(Map<String, Integer[]> list) {

        for (Map.Entry<String, Integer[]> dayTemp : list.entrySet()) {
            String day = dayTemp.getKey();
            Integer[] temperatures = dayTemp.getValue();
            Integer[] filteredTemp = Arrays.stream(temperatures).filter(tmp -> tmp >= 8 && tmp <= 13).toArray(Integer[]::new);
            list.put(day, filteredTemp);
        }
        return list;
    }

    private static void getOutput(String title, Map<String, Integer[]> list) {
        cnt.set(0);
        System.out.println("\n" + title);
        for (Map.Entry<String, Integer[]> dayTemp : list.entrySet()) {
            String day = dayTemp.getKey();
            System.out.println("\n" + day + ":");
            Integer[] temperatures = dayTemp.getValue();
            cnt.incrementAndGet();
            System.out.println(cnt + ") " + Arrays.toString(temperatures));
        }
    }
}