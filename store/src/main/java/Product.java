// Класс Product соответствует SRP, так как отвечает только за описание товара.
class Product {
    private String name;
    private String manufacturer;
    private double price;
    private int rating;

    public Product(String name, String manufacturer, double price, int rating) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.rating = rating;
    }

    // Геттеры
    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public double getPrice() { return price; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', manufacturer='" + manufacturer + "', price=" + price + ", rating=" + rating + "}";
    }
}
