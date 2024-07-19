import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }


        int[] personProducts = new int[products.length];

        int productNumber = 0;
        int productCount = 0;
        int totalPrice = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            personProducts[productNumber] = productCount;
        }

        for (int i = 0; i < personProducts.length; i++) {
            if (personProducts[i] != 0) {
                int quantityCost = personProducts[i] * prices[i];
                System.out.println(products[i] + " " + personProducts[i] + " шт " + prices[i] + " руб/шт " + quantityCost + " в сумме");
                totalPrice += quantityCost;
            }
        }

        System.out.println("Итого " + totalPrice + " руб");
    }
}
