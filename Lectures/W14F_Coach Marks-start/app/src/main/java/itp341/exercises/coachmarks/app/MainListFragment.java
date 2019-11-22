package itp341.exercises.coachmarks.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import itp341.exercises.coachmarks.R;
import itp341.exercises.coachmarks.app.database.CoffeeShopDbSchema;
import itp341.exercises.coachmarks.app.model.CoffeeShopSingleton;


public class MainListFragment extends Fragment {

    private static final String TAG = MainListFragment.class.getSimpleName();

    Button mButtonAdd;
    ListView mListView;


    Cursor mCursor;
    CursorAdapter mAdapter;


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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);

        Log.d(TAG, "onCreateView");

        //find views
        mButtonAdd = (Button)v.findViewById(R.id.button_add);
        mListView = (ListView)v.findViewById(R.id.listView);


        loadData();


        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(),
                        DetailActivity.class);
                startActivityForResult(i, 0);
            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "onListItemClick: clicked id: " + id);
                Toast.makeText(getActivity().getApplicationContext(),
                        "Id: " + id + ", position: " + position, Toast.LENGTH_SHORT)
                        .show();

                Intent i = new Intent(getActivity().getApplicationContext(),
                        DetailActivity.class);
                i.putExtra(DetailActivity.EXTRA_ID, id);

                startActivityForResult(i, 0);

            }
        });

        //TODO set up initial coach marks
        // set up preferences to show coach marks on first run

        return v;
    }


    //TODO coachmarks
    //For first time application is run
    public void onCoachMark() {

    }


    private void loadData() {

        new DBSelectAllTask(getActivity()).execute();

    }
    public void onPause() {
        // Called after onStart() as Activity comes to foreground.
        Log.d(TAG, "onResume");
        super.onPause();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: resultCode: " + resultCode);

        if (resultCode == Activity.RESULT_OK) { // this means user saved
            Log.d(TAG, "onActivityResult - NotifyDAtaset changed");
            loadData();
            mAdapter.notifyDataSetChanged();
        }

    }

    //TODO Asynctask
    //**********************************************************************************************
    //  DBSelectAllTask - AsyncTask for DB reading
    //**********************************************************************************************

    private class DBSelectAllTask extends AsyncTask<Void, Void, Cursor> {
        private Context mContext;
        public DBSelectAllTask(Context context) {
            mContext = context;
        }
        @Override
        protected Cursor doInBackground(Void... voids) {
            mCursor = CoffeeShopSingleton.get(mContext).getCoffeeShops();
            return mCursor;
        }

        //TODO Modify for cursorwrapper
        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);

            String[] from = new String[]{
                    CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.KEY_NAME,
                    CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.KEY_CITY
            };
            int[] to = new int[]{
                    R.id.text_name,
                    R.id.text_city
            };

            mAdapter = new CoffeeShopCursorAdapter(
                    getActivity(),
                    R.layout.cursor_row,
                    cursor,
                    from,
                    to);

            mListView.setAdapter(mAdapter);
        }
    }

    private class CoffeeShopCursorAdapter extends CursorAdapter {

        private String[] mFrom;
        private int[] mTo;
        private LayoutInflater mInflater;
        private int mLayout;

        public CoffeeShopCursorAdapter(Context context,
                                       int layout,
                                       Cursor c,
                                       String[] from,
                                       int[] to) {
            super(context,c,0);
            mInflater = LayoutInflater.from(context);
            mFrom = from;
            mTo = to;
            mLayout = layout;

        }



        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return mInflater.inflate(mLayout,null);

        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView textName = (TextView) view.findViewById(R.id.text_name);
            TextView textCity = (TextView) view.findViewById(R.id.text_city);
            textName.setText(cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_NAME));
            textCity.setText(cursor.getString(CoffeeShopDbSchema.TABLE_COFFEE_SHOPS.COLUMN_CITY));


        }

    }


}