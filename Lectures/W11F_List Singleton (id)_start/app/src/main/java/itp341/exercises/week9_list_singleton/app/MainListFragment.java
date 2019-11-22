package itp341.exercises.week9_list_singleton.app;

import itp341.exercises.week9_list_singleton.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainListFragment extends Fragment {

    private static final String TAG = MainListFragment.class.getSimpleName();

    Button buttonAdd;
    ListView listView;

    //TODO create array and adapter



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


        //TODO What happens when user clicks add?
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "mButtonadd: onClick ");
            }
        });

        //TODO create listview item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "listView: onListItemClick");

            }
        });

        return v;
    }




    //TODO finish onActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);

    }
}
