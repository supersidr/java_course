import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Main {
    protected static ArrayBlockingQueue<String> analyzeQueueA = new ArrayBlockingQueue<>(100);
    protected static ArrayBlockingQueue<String> analyzeQueueB = new ArrayBlockingQueue<>(100);
    protected static ArrayBlockingQueue<String> analyzeQueueC = new ArrayBlockingQueue<>(100);

    protected static ConcurrentMap<String, Integer> sequenceMap = new ConcurrentHashMap<>();

    protected static int analyzeStringLength = 100_000;
    protected static int stringsToAnalyze = 10_000;

    public static void charInString(String s, char c) {
        int stringMaxCount = (int) s.chars().filter(ch -> ch == c).count();
        int currentMaxCount = sequenceMap.getOrDefault(String.valueOf(c), 0);
        if (stringMaxCount > currentMaxCount) {
            sequenceMap.put(String.valueOf(c), stringMaxCount);
        }
    }

    public static void iterateQueue (ArrayBlockingQueue<String> queue, char letter) {
        String text;
        while (true) {
            try {
                if ((text = queue.poll(100, MILLISECONDS)) == null) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            charInString(text, letter);
        }
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread textGen = new Thread(() -> {
            for (int i = 0; i < stringsToAnalyze; i++) {
                String text = generateText("abc", analyzeStringLength);
                try {
                    analyzeQueueA.put(text);
                    analyzeQueueB.put(text);
                    analyzeQueueC.put(text);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread aThread = new Thread(() -> {
            iterateQueue(analyzeQueueA, 'a');
        });
        Thread bThread = new Thread(() -> {
            iterateQueue(analyzeQueueB, 'b');
        });
        Thread cThread = new Thread(() -> {
            iterateQueue(analyzeQueueC, 'c');
        });

        textGen.start();
        aThread.start();
        bThread.start();
        cThread.start();

        textGen.join();
        textGen.join();
        textGen.join();

        for (Map.Entry<String, Integer> entry : sequenceMap.entrySet()) {
            System.out.format("Максимальное количество символов '%s': %d \n", entry.getKey(), entry.getValue());
        }
    }
}
