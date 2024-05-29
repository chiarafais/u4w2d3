import esercises.Category;
import esercises.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static  void main(String[] args) {

    List<Product> prodotti = generaProdotti();
        System.out.println(prodotti);

    }
    public static List<Product> generaProdotti(){
        List<Product> prodotti = new ArrayList<Product>();
        Random random = new Random();
        Supplier<Long> randomID = () -> random.nextLong(50000, 60000);
        Supplier<Double> randomPrice = () -> random.nextDouble(0, 200);
        Supplier<Product> generateProduct = () -> new Product("prodotto",randomCategory(), randomPrice.get(),randomID.get());

        for (int i = 0; i < 200; i++) {
            Product randomProduct = generateProduct.get();
            prodotti.add(randomProduct);
        }
        return prodotti;
    }


    public static Category randomCategory(){
        Random random = new Random();
        int num = random.nextInt(1,4);
        Category defaultCategory = Category.BABY;
        if(num == 1){
            defaultCategory = Category.BOOKS;
        }if(num == 2){
            defaultCategory = Category.BOYS;
        }
        return defaultCategory;
    }
}