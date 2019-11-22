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

public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();

    //Bundle key
    public static final String ARGS_POSITION = "args_position";

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mPosition = args.getInt(ARGS_POSITION,-1);

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


        //TODO check if this is an existing or new listing
        if (mPosition != -1) { //this means we are editing an existing listing
            CoffeeShop cs = CoffeeShopSingleton.get(getActivity()).getCoffeeShop(mPosition);
            if (cs != null) { // this means we are editing old record
                loadData(cs);

            }
        } else {//else means this should be a new (blank) entry

        }

        return v;
    }


    //TODO load data from existing coffee shop object
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

    //TODO modify to use arguments
    //TODO Listing should be saved (updated if existing, or added if new)
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

            if (mPosition != -1) {    //this was an existing list we should update
                CoffeeShopSingleton.get(getActivity()).updateCoffeeShop(mPosition, cs);
            } else {  //this is a new list we should add
                CoffeeShopSingleton.get(getActivity()).addCoffeeShop(cs);

            }

            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();

        }

    }

    //TODO Listing should be deleted (only it was an existing entry, not if it was new))
    private void deleteAndClose() {
        Log.d(TAG, "deleteAndClose");

        if (mPosition != -1) {    //this was an existing list we should update
            CoffeeShopSingleton.get(getActivity()).removeCoffeeShop(mPosition);
        }
        //else --there is nothing to delete becaues this was a new entry       }

        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();


    }

}
