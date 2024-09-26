import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger nickname3 = new AtomicInteger(0);
    public static AtomicInteger nickname4 = new AtomicInteger(0);
    public static AtomicInteger nickname5 = new AtomicInteger(0);

    public static boolean isPalidrom(String str) {
        StringBuilder plane = new StringBuilder(str);
        return (plane.reverse().toString()).equals(str);
    }

    public static boolean isOneLetter(String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch != chars[0]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOrdered(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String strSorted = new String(chars);
        return strSorted.equals(str);
    }

    public static void increment(String str) {
        if (isOrdered(str) || isOneLetter(str) || isPalidrom(str)) {
            switch (str.length()) {
                case 3:
                    nickname3.incrementAndGet();
                    break;
                case 4:
                    nickname4.incrementAndGet();
                    break;
                case 5:
                    nickname5.incrementAndGet();
                    break;
                default:
                    System.out.println("Другое количество буков");
                    break;
            }
        }
    }

    public static void validate(String[] strings) {
        for (String str : strings) {
            increment(str);
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
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palidrom = new Thread(() -> {
            validate(texts);
        });
        Thread oneLetter = new Thread(() -> {
            validate(texts);
        });
        Thread ordered = new Thread(() -> {
            validate(texts);
        });
        palidrom.start();
        oneLetter.start();
        ordered.start();

        palidrom.join();
        oneLetter.join();
        ordered.join();

        System.out.println("Красивых слов с длиной 3: " + nickname3 + " шт");
        System.out.println("Красивых слов с длиной 4: " + nickname4 + " шт");
        System.out.println("Красивых слов с длиной 5: " + nickname5 + " шт");
    }
}
