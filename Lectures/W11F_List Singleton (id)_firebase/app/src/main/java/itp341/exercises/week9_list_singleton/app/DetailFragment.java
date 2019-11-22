package itp341.exercises.week9_list_singleton.app;

import itp341.exercises.week9_list_singleton.R;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShop;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShopSingleton;

import android.app.Activity;
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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();

    //Bundle key
    public static final String ARGS_POSITION = "args_position";
    public static final String ARGS_ID = "args_id";

    EditText mEditName;
    EditText mEditAddress;
    EditText mEditCity;
    Spinner mSpinnerState;
    EditText mEditZip;
    EditText mEditPhone;
    EditText mEditWebsite;
    Button mButtonSaveListing;
    Button mButtonDeleteListing;

    int mPosition;
    String id = null;

    public static String[] states; // read from arrays.xml for US states
    ArrayAdapter<CharSequence> mSpinnerAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(int pos) {
        Bundle args = new Bundle();
        args.putInt(ARGS_POSITION, pos);
        DetailFragment f = new DetailFragment();
        f.setArguments(args);

        return f;
    }
    //TODO overloaded version for Firebase String id
    public static DetailFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ARGS_ID, id);
        DetailFragment f = new DetailFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mPosition = args.getInt(ARGS_POSITION,-1);
        id = args.getString(ARGS_ID);

    }
    public void loadCoffeeShopFB() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("coffeeShops").child(id);

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CoffeeShop cs = dataSnapshot.getValue(CoffeeShop.class);
                Log.d(TAG, cs.toString());
                loadData(cs);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);



        //findViews
        mEditName = (EditText) v.findViewById(R.id.edit_name);
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


//        if (mPosition != -1) { //this means we are editing an existing listing
        if (id != null){
//            //TODO modify
////            CoffeeShop cs = CoffeeShopSingleton.get(getActivity()).getCoffeeShop(mPosition);
            //TODO added reading -- breaks MVC
            loadCoffeeShopFB();
//            if (cs != null) { // this means we are editing old record
//                loadData(cs);
//
//            }
        } else {//else means this should be a new (blank) entry
            mButtonDeleteListing.setEnabled(false);

        }

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

    private void saveAndClose() {
        Log.d(TAG, "saveAndClose");
        CoffeeShop cs = new CoffeeShop();


        if (mButtonSaveListing != null) {
            cs.setName(mEditName.getText().toString());
            cs.setAddress(mEditAddress.getText().toString());
            cs.setCity(mEditCity.getText().toString());
            cs.setZip(mEditZip.getText().toString());
            cs.setName(mEditName.getText().toString());
            cs.setPhone(mEditPhone.getText().toString());
            cs.setWebsite(mEditWebsite.getText().toString());


            TextView tv = (TextView) mSpinnerState.getSelectedView();
            if (tv != null) {
                cs.setState(tv.getText().toString());
            }

//            if (mPosition != -1) {    //this was an existing list we should update
            if (id != null) {    //this was an existing list we should update
                //CoffeeShopSingleton.get(getActivity()).updateCoffeeShop(mPosition, cs);
                cs.set_id(id);  //existing cs id
                updateCoffeeShopFB(cs);
            } else {  //this is a new list we should add
//                CoffeeShopSingleton.get(getActivity()).addCoffeeShop(cs);
                addCoffeeShopFB(cs);

            }

            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();

        }

    }
    private void updateCoffeeShopFB(CoffeeShop cs) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("coffeeShops").child(cs.get_id());

        //updating artist
        dR.setValue(cs);
    }
    private void addCoffeeShopFB(CoffeeShop cs) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("coffeeShops");

        DatabaseReference postsRef = dbRef;     //unncessary step
        DatabaseReference pushedPostRef = postsRef.push();
        // Get the unique ID generated by a push()
        String postId = pushedPostRef.getKey();

        cs.set_id(postId);
        dbRef.child(postId).setValue(cs);
    }
    private void deleteAndClose() {
        Log.d(TAG, "deleteAndClose");

//        if (mPosition != -1) {    //this was an existing list we should update
        if (id != null) {    //this was an existing list we should update
//            CoffeeShopSingleton.get(getActivity()).removeCoffeeShop(mPosition);
            DatabaseReference dR = FirebaseDatabase.getInstance().getReference("coffeeShops").child(id);
            dR.removeValue();


        }
        //else --there is nothing to delete becaues this was a new entry       }

        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();


    }

}
