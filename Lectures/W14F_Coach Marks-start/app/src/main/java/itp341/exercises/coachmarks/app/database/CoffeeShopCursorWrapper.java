package itp341.exercises.coachmarks.app.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by R on 3/31/2016.
 */
public class CoffeeShopCursorWrapper extends CursorWrapper {
    public CoffeeShopCursorWrapper(Cursor cursor) {
        super(cursor);
    }
//
//        public CoffeeShop getCoffeeShop(Cursor cursor) {
//
//            String name = cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_NAME);
//            String city = cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_CITY);
//
//            CoffeeShop cs = new CoffeeShop();
//            cs.setName(name);
//            cs.setCity(city);
//
//            return cs;
//        }



}
