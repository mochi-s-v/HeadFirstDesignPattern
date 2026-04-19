package Creational.FactoryPattern;

public class TroopFactory {
    public static Troop createTroop(String troopName) {
        Troop troop = null;
        if (troopName.equals("Wizard")) {
            troop = new Wizard();
        } else if (troopName.equals("Barbarian")) {
            troop = new Barbarian();
        } else if (troopName.equals("HogRider")) {
            troop = new HogRider();
        }
        return troop;
    }
}

