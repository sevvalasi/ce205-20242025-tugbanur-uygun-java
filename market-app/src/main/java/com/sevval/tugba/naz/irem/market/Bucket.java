package com.sevval.tugba.naz.irem.market;
import java.util.ArrayList;
import java.util.List;

public class Bucket {
    public static Product[] product;
	private List<Product> products; // Bucket içindeki ürünleri tutan liste

    // Constructor - Listeyi başlatır
    public Bucket() {
        this.products = new ArrayList<>();
    }

    // Ürün listesini döndüren getter metodu
    public List<Product> getProducts() {
        return products;
    }

    // Bucket'a bir ürün ekleyen metod
    public void addProduct(Product product) {
        products.add(product);
    }

    // Bucket'ın içeriğini güzel bir biçimde yazdırmak için toString metodu
    @Override
    public String toString() {
        return "Bucket contains: " + products;
    }
}
