import java.util.List;
import java.util.Scanner;

// Основной класс с интерфейсом взаимодействия
public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        User user = new User("John Doe");

        while (true) {
            System.out.println("1. Посмотреть товары");
            System.out.println("2. Фильтровать товары");
            System.out.println("3. Посмотреть корзину");
            System.out.println("4. Оформить заказ");
            System.out.println("5. Посмотреть заказы");
            System.out.println("6. Рекомендации");
            System.out.println("7. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Вывод всех товаров
                    for (Product product : shop.getProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    // Фильтрация товаров
                    System.out.print("Введите ключевое слово: ");
                    String keyword = scanner.next();
                    System.out.print("Минимальная цена: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Максимальная цена: ");
                    double maxPrice = scanner.nextDouble();
                    System.out.print("Производитель: ");
                    String manufacturer = scanner.next();
                    List<Product> filteredProducts = shop.filterProducts(keyword, minPrice, maxPrice, manufacturer);
                    for (Product product : filteredProducts) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    // Вывод содержимого корзины
                    for (Product product : user.getCart().getProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 4:
                    // Оформление заказа
                    Order order = shop.placeOrder(user.getCart());
                    System.out.println("Ваш заказ #" + order.getId() + " оформлен.");
                    break;
                case 5:
                    // Просмотр заказов
                    System.out.print("Введите ID заказа: ");
                    int orderId = scanner.nextInt();
                    Order retrievedOrder = shop.getOrderById(orderId);
                    if (retrievedOrder != null) {
                        System.out.println(retrievedOrder);
                    } else {
                        System.out.println("Заказ не найден.");
                    }
                    break;
                case 6:
                    // Рекомендации
                    System.out.println("Рекомендованные товары для вас:");
                    List<Product> recommendedProducts = shop.getRecommendedProducts(5);
                    for (Product product : recommendedProducts) {
                        System.out.println(product);
                    }
                    break;

                case 7:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неправильный выбор.");
            }
        }
    }
}
