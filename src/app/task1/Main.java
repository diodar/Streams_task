package app.task1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    static AtomicInteger cnt = new AtomicInteger(0);
    static String title;

    public static void main(String[] args) {

        String[] names = getData();
        title = "Initial names list:";
        getOutput(title, names);

        title = "Names started with letter 'O':";
        System.out.println('\n' + title);
        cnt.set(0);
        makeStream(names).filter(name -> name.startsWith("O")).forEach(name -> System.out.println(cnt.incrementAndGet() + ") " + name));
    }

    private static String[] getData() {
        return new String[]{"Oleksandr", "Mariya", "Serhii", "Oleg", "Hanna", "Oleksii"};
    }

    private static Stream<String> makeStream(String[] strings) {
        return Arrays.stream(strings);
    }

    private static void getOutput(String title, String[] names) {
        cnt.set(0);
        System.out.println("\n" + title);
        for (String name : names) {
            cnt.incrementAndGet();
            System.out.println(cnt + ") " + name);
        }
    }
}