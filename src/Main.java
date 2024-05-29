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
        
        //es 1
        List<Product> filterBook = prodotti.stream().filter(product -> product.getCategory().equals(Category.BOOKS) && product.getPrice() > 100.00).toList();
        System.out.println("lista di Books con un costo maggiore a €100 : " + filterBook);

        //es 2 da sistemare, non avevo letto bene la consegna
        List<Product> filterBaby = prodotti.stream().filter(product -> product.getCategory().equals(Category.BABY)).toList();
        System.out.println("lista di ordini categoria Baby : " + filterBaby);

        //es 3
        List<Product> productsBoys = prodotti.stream().filter(product -> product.getCategory().equals(Category.BOYS)).map(product -> {
            product.setPrice(product.getPrice() * 0.9);
            return product;
        }).toList();
        System.out.println("prodotti boys scontati al 10% : "+ productsBoys);
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