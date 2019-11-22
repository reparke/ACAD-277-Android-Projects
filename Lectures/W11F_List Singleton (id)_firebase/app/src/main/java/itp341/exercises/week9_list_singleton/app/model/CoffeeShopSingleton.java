package itp341.exercises.week9_list_singleton.app.model;

import android.content.Context;
import android.util.Log;
import android.widget.SeekBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CoffeeShopSingleton {
    private static final String TAG = CoffeeShopSingleton.class.getSimpleName();

    private ArrayList<CoffeeShop> mCoffeeShops;

    private static CoffeeShopSingleton sCoffeeShops;
    private Context mAppContext;

    private CoffeeShopSingleton(Context appContext) {
        mAppContext = appContext;
        mCoffeeShops = new ArrayList<CoffeeShop>();
//        loadDummyData();

    }
    private void loadDummyData() {
        for (int i = 0; i < 3; i++) {
            CoffeeShop cs = new CoffeeShop();
            cs.setName("Coffee Shop #" + i);
            cs.setCity("Los Angeles");
            addCoffeeShop(cs);
            mCoffeeShops.add(cs);
        }
    }

    public static CoffeeShopSingleton get(Context c) {
        if (sCoffeeShops == null) {
            sCoffeeShops = new CoffeeShopSingleton(c.getApplicationContext());
        }
        return sCoffeeShops;
    }

    public ArrayList<CoffeeShop> getCoffeeShops() {
        return mCoffeeShops;
    }

    //TODO revise getCoffeeShop to support String id
//    public CoffeeShop getCoffeeShop(int index) {
//        return mCoffeeShops.get(index);
//    }
    public CoffeeShop getCoffeeShop(String id) {
        Log.d(TAG, "addCoffeeShops");
        return null;
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference dbRef = database.getReference("message");
////        return mCoffeeShops.get(index);
//
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                CoffeeShop cs = dataSnapshot.getValue(CoffeeShop.class);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//
//            }
//        });

    }

    //TODO addCoffeeShop adds data to db, but how does data come back to list (as arraylist?)
    public void addCoffeeShop(CoffeeShop cs) {
        Log.d(TAG, "addCoffeeShops");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("coffeeShops");

        // Generate a reference to a new location and add some data using push()
//        DatabaseReference postsRef = dbRef.child("coffeeShops");
        DatabaseReference postsRef = dbRef;     //unncessary step
        DatabaseReference pushedPostRef = postsRef.push();
        // Get the unique ID generated by a push()
        String postId = pushedPostRef.getKey();

        cs.set_id(postId);
        dbRef.child(postId).setValue(cs);



    }

    public void removeCoffeeShop(int index) {
        if (index >= 0 && index < mCoffeeShops.size())
            mCoffeeShops.remove(index);
    }

    public void updateCoffeeShop(int index, CoffeeShop cs) {
        if (index >= 0 && index < mCoffeeShops.size())
            mCoffeeShops.set(index, cs);
    }


}