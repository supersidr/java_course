public class Main {

    public static void main(String[] args) {
        DoubleBox<String> box = new DoubleBox<>();
        System.out.println("111 -> " + box.get(111)); // null
        System.out.println("SIZE: " + box.size()); // 0
        System.out.println();

        System.out.println("PUT: " + box.put(111, "First string")); // true
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // null
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 1
        System.out.println();

        System.out.println("PUT: " + box.put(22, "Second string")); // true
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // Second string
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 2
        System.out.println();

        System.out.println("PUT: " + box.put(3333, "First string")); // false
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // Second string
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 2
    }
}


class RandomBox<T> {
    private int key;
    private T value;

    public RandomBox(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public T tryUnlock(int key) {
        if (this.key == key) {
            return value;
        } else {
            return null;
        }
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}


class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public boolean put(int key, T value) {
        if (this.size() == 0) {
            first = new RandomBox<>(key, value);
            return true;
        };
        if (this.size() == 1) {
            second = new RandomBox<>(key, value);
            return true;
        }
        return false;
    }

    public T get(int key) {
        if (first != null) {
            if (first.getKey() == key) {
                return first.tryUnlock(key);
            }
        }
        if (second != null){
            if (second.getKey() == key) {
                return second.tryUnlock(key);
            }
        }
        return null;
    }

    public int size() {
        int count = 0;
        if (first != null) {
            count++;
        }
        if (second != null){
            count++;
        }
        return count;
    }
}