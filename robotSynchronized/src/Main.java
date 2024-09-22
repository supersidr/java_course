import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        int routsNumber = 1000;
        char charToCount = 'R';

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < routsNumber; i++) {
            Thread thread = new Thread(() -> {
                String route = generateRoute("RLRFR", 100);
                int charCount = (int) route.chars().filter(ch -> ch == charToCount).count();
                incMapByKey(charCount);
            } );
            thread.start();
            threads.add(thread);
        }
        for (Thread thread: threads) {
            thread.join();
        }
        Map.Entry<Integer, Integer> maxEntry = Collections.max(sizeToFreq.entrySet(), Map.Entry.comparingByValue());
        System.out.format("Самое частое количество повторений %d (встретилось %d раз) \n",maxEntry.getKey(),maxEntry.getValue());
        sizeToFreq.remove(maxEntry.getKey());
        System.out.println("Другие размеры:");
        for (Map.Entry<Integer, Integer> entry: sizeToFreq.entrySet()) {
            System.out.format("- %d (%d раз) \n",entry.getKey(),entry.getValue());
        }
    }

    public static void incMapByKey(int key) {
        synchronized (sizeToFreq) {
            if (sizeToFreq.containsKey(key)) {
                Integer counter = sizeToFreq.get(key);
                sizeToFreq.put(key, counter + 1);
            } else {
                sizeToFreq.put(key, 1);
            }
        }
    }

    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();

    }
}