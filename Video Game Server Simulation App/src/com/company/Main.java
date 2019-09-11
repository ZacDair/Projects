package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Function f = new Function();
        //myGui mygui = new myGui();
        //mygui.setVisible(true);
        ArrayList<Player> PlayerList = new ArrayList<>();
        ArrayList<Server> ServerList = new ArrayList<>();
        int choiceentry = -1;
        while (choiceentry < 1 || choiceentry > 3) {

            System.out.println("Enter \"1) To create a player\", \"2) To join a game\", \"3) To create servers\" or \"4) To exit\"");
            if (in.hasNextInt())
                choiceentry = in.nextInt();
            in.nextLine();


            switch (choiceentry) {
                case 1: {
                    System.out.println("Creating an account");
                    System.out.println("Enter your username here: ");
                    String username = in.nextLine();
                    System.out.println("Pick a password: ");
                    String password = in.nextLine();
                    Player p = new Player(username,password,f.setRegion());
                    p.generateID();
                    p.printPlayerInfo();
                    PlayerList.add(p);
                    choiceentry = -1;
                    break;
                }
                case 2: {
                    int numServers = ServerList.size();
                    if(numServers == 0){
                        System.out.println("No servers to connect to...");
                        choiceentry = -1;
                        break;
                    }
                    System.out.println("Login to join a game");
                    System.out.println("Please Enter your username: ");
                    String input = in.nextLine();
                    boolean checked = false;
                    Player account = null;
                    int i = 0;
                    int numPlayers = PlayerList.size();
                    while(i< numPlayers && !checked){
                        String usernameCheck = PlayerList.get(i).getUsername();
                        if (input.equals(usernameCheck)){
                            account = PlayerList.get(i);
                            checked = true;
                        }
                        i++;
                    }
                    if(checked){
                        System.out.println("Enter your password: ");

                        boolean login = false;
                        int count = 0;
                        while(count<=3 || !login) {
                            input = in.nextLine();
                            if (account.checkPassword(input)) {
                                login = true;
                                count =  4;
                                System.out.println("Logging in");
                            } else {
                                count++;
                                System.out.println("Incorrect Password, Please Try again.");
                            }
                        }
                    }
                    else{
                        System.out.println("No account with that username");
                    }
                    System.out.println("Picking a server based on your region...");
                    String playerRegion = account.getRegion(); //sort account not being made before server
                    i = 0;
                    boolean found = false;
                    String tempServerRegion = "";
                            numServers = ServerList.size();
                    while (i < numServers || !found){
                        if(i == numServers){
                            tempServerRegion = ServerList.get(i-1).getRegion();
                            found = true;
                            i = numServers+1;
                            System.out.println("Couldnt find a server in your region picked "+tempServerRegion+" instead");
                        }
                        if(playerRegion.equals(tempServerRegion)){
                            found = true;
                            i = numServers+1;
                            System.out.println("Found server for your region: "+playerRegion);
                        }
                        i++;
                    }

                    choiceentry = -1;
                    break;
                }
                case 3: {
                    System.out.println("Creating Servers...");
                    System.out.println("Enter the desired server name: ");
                    String serverName = in.nextLine();
                    String region = f.setRegion();
                    System.out.println("Enter the amount of game instances for this server: ");
                    int serverMax = in.nextInt();
                    in.nextLine();
                    Server s = new Server(serverName,region,serverMax);
                    ServerList.add(s);
                    s.createGameInstances();
                    s.printGameInstances();
                    choiceentry = -1;
                    break;
                }
                case 4: {
                    System.out.println("Exiting Program");
                    choiceentry = 1;
                    break;
                }

            }
        }
    }
}
