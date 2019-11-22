package acad277;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by R on 2/1/2017.
 */
public class Barista {
    public static final int MAX_ORDERS = 3;

    private String name;
    private ArrayList<Coffee> orders;

    public Barista(String name) {
        this.name = name;
        orders = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void takeOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nHello, my name is " + name
                + ", and I'll take your order!");

        System.out.println("What size do you want (small, medium, large)? ");
        String size = input.next();
        System.out.println("What do you want to drink? ");
        String desc = input.next();
        System.out.println("What is your name? ");
        String name = input.next();

        Coffee c = new Coffee(size, desc, name);
        System.out.println("Your order will be up in a few moments: "+ c.getInfo());
        orders.add(c);
    }

    public void makeDrinks() {
        System.out.println("\nHere are the completed orders: ");
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setCompleted();
            System.out.println("\t" + orders.get(i).getInfo());
        }
        orders.clear();
    }
    public boolean isAcceptingOrders() {
        return (orders.size() < MAX_ORDERS);
    }
}
