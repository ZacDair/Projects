package com.company;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Random;

public class GameInstance {
    private ArrayList<String> maps = new ArrayList<>(Arrays.asList("DE_DUST","DE_NUKE","DE_INFERNO","DE_MIRAGE","DE_CACHE","DE_DUST2"));
    private String map;
    private int maxPlayers = 5;
    private int numPlayers;
    private int id;
    private ArrayList<Player>PlayerList = new ArrayList<>();

    public GameInstance(int i){
        this.id = i;
        Random ran = new Random();
        int mapIndex = ran.nextInt(5) + 1;
        this.map = maps.get(mapIndex);
    }
    public void printGI(){
        System.out.println("Game Instance Id: "+id);
        System.out.println("Map is: "+map);

    }
    public boolean isFull(){
        boolean isFull = false;
        if(numPlayers == maxPlayers){
            isFull = true;
        }
        return isFull;
    }
    public void addPlayer(Player p){
        PlayerList.add(p);
        numPlayers++;
    }


}
