import java.util.*;
import java.util.Scanner;
public class ProductDB {
    //attributes
    ArrayList<Product> productList =new ArrayList<>();
    int productCount = 0;
    //constructor
    public ProductDB(){

    }
    public int getProductCount(){
        return this.productCount;
    }
    public void addProduct(Product p){
        productList.add(p);
        productCount++;
    }
    public void removeProduct(){
        Product p = findProduct();
        if (p==null){
            System.out.println("No Product with that id to remove");
        }
        else {
            System.out.println("Removed Product with id: " + p.getId());
            productList.remove(p);
        }

    }
    public Product findProduct(){
        int numObjects = productList.size();
        int i = 0;
        int indexFoundAt = -1;
        System.out.println("Enter the ID of the product to find: ");
        Scanner sc = new Scanner(System.in);
        int searchID = sc.nextInt();
        sc.nextLine();
        System.out.println("Searching...");
        while(i<numObjects){
            Product tempProduct = productList.get(i);
            int checkID = tempProduct.getId();
            if (searchID == checkID){
                indexFoundAt = i;
                i = numObjects;
            }
            i++;
        }
        if (indexFoundAt == -1){
            System.out.println("No product found.");
            return null;
        }
        else{
            System.out.println("Product with found with id: "+searchID);
            return productList.get(indexFoundAt);
        }
    }
    public Product displayProduct(int i){
        return productList.get(i);
    }
}