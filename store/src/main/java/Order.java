import java.util.ArrayList;
import java.util.List;

// Класс Order, представляющий заказ
class Order {
    private static int idCounter = 1; // Идентификатор заказа, для уникальности (Избегаем магических чисел)
    private int id;
    private List<Product> products;
    private String status;

    public Order(List<Product> products) {
        this.id = idCounter++;
        this.products = new ArrayList<>(products);
        this.status = "В обработке"; // Изначально статус "В обработке"
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", products=" + products + ", status='" + status + "'}";
    }
}
