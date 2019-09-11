public class Tv extends Product {
    //attributes
    private String make;
    private int screenSize;
    private String type;
    private Boolean can3D;
    //constuctor
    public Tv(String m,int s, String t,Boolean c,String n, int id, String desc,float price){
        super(n,id,desc,price);
        this.make = m;
        this.screenSize = s;
        this.type = t;
        this.can3D = c;
    }
    //setters
    public void setTVMake(String m){
        this.make = m;
    }
    public void setType(String t){
        this.type = t;
    }
    public void setScreenSize(int i){
        this.screenSize  = i;
    }
    public void set3D(Boolean c){
        this.can3D = c;
    }
    //getters
    public String getTVMake(){
        return make;
    }
    public String getTvType(){
        return type;
    }
    public int getScreenSize(){
        return screenSize;
    }
    public Boolean get3D(){
        return can3D;
    }
    //print
    public void printTVInfo(){
        super.printProductInfo(make,screenSize,type,can3D);
    }
}
