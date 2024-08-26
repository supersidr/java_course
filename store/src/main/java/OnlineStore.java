public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        User user = new User("Igor Sidorov");

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
                    for (int i = 0; i < shop.getProducts().size(); i++) {
                        System.out.println((i + 1) + ". " + shop.getProducts().get(i));
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
                    while (true) {
                        System.out.println("Выберите товар для добавления в заказ:");
                        for (int i = 0; i < shop.getProducts().size(); i++) {
                            System.out.println((i + 1) + ". " + shop.getProducts().get(i));
                        }
                        System.out.println("0. Завершить выбор и оформить заказ");
                        System.out.print("Введите номер товара: ");
                        int productNumber = scanner.nextInt();

                        if (productNumber == 0) {
                            break; // Завершение выбора
                        } else if (productNumber > 0 && productNumber <= shop.getProducts().size()) {
                            Product selectedProduct = shop.getProducts().get(productNumber - 1);
                            user.getCart().addProduct(selectedProduct);
                            System.out.println("Товар " + selectedProduct.getName() + " добавлен в корзину.");
                        } else {
                            System.out.println("Неверный номер товара.");
                        }
                    }

                    if (!user.getCart().getProducts().isEmpty()) {
                        Order order = shop.placeOrder(user.getCart());
                        System.out.println("Ваш заказ #" + order.getId() + " оформлен.");
                    } else {
                        System.out.println("Корзина пуста. Заказ не оформлен.");
                    }
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