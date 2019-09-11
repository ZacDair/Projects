package com.company;
import java.util.Random;

public class Player {
    //---------------------------------------
    //	Attributes
    //---------------------------------------
    private String username;
    private String password;
    private int id;
    private String region;
    private boolean team;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    public Player(String u,String p,String r) {
        this.username = u;
        this.region = r;
        this.password = p;
    }
    public void generateID(){
        Random ran = new Random();
        id = ran.nextInt(10000000) + 5;

    }
    public int getID(){
        return id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getRegion(){
        return this.region;
    }
    public void printPlayerInfo(){
        System.out.println("Username: "+username+" Region: "+region+" ID: "+id);
    }
    public boolean checkPassword(String input){
        boolean res = false;
        if (input.equals(this.password)){
            res = true;
        }
        return res;
    }

}
