package FactoryPattern;

import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String troopName = sc.nextLine();
        Troop troop = null;
        if (troopName.equals("Wizard")) {
            troop = new Wizard();
        } else if (troopName.equals("Barbarian")) {
            troop = new Barbarian();
        } else if (troopName.equals("HogRider")){
            troop = new HogRider();
        }
        troop.attack();
    }
}
