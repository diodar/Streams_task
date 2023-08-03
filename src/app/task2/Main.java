package app.task2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger cnt = new AtomicInteger(0);
    static String title;

    public static void main(String[] args) {

        Map<String, Double> products = getData();
        title = "Initial products list:";
        getOutput(title, products);

        title = "Products costs <= 2.0:";
        System.out.println('\n' + title);
        cnt.set(0);
        products.entrySet().stream().filter(price -> price.getValue() <= 2.0).forEach(product -> System.out.println(cnt.incrementAndGet() + ") " + product.getKey() + " = " + product.getValue() + " $"));
    }

    private static Map<String, Double> getData() {
        Map<String, Double> hmap = new HashMap<>();
        hmap.put("apple", 1.15);
        hmap.put("mango", 3.1);
        hmap.put("banana", 1.8);
        hmap.put("cherry", 2.85);
        hmap.put("kiwi", 2.0);
        hmap.put("pulm", 1.25);
        return hmap;
    }

    private static void getOutput(String title, Map<String, Double> map) {
        cnt.set(0);
        System.out.println("\n" + title);
        for (Map.Entry<String, Double> list : map.entrySet()) {
            cnt.incrementAndGet();
            System.out.println(cnt + ") " + list.getKey() + " = " + list.getValue() + " $");
        }
    }
}