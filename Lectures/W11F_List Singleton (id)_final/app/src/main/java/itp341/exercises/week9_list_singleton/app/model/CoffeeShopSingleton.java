package itp341.exercises.week9_list_singleton.app.model;

import android.content.Context;

import java.util.ArrayList;

//TODO complete
public class CoffeeShopSingleton {

    //TODO instance variables
    private ArrayList<CoffeeShop> mCoffeeShops;

    private static CoffeeShopSingleton sCoffeeShops;
    private Context mAppContext;

    //TODO private singleton constructor
    private CoffeeShopSingleton(Context appContext) {
        mAppContext = appContext;
        mCoffeeShops = new ArrayList<CoffeeShop>();
        for (int i = 0; i < 10; i++) {
            CoffeeShop cs = new CoffeeShop();
            cs.setName("Coffee Shop #" + i);
            cs.setCity("Los Angeles");
            mCoffeeShops.add(cs);
        }
    }

    //TODO Singleton get method
    public static CoffeeShopSingleton get(Context c) {
        if (sCoffeeShops == null) {
            sCoffeeShops = new CoffeeShopSingleton(c.getApplicationContext());
        }
        return sCoffeeShops;
    }

    //TODO getCoffeeShops (all items)
    public ArrayList<CoffeeShop> getCoffeeShops() {
        return mCoffeeShops;
    }

    //TODO getCoffeeShop (single item)
    public CoffeeShop getCoffeeShop(int index) {
        return mCoffeeShops.get(index);
    }

    //TODO addCoffeeShop
    public void addCoffeeShop(CoffeeShop cs) {
        mCoffeeShops.add(cs);
    }

    //TODO removeCoffeeShop
    public void removeCoffeeShop(int index) {
        if (index >= 0 && index < mCoffeeShops.size())
            mCoffeeShops.remove(index);
    }

    //TODO updateCoffeeShop
    public void updateCoffeeShop(int index, CoffeeShop cs) {
        if (index >= 0 && index < mCoffeeShops.size())
            mCoffeeShops.set(index, cs);
    }


}
