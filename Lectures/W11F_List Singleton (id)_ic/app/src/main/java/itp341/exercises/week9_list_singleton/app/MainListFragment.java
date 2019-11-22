package itp341.exercises.week9_list_singleton.app;

import itp341.exercises.week9_list_singleton.R;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShop;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShopSingleton;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainListFragment extends Fragment {

    private static final String TAG = MainListFragment.class.getSimpleName();

    Button buttonAdd;
    ListView listView;

    //TODO create array and adapter
//    private ArrayAdapter<CoffeeShop> adapter;
    private CoffeeAdapter adapter;



    public MainListFragment() {
        // Required empty public constructor
    }


    public static MainListFragment newInstance() {
        Bundle args = new Bundle();

        MainListFragment f = new MainListFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);

        Log.d(TAG, "onCreateView");

        //find views
        buttonAdd = (Button) v.findViewById(R.id.button_add);
        listView = (ListView)v.findViewById(R.id.listView);

        //TODO access coffee shop list and load it in the list
        ArrayList<CoffeeShop> shops = CoffeeShopSingleton.get(getActivity()).getCoffeeShops();

//        adapter = new ArrayAdapter<CoffeeShop>(getActivity(),
//                                    android.R.layout.simple_list_item_1,
//                                    shops);
        adapter = new CoffeeAdapter(getActivity(), 0, shops);
        listView.setAdapter(adapter);

        //TODO What happens when user clicks add?
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "mButtonadd: onClick ");
                Intent i = new Intent(getActivity(), DetailActivity.class);
                startActivityForResult(i, 0);

            }
        });

        //TODO create listview item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "listView: onListItemClick");
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra(DetailActivity.EXTRA_POSITION, position);
                startActivityForResult(i, 0);


            }
        });

        return v;
    }




    //TODO finish onActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);

        if (resultCode == Activity.RESULT_OK) {
            //refresh the screen
            adapter.notifyDataSetChanged();
        }

    }
    private class CoffeeAdapter extends ArrayAdapter<CoffeeShop> {
        //#1 data source
        ArrayList<CoffeeShop> coffeeShops;

        //#2 constructor
        public CoffeeAdapter(Context c, int resId, ArrayList<CoffeeShop> objects) {
            super(c, 0, objects);
            //storing the custom data
            coffeeShops = objects;
        }

        //step 3 -- generates a SINGLE row of our list
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //check if a row has already been instantiated
            //if not, create it
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(
                                    R.layout.list_row_item_cardview, null
                );
            }

            //load the data into the row
            TextView textName = (TextView) convertView.findViewById(R.id.text_name);
            TextView textCity = (TextView) convertView.findViewById(R.id.text_city);

            CoffeeShop cs = coffeeShops.get(position);

            textName.setText(cs.getName());
            textCity.setText(cs.getCity());


            return convertView;
        }
    }

}










