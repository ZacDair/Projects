package com.company;

import java.util.Scanner;

public class Function {



    public String setRegion(){

        Scanner in = new Scanner(System.in);
        System.out.println("Pick a region: ");
        System.out.println("1.EU, 2.NA, 3.SA, 4.Asia");
        int regionVal = in.nextInt();
        String region = "";
        while (regionVal <1 || regionVal >4){
            in.nextLine();
            System.out.println("Please enter a value between 1 and 4 to pick a region");
            System.out.println("1.EU, 2.NA, 3.SA, 4.Asia");
            regionVal = in.nextInt();
        }
        switch(regionVal) {
            case 1: {
                region = "EU";
                break;
            }
            case 2:{
                region = "NA";
                break;
            }
            case 3:{
                region = "SA";
                break;
            }
            case 4:{
                region = "Asia";
                break;
            }
        }
        return region;
    }
}
