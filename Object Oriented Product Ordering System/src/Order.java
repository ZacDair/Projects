import java.util.*;
public class Order {
    //attribtes
    private ArrayList<Product> orderedProducts =new ArrayList<>();
    private ArrayList<Integer> orderedAmounts =new ArrayList<>();
    private ArrayList<Integer> productIDs = new ArrayList<>();
    private int id;
    static int countId;
    //constructor
    public Order(){
    }
    public void setId(){
        countId = countId+1;
        id = id + countId;
    }
    public int getId(){
        return this.id;
    }
    public void add(Product p, int i){
        productIDs.add(p.getId());
        orderedProducts.add(p);
        orderedAmounts.add(i);
    }
    public void remove(int i){
        orderedProducts.remove(i);
        productIDs.remove(i);
        orderedAmounts.remove(i);
    }
    public boolean checkOrdersForProduct(Product p){
        boolean res = false;
        int i =0;
        int size = orderedProducts.size();
        if(size ==0){
            System.out.println("No Orders");
        }
        else{
            while(i<size){
                int tempId = productIDs.get(i);
                int actualId = p.getId();
                if(tempId==actualId){
                    res = true;
                    i = size;
                }
                i++;
            }

        }

        return res;
    }
    public void printOrderInfo(){
        int i = 0;
        int numOrdered = orderedProducts.size();
        float total = 0;
        System.out.println("Order id "+id+" contains: ");
        while(i < numOrdered){
            Product tempProduct = orderedProducts.get(i);
            System.out.println("Product: "+tempProduct.getName()+" Quantity: "+orderedAmounts.get(i)+
                    " Description: "+tempProduct.getDesc()+ " Product ID: "+tempProduct.getId()+
                    " Price: "+tempProduct.getPrice());
            System.out.println();
            int amount = orderedAmounts.get(i);
            float tempPrice = tempProduct.getPrice()*amount;
            total = total+tempPrice;
            i++;
        }
        System.out.println("Total Order cost is: "+total+"€");
    }
}
