import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> filterdList = new ArrayList<>();
        for (var i: intList) {
            if (i > 0 && i % 2 == 0) {
                filterdList.add(i);
            }
        }
        Collections.sort(filterdList);

        System.out.println(filterdList.toString());
    }
}
