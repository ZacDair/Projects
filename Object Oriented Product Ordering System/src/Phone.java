public class Phone extends Product {
    //attributes
    private String make;
    private int storageVal;
    private String model;
    //constuctor
    public Phone(String m,int s, String md,String name, int id, String desc,float price){
        super(name,id,desc,price);
        this.make = m;
        this.storageVal = s;
        this.model = md;
    }
    //setters
    public void setMake(String m){
        this.make = m;
    }
    public void setModel(String md){
        this.model = md;
    }
    public void setStorage(int i){
        this.storageVal  = i;
    }
    //getters
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getStorage(){
        return storageVal;
    }
    //print
    public void printPhoneInfo(){
        super.printProductInfo(make,model,storageVal);
    }
}
