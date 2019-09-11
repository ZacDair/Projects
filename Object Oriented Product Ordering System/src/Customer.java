import java.util.*;
public class Customer {
    private String name;
    private String address;
    private int id;
    static int countId;
    private ArrayList<Order> orderList =new ArrayList<>();
    public Customer(String n, String a){
        this.name = n;
        this.address = a;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public void setId(){
        countId = countId+1;
        id = id + countId;
    }
    public int getId(){
        return this.id;
    }
    public void newOrder(Order o){
        orderList.add(o);
    }
    public ArrayList<Order> getOrderList(){
        return this.orderList;
    }
    public void cancelOrder(Order o){
     orderList.remove(o);
     System.out.println("Order Removed");
    }


}
