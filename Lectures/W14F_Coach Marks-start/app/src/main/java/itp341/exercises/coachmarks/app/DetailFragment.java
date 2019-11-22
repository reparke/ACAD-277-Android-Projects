package itp341.exercises.coachmarks.app;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import itp341.exercises.coachmarks.R;
import itp341.exercises.coachmarks.app.database.CoffeeShopDbSchema;
import itp341.exercises.coachmarks.app.model.CoffeeShop;
import itp341.exercises.coachmarks.app.model.CoffeeShopSingleton;


public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();


    public static final String ARGS_ID = "args_id";

    EditText mEditName;
    EditText mEditAddress;
    EditText mEditCity;
    Spinner mSpinnerState;
    EditText mEditZip;
    EditText mEditPhone;
    EditText mEditRating;
    EditText mEditWebsite;
    Button mButtonSaveListing;
    Button mButtonDeleteListing;


    long mId = -1;

    public static String[] states; // read from arrays.xml for US states
    ArrayAdapter<CharSequence> mSpinnerAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(long id) {
        Bundle args = new Bundle();

        args.putLong(ARGS_ID, id);
        DetailFragment f = new DetailFragment();
        f.setArguments(args);
        Log.d(TAG, "New instance: Bundle arg id = " + id);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        mId = args.getLong(ARGS_ID, -1);
        Log.d(TAG, "onCreate: Bundle arg id = " + mId);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        //findViews
        mEditName = (EditText) v.findViewById(R.id.edit_name);
        mEditRating = (EditText) v.findViewById(R.id.edit_rating);
        mEditAddress = (EditText) v.findViewById(R.id.edit_address);
        mEditCity = (EditText) v.findViewById(R.id.edit_city);
        mSpinnerState = (Spinner) v.findViewById(R.id.spinner_state); // update
        mEditZip = (EditText) v.findViewById(R.id.edit_zip);
        mEditPhone = (EditText) v.findViewById(R.id.edit_phone);
        mEditWebsite = (EditText) v.findViewById(R.id.edit_website);
        mButtonSaveListing = (Button) v.findViewById(R.id.button_save_listing);
        mButtonDeleteListing = (Button) v.findViewById(R.id.button_delete_listing);

        //load spinner values for States in the coffee shop address
        mSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.states,
                android.R.layout.simple_spinner_item);
        mSpinnerState.setAdapter(mSpinnerAdapter);

        // format phone edit text
        mEditPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        //button listeners
        mButtonDeleteListing.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteAndClose();

            }
        });
        mButtonSaveListing.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                saveAndClose();

            }
        });


        //TODO Asynctask - remove

//        if (mId != -1) { //this means we are editing an existing listing
//            Cursor c = CoffeeShopSingleton.get(getActivity()).getCoffeeShop(mId);
//            if (c != null) { // this means we are editing old record
//
//                if (c.moveToFirst()) {    // otherwise something weird happened but necesssary for android
//                    mEditName.setText(c.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_NAME));
//                    mEditRating.setText(c.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_RATING));
//
//
//                }
//            }
//
//        }else {//else means this should be a new (blank) entry
//            mButtonDeleteListing.setEnabled(false); //shouldn't be able to "delete" new entry
//        }
        new DBSelectTask(getActivity()).execute(mId);

        return v;
    }


    private void loadData(CoffeeShop cs) {
        mEditName.setText(cs.getName());
        mEditAddress.setText(cs.getAddress());
        mEditCity.setText(cs.getCity());

        mEditZip.setText(cs.getZip());
        mEditPhone.setText(cs.getPhone());
        mEditWebsite.setText(cs.getWebsite());

        // find spinner value
        int pos = mSpinnerAdapter.getPosition(cs.getState());
        mSpinnerState.setSelection(pos);
    }

    // Listing should be saved (updated if existing, or added if new)
    private void saveAndClose() {
        Log.d(TAG, "saveAndClose");
        CoffeeShop coffeeShop = new CoffeeShop();


        coffeeShop.setName(mEditName.getText().toString());
        coffeeShop.setCity(mEditCity.getText().toString());
        if (!mEditRating.getText().toString().equals(""))
            coffeeShop.setRating(Double.parseDouble(mEditRating.getText().toString()));

        //TODO Asynctask - remove
//        if (mId != -1) {    //this was an existing list we should update
//            Log.d(TAG, "Save and Close (update existing): mId = " + mId);
//            CoffeeShopSingleton.get(getActivity()).updateCoffeeShop(mId, coffeeShop);
//        } else {  //this is a new list we should add
//            Log.d(TAG, "Save and Close (add new): mId = " + mId);
//            CoffeeShopSingleton.get(getActivity()).addCoffeeShop(coffeeShop);
//
//        }
//
//
//        getActivity().setResult(Activity.RESULT_OK);
//        getActivity().finish();

        new DBWriteTask(getActivity()).execute(mId, coffeeShop);

    }


    // Listing should be deleted (only it was an existing entry, not if it was new))
    private void deleteAndClose() {
        Log.d(TAG, "onClick");

        if (mId != -1) {    //this was an existing list we should update
            CoffeeShopSingleton.get(getActivity()).removeCoffeeShop(mId);
        }
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();

    }


    // TODO Asynctask
    // **********************************************************************************************
    // DBSelectTask - AsyncTask for DB reading
    // **********************************************************************************************

    private class DBSelectTask extends AsyncTask<Long, Void, Cursor> {
        private Context mContext;

        public DBSelectTask(Context context) {
            mContext = context;
        }

        @Override
        protected Cursor doInBackground(Long... longs) {
            Cursor c = null;
            long id = longs[0];
            if (id != -1) { //this means we are editing an existing listing
                c = CoffeeShopSingleton.get(mContext).getCoffeeShop(id);
            }
            return c;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);

            if (cursor != null) { // this means we are editing old record

                if (cursor.moveToFirst()) {    // otherwise something weird happened but necesssary for android
                    mEditName.setText(cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_NAME));
                    mEditCity.setText(cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_CITY));
                }
            } else

            {//else means this should be a new (blank) entry
                mButtonDeleteListing.setEnabled(false); //shouldn't be able to "delete" new entry
            }
        }
    }

// TODO Asynctask
// **********************************************************************************************
// DBWriteTask - AsyncTask for DB writing (insert / update)
// **********************************************************************************************

    private class DBWriteTask extends AsyncTask<Object, Void, Void> {
        private Context mContext;

        public DBWriteTask(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Object... objects) {
            long id = (Long) objects[0];
            CoffeeShop cs = (CoffeeShop) objects[1];

            if (id != -1) {    //this was an existing list we should update
                Log.d(TAG, "Save and Close (update existing): mId = " + id);
                CoffeeShopSingleton.get(mContext).updateCoffeeShop(id, cs);
            } else {  //this is a new list we should add
                Log.d(TAG, "Save and Close (add new): mId = " + id);
                CoffeeShopSingleton.get(mContext).addCoffeeShop(cs);

            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        }


    }

}
