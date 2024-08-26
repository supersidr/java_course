import java.util.ArrayList;
import java.util.List;

// Класс Cart соответствует SRP и ISP: отвечает только за хранение и управление продуктами в корзине.
class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> getProducts() {
        return products;
    }
}
