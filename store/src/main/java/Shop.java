import java.util.*;

// Класс Shop (Применение OCP для добавления новых функций без изменения существующих классов)
class Shop {
    private List<Product> products;
    private Map<Integer, Order> orders;

    public Shop() {
        products = new ArrayList<>();
        orders = new HashMap<>();
        // Примеры товаров
        // Примеры товаров
        products.add(new Product("Laptop", "Apple", 1500, 5));
        products.add(new Product("Smartphone", "Samsung", 800, 4));
        products.add(new Product("Smartwatch", "Garmin", 250, 4));
        products.add(new Product("Headphones", "Sony", 150, 5));
        products.add(new Product("Monitor", "Dell", 300, 4));
        products.add(new Product("Keyboard", "Logitech", 100, 4));
        products.add(new Product("Mouse", "Razer", 80, 3));
        products.add(new Product("Tablet", "Apple", 600, 5));
        products.add(new Product("Camera", "Canon", 1200, 5));
        products.add(new Product("Printer", "HP", 200, 3));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> filterProducts(String keyword, double minPrice, double maxPrice, String manufacturer) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if ((keyword.isEmpty() || product.getName().contains(keyword)) &&
                    (manufacturer.isEmpty() || product.getManufacturer().equalsIgnoreCase(manufacturer)) &&
                    product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public Order placeOrder(Cart cart) {
        Order order = new Order(cart.getProducts());
        orders.put(order.getId(), order);
        cart.clear(); // Очищаем корзину после оформления заказа
        return order;
    }

    public Order getOrderById(int orderId) {
        return orders.get(orderId);
    }

    // Метод для получения списка рекомендованных товаров на основе рейтинга
    public List<Product> getRecommendedProducts(int limit) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getRating).reversed())
                .limit(limit)
                .toList();
    }
}
