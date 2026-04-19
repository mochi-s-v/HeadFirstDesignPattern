package Creational.FactoryPattern;

import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        // now I can have multiple clients and just call the
        // TroopFactory method to create my object instead of
        // writing if else conditions
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        Troop troop = TroopFactory.createTroop(type);
        troop.attack();
    }
}
