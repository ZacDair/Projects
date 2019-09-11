public class Product {
    //attributes
    public String name;
    public int id;
    public String desc;
    public float price;
    static int countId;
    //constuctor
    public Product(String n,int i,String d,float p){
        this.name = n;
        this.id = i;
        this.desc = d;
        this.price = p;
    }
    //setters
    public void setName(String n){
        this.name = n;
    }
    public void setDesc(String d){
        this.desc = d;
    }
    public void setPrice(float p){
        this.price = p;
    }
    public void setId(){
        countId = countId+1;
        id = id + countId;
    }
    //getters
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }

    //print
    public void printProductInfo(String name,int id,String desc, float price){
        System.out.println("Product Name: "+name+" Product ID: "+id+" Description: "+desc+" Price: "+price+"$");
    }
    public void printProductInfo(String make, String model,int storageVal){
        System.out.println("Make: "+make+" Model: "+model+" Storage Space: "+storageVal+"GB");
    }
    public void printProductInfo(String make,int screenSize, String type, Boolean can3D){
        System.out.println("Make: "+make+" Screen Size: "+screenSize+" Tv Type: "+type+" 3D able: "+can3D);
    }
}



