import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Test test = new Test(); //Create test
        ProductDB plist = test.generateData(); //run generate data to instantiates products, customers, orders and a product list to test
        Scanner in = new Scanner(System.in);
        int choiceentry = -1;
        while (choiceentry < 1 || choiceentry > 9) {
            String menu = "Main Menu\n"+"---------\n"+"Enter 1: To create a new phone\n"+"Enter 2: Create a new Customer\n"+
                    "Enter 3: To Search for a product by supplying the ID\n"+"Enter 4: Display all products in the database\n"+
                    "Enter 5: Allow a customer to order some products\n"+"Enter 6: Display an order that a customer has made and the contents of that order\n"+
                    "Enter 7: Display all orders for a given product by supplying the ID of that product.\n"+
                    "Enter 8: Display all customers.\n"+"Enter 9: Display all orders and contents for a customer.\n"+
                    "Enter 10: To Quit the program.\n\n"+"What will your option be: ";
            System.out.println(menu);
            if (in.hasNextInt())
                choiceentry = in.nextInt();
            in.nextLine();
            switch (choiceentry) {
                case 1: {
                    Phone p = test.createPhone();
                    plist.addProduct(p);
                    System.out.println("Phone "+p.getMake()+" added to database.\n Returning to menu");
                    choiceentry = -1;
                    break;
                }
                case 2: {
                    System.out.println("Creating a new Customer");
                    Customer c = test.createCustomer();
                    String name = c.getName();
                    System.out.println("Phone "+name+" added to database.\n Returning to menu");
                    choiceentry = -1;
                    break;
                }
                case 3: {
                    System.out.println("Searching for Products");
                    Product p = plist.findProduct();
                    choiceentry = -1;
                    break;
                }
                case 4: {
                    System.out.println("Displaying all products from the database");
                    test.displayAllProducts(plist);
                    choiceentry = -1;
                    break;
                }
                case 5: {
                    System.out.println("Ordering Products for this customer");
                    System.out.println("Enter an ID to search for your account: ");
                    int id = in.nextInt();
                    in.nextLine();
                    Customer cust = test.checkCustomer(id);
                    if(cust !=null) {
                        int input = -1;
                        Order order = new Order();
                        order.setId();
                        while(input<2)  {
                        System.out.println("What would you like to order: ");
                        test.displayAllProducts(plist);
                        Product toAdd = plist.findProduct();
                        System.out.println("How many "+toAdd.getName()+" do you want to order: ");
                        int amount = in.nextInt();
                        in.nextLine();
                        order.add(toAdd,amount);
                        System.out.println("The order has been added, The order id is: "+order.getId());
                        System.out.println("Enter 1 to add more to your order 2 confirm the order");
                        input = in.nextInt();
                        in.nextLine();
                        }
                        cust.newOrder(order);
                        order.printOrderInfo();
                    }
                    else{
                        System.out.println("You need to create an account to order");
                    }

                    choiceentry = -1;
                    break;
                }
                case 6: {
                    System.out.println("Displaying an order for this customer");
                    System.out.println("Enter an ID to search for your account: ");
                    int id = in.nextInt();
                    in.nextLine();
                    Customer cust = test.checkCustomer(id);
                    if(cust !=null) {
                        System.out.println("Enter the order id to search for: ");
                        id = in.nextInt();
                        in.nextLine();
                        System.out.println("Showing Order "+id+" for customer: "+cust.getName()+" with id: "+cust.getId());
                        int i = 0;
                        ArrayList<Order>orderList = cust.getOrderList();
                        int size = orderList.size();
                        if (size==0){
                            System.out.println("No orders for this customer");
                        }else {
                            while (i < size) {
                                Order temp = orderList.get(i);
                                int tempId = temp.getId();
                                if(tempId==id){
                                    temp.printOrderInfo();
                                    i = size+1;
                                }
                                i++;
                            }
                            if (i == size){
                                System.out.println("No order with that id for this customer");
                            }
                        }
                    }
                    else{
                        System.out.println("You need to create an account to display orders");
                    }
                    choiceentry = -1;
                    break;
                }
                case 7: {
                    System.out.println("Displaying all orders for a product");
                    Product productToSearch = plist.findProduct();
                    ArrayList<Customer> customers = test.getCustomers();
                    ArrayList<Order> ordersWithProduct = new ArrayList<>();
                    int customerSize = customers.size();
                    int i = 0;
                    if(customerSize == 0){
                        System.out.println("No Customers");
                    }
                    else{
                        while(i<customerSize){
                            Customer tempCust = customers.get(i);
                            ArrayList<Order> ordersList = tempCust.getOrderList();
                            int orderListSize = ordersList.size();
                            int x = 0;
                            while(x<orderListSize){
                                Order tempOrder = ordersList.get(x);
                                if(tempOrder.checkOrdersForProduct(productToSearch)){
                                    ordersWithProduct.add(tempOrder);
                                    System.out.println("added");
                                }
                                x++;
                            }
                            i++;
                        }
                    }
                    int ordersWithProductSize = ordersWithProduct.size();
                    System.out.println(ordersWithProductSize);
                    i = 0;
                    if (ordersWithProductSize==0){
                        System.out.println("No Orders containing product with id: "+productToSearch.getId());
                    }
                    else{
                        while(i<ordersWithProductSize){
                            Order temp = ordersWithProduct.get(i);
                            temp.printOrderInfo();
                            i++;
                        }
                    }

                    choiceentry = -1;
                    break;
                }
                case 8:{
                    System.out.println("Displaying all Customers");
                    test.displayAllCustomers();
                    choiceentry = -1;
                    break;
                }
                case 9:{
                    System.out.println("Displaying all orders for this customer");
                    System.out.println("Enter an ID to search for your account: ");
                    int id = in.nextInt();
                    in.nextLine();
                    Customer cust = test.checkCustomer(id);
                    if(cust !=null) {
                        System.out.println("Showing Orders for customer: "+cust.getName()+" with id: "+cust.getId());
                        int i = 0;
                        ArrayList<Order>orderList = cust.getOrderList();
                        int size = orderList.size();
                        if (size==0){
                            System.out.println("No orders for this customer");
                        }else {
                            while (i < size) {
                                orderList.get(i).printOrderInfo();
                                i++;
                            }
                        }
                    }
                    else{
                        System.out.println("You need to create an account to display orders");
                    }
                    choiceentry = -1;
                    break;
                }
                case 10: {
                    System.out.println("Exiting Program");
                    choiceentry = 1;
                    break;
                }

            }
        }







        //plist.addProduct(t);
        //plist.removeProduct();
        //Product foundProduct = plist.findProduct();
        //String foundProductName = foundProduct.getName();
        //System.out.println("Found product: "+foundProductName);
        //Order ord = new Order();
        //cust.newOrder(ord);
        //ord.add(p1,1);
        //ord.add(p2,5);
        //ord.printOrderInfo();
    }
}
