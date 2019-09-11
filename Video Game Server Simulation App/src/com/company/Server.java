package com.company;
import java.util.ArrayList;

public class Server {
    private ArrayList<GameInstance>GameInstanceList = new ArrayList<>();
    private String ServerName;
    private int maxGamesAmount;
    private int gameInstanceCount;
    private String region;
    //---------------------------------------
    //	Constructor
    //---------------------------------------
    public Server(String n,String r,int m) {
        this.ServerName = n;
        this.region = r;
        this.maxGamesAmount = m;
    }
    public String getRegion(){
        return this.region;
    }
    public void createGameInstances(){
        int i = 1;
        while (i<=maxGamesAmount){
            GameInstance gi = new GameInstance(i);
            GameInstanceList.add(gi);
            gameInstanceCount++;
            i++;
        }
    }
    public int getGameInstanceCount(){
        return this.gameInstanceCount;
    }
    public GameInstance getGameInstance(int i){
        GameInstance temp = GameInstanceList.get(i);
        return temp;
    }
    public void printGameInstances(){
        int i = 0;
        while (i<gameInstanceCount){
            GameInstance temp = GameInstanceList.get(i);
            temp.printGI();
            i++;
        }
    }

}

