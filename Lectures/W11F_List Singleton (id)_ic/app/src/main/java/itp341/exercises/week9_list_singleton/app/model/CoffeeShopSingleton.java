package itp341.exercises.week9_list_singleton.app.model;

import android.content.Context;

import java.util.ArrayList;

//TODO complete
public class CoffeeShopSingleton {

    //TODO instance variables
    private ArrayList<CoffeeShop> coffeeShops;  //this changes based on the needs of the project
    private Context context;

    //store a static reference to the singleton
    private static CoffeeShopSingleton singleton;


    //TODO private singleton constructor
    private CoffeeShopSingleton(Context c) {
        context = c;
        //instantiate the data
        coffeeShops = new ArrayList<>();

        //add dummy data
        for (int i = 0; i < 10; i++) {
            CoffeeShop cs = new CoffeeShop();
            cs.setName("Coffee Shop #" + i);
            cs.setCity("Los Angeles");
            coffeeShops.add(cs);
        }
    }


    //TODO Singleton get method
    public static CoffeeShopSingleton get(Context c) {
        //only one instance ever is created
        if (singleton == null) { //we have never created a singleton
            singleton = new CoffeeShopSingleton(c.getApplicationContext());
        }
        return singleton;
    }


    //TODO getCoffeeShops (all items)
    public ArrayList<CoffeeShop> getCoffeeShops() {
        return coffeeShops;
    }


    //TODO getCoffeeShop (single item)
    public CoffeeShop getCoffeeShop(int position) {
        return coffeeShops.get(position);
    }


    //TODO addCoffeeShop
    public void addCoffeeShop(CoffeeShop cs) {
        coffeeShops.add(cs);
    }


    //TODO removeCoffeeShop
    public void removeCoffeeShop(int position) {
        if(position >=0 && position < coffeeShops.size()) {
            coffeeShops.remove(position);
        }
    }

    //TODO updateCoffeeShop
    public void updateCoffeeShop(CoffeeShop cs, int position) {
        if (position >= 0 && position < coffeeShops.size()) {
            coffeeShops.set(position, cs);
        }
    }


}
