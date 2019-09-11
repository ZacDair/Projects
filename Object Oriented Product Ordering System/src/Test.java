import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    ArrayList<Customer> customers = new ArrayList<>();
    public Test() {
    }
    public ProductDB generateData(){
        //create phone objects
        Phone p1 = new Phone("Nokia", 16, "Lumia", "Nokia", 0, "Sleek Touchscreen phone", 99.99f);
        p1.setId();
        Phone p2 = new Phone("Huawei", 32, "p20", "Huawei", 0, "Fast Phone, with 16mp Camera", 229.99f);
        p2.setId();
        Phone p3 = new Phone("Sony", 64, "Xperia", "Sony", 0, "Durable, Flashy, Quality phone", 199.99f);
        p3.setId();
        Phone p4 = new Phone("Razor", 64, "M1", "Razor", 0, "Powerful phone, for the players", 529.99f);
        p4.setId();
        //create Tv objects
        Tv tv1 = new Tv("Sony",22,"LCD",true,"Sony",0,"60hz widescreen TV",89.99f);
        tv1.setId();
        Tv tv2 = new Tv("LG",44,"Plasma",true,"LG",0,"90hz Curved TV",189.99f);
        tv2.setId();
        Tv tv3 = new Tv("Sony",64,"LED",true,"Sony",0,"60hz 4k TV",889.99f);
        tv3.setId();
        Tv tv4 = new Tv("Acer",32,"LCD",true,"Acer",0,"144hz 4k Gaming Monitor",589.99f);
        tv4.setId();
        //create customer objects
        Customer cust1 = new Customer("Tony Stark","10880 Malibu Point, 90265");
        cust1.setId();
        Customer cust2 = new Customer("Stefan Salvatore","Salvatore Boarding House, Mystic Falls");
        cust2.setId();
        Customer cust3 = new Customer("Niklaus Mikkelson","236 Bourbon Street, New Orleans");
        cust3.setId();
        Customer cust4 = new Customer("Mason Lockwood","Lockwood Manor, Mystic Falls");
        cust4.setId();

        //create a productDB object
        ProductDB productList = new ProductDB();
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        //use getters to get the details from each object and add them to the productDB
        productList.addProduct(p1);
        productList.addProduct(p2);
        productList.addProduct(p3);
        productList.addProduct(p4);
        productList.addProduct(tv1);
        productList.addProduct(tv2);
        productList.addProduct(tv3);
        productList.addProduct(tv4);
        //Create a order objects add items to each order
        Order order1 = new Order();
        order1.setId();
        order1.add(tv3,2);
        order1.add(tv1,1);
        order1.add(p4,1);
        Order order2 = new Order();
        order2.setId();
        order2.add(tv1,1);
        Order order3 = new Order();
        order3.setId();
        order3.add(p2,2);
        order3.add(tv4,1);
        order3.add(p3,1);
        Order order4 = new Order();
        order4.setId();
        order4.add(tv3,1);
        order4.add(tv2,1);
        order4.add(tv1,1);
        order4.add(p1,2);
        //add orders to each customer
        cust1.newOrder(order1);
        cust1.newOrder(order2);
        cust2.newOrder(order3);
        cust3.newOrder(order4);
        return productList; //return product list to be used in main
    }
    public Phone createPhone(){
        Scanner in = new Scanner(System.in);
        System.out.println("Creating a new Phone\n Enter the phone make: ");
        String make = in.nextLine();
        System.out.println("Enter the phone model: ");
        String model = in.nextLine();
        System.out.println("Enter the amount of GB of storage the phone has: ");
        int storageVal = in.nextInt();
        in.nextLine();
        System.out.println("Enter the phone description: ");
        String desc = in.nextLine();
        System.out.println("Enter the phone price");
        float price = in.nextFloat();
        Phone p = new Phone(make, storageVal, model, make, 0, desc, price);
        p.setId();
        return p; //return the phone to be added to the list in main.
    }
    public Customer createCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Creating a new customer\n Enter your name: ");
        String name = in.nextLine();
        System.out.println("Enter your address: ");
        String address = in.nextLine();
        Customer c = new Customer(name,address);
        c.setId();
        System.out.println("Id is : "+c.getId());
        customers.add(c);
        return c;
    }
    //this takes in a product list in the event that we have more than one Product Db we can simply use the same method.
    //for this example it will be the same list as productList, but allows expansion on the system at a later date.
    public void displayAllProducts(ProductDB pList){
        int size = pList.getProductCount(); //get the size of the list
        int i = 0;
        while(i<size){ //traverse the list displaying each Product
            Product temp = pList.displayProduct(i);
            if(temp instanceof Phone){
               Phone newTemp = ((Phone)temp);
               newTemp.printProductInfo(newTemp.getName(),newTemp.getId(),newTemp.getDesc(),newTemp.getPrice());
               newTemp.printPhoneInfo();
               System.out.println();
            }
            else if(temp instanceof Tv){
                Tv newTemp = ((Tv)temp);
                newTemp.printProductInfo(newTemp.getName(),newTemp.getId(),newTemp.getDesc(),newTemp.getPrice());
                newTemp.printTVInfo();
                System.out.println();
            }
            i++;
        }
    }
    public void displayAllCustomers(){
        int size = customers.size(); //get the size of the list
        int i = 0;
        while(i<size){ //traverse the list displaying each Product
            Customer temp = customers.get(i);
            System.out.println("Customer Id: "+temp.getId()+" Customer Name: "+temp.getName()+" Customer Address: "+temp.getAddress());           i++;
        }
    }
    public Customer checkCustomer(int searchid){
        Customer res = null;
        boolean found = true;
        int size = customers.size();
        int i = 0;
        String name = "";
        while(i<size){
            Customer temp = customers.get(i);
            int checkID = temp.getId();
            if(checkID == searchid){
                found = true;
                name = temp.getName();
                res = temp;
                i = size+1;
            }
            else{
                found = false;
            }
            i++;
        }
        if(found){
            Scanner in = new Scanner(System.in);
            System.out.println("Found Customer with id: "+searchid);
            System.out.println("Enter your name here: ");
            String inputtedName = in.nextLine();
            if(name.equals(inputtedName)){
                System.out.println("Confirmed Name");
            }
            else{
                res = null;
                System.out.println("If you are a new customer please create an account before ordering\n" +
                        "Error, Please retry check the id entered and name entered");
            }
        }
        else{
            System.out.println("No customer with id "+searchid);
            res = null;
        }
        return res;
    }
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }


}