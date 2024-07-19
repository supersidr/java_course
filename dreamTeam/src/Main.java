import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int[] bestTeam = teams[0];

        for (int i = 1; i < teams.length; i++) {
            bestTeam = merge(bestTeam, teams[i]);
        }
        return bestTeam;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {

        int[] bestTen = new int[10];

        int i = 0, j = 0;
        for (int k = 0; k < bestTen.length; k++) {
            if (teamA[i] > teamB[j]) {
                int a = teamA[i];
                bestTen[k] = a;
                i++;
            } else {
                int b = teamB[j];
                bestTen[k] = b;
                j++;
            }
        }
        return bestTen;
    }
}