package acad277;

public class Main {
    public static void main (String args[]) {
        Ranged p = new Ranged("Peach Grenade", 100, 3);
        ZoomRanged y = new ZoomRanged("Yoshi Egg Shooter", 200, 10);
        Ranged m = new Ranged("Mario Flower Fireballs", 50, 20);
        Melee f = new Melee("Flower", 10, 10, false);
        f.throwItem();

        Weapon[] armory = {p, y, m, f};


        System.out.println("Items in armory: ");
        for (int i = 0; i < armory.length; i++) {
            System.out.println(armory[i]);
        }

        for (int i = 0; i < armory.length; i++) {
            armory[i].use();
        }

    }
}
