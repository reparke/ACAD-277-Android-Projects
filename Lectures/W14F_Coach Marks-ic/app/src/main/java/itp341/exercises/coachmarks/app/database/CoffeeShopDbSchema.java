package itp341.exercises.coachmarks.app.database;

/**
 * Created by R on 11/2/2015.
 */
public class CoffeeShopDbSchema {
    public static final class TABLE_COFFEE_SHOPS {
        public static final String NAME = "coffee_shops";

        // Column Names
        public static final String KEY_ID = "_id"; // follow this convention
        public static final String KEY_NAME = "name";
        public static final String KEY_CITY = "rating";

        // Column indexes (good enumeration style)
        public static final int COLUMN_ID = 0;
        public static final int COLUMN_NAME = 1;
        public static final int COLUMN_CITY = 2;
    }
}
