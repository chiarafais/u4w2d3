package esercises;

public class Product {


    private String name;
    private  Category category;
    private double price;
    private long id;


    public Product(String name, Category category, double price, long id) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
