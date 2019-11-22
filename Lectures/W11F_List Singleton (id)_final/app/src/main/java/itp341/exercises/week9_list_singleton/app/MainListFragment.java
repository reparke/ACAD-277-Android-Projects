package itp341.exercises.week9_list_singleton.app;

import itp341.exercises.week9_list_singleton.R;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShop;
import itp341.exercises.week9_list_singleton.app.model.CoffeeShopSingleton;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

public class MainListFragment extends Fragment {

    private static final String TAG = MainListFragment.class.getSimpleName();

    Button mButtonAdd;
    ListView mListView;

    //todo don't need to store this anymore (now in adapter)
//    private ArrayList<CoffeeShop> mCoffeeShops;
//    private ArrayAdapter<CoffeeShop> mAdapter;
    private CoffeeAdapter mAdapter;

    public MainListFragment() {
        // Required empty public constructor
    }


    public static MainListFragment newInstance() {
        Bundle args = new Bundle();


        MainListFragment fc = new MainListFragment();
        fc.setArguments(args);

        return fc;
    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);

        Log.d(TAG, "onCreateView");

        //find views
        mButtonAdd = (Button) v.findViewById(R.id.button_add);
        mListView = (ListView)v.findViewById(R.id.listView);

        //TODO access coffee shop list and load it in the list
        ArrayList<CoffeeShop> mCoffeeShops = CoffeeShopSingleton.get(getActivity()).getCoffeeShops();
        mAdapter = new CoffeeAdapter(getActivity(),
                android.R.layout.simple_list_item_1,
                mCoffeeShops);
//        mAdapter = new ArrayAdapter<CoffeeShop>(getActivity(),
//                android.R.layout.simple_list_item_1,
//                mCoffeeShops);
        mListView.setAdapter(mAdapter);

        //TODO What happens when user clicks add?
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),
                        DetailActivity.class);
                startActivityForResult(i, 0);
            }
        });

        //TODO create listview item click listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "onListItemClick");
                Toast.makeText(getActivity(),
                        "Id: " + id + ", mPosition: " + position, Toast.LENGTH_SHORT)
                        .show();

                Intent i = new Intent(getActivity(),
                        DetailActivity.class);
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

        if (resultCode == Activity.RESULT_OK) { // this means user saved
            Log.d(TAG, "onActivityResult: requestCode: " + requestCode);
            mAdapter.notifyDataSetChanged();
        }
        //else means they pressed back and didn't save

    }

    private class CoffeeAdapter extends ArrayAdapter<CoffeeShop> {
        ArrayList<CoffeeShop> shops;
        public CoffeeAdapter(Context context, int resource, ArrayList<CoffeeShop> objects) {
            super(context, resource, objects);
            this.shops = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(
                        R.layout.list_row_item_cardview2, null);
//                convertView = getActivity().getLayoutInflater().inflate(
//                        R.layout.list_row_item, null);

            }
            TextView textName = (TextView)convertView.findViewById(R.id.list_item_name);
            TextView textCity = (TextView)convertView.findViewById(R.id.list_item_city);

            CoffeeShop c = shops.get(position);
            textName.setText(c.getName());
            textCity.setText(c.getCity());
            return convertView;
        }
    }
}
