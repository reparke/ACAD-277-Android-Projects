package itp341.exercises.coachmarks.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import itp341.exercises.coachmarks.R;


public class DetailActivity extends FragmentActivity {

    public static final String TAG = DetailActivity.class.getSimpleName();


    public static final String EXTRA_ID = "extra_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        //get intent data
        Intent i = getIntent();


        long id = i.getLongExtra(EXTRA_ID, -1);
        Log.d(TAG, "intent id = " + id);

        //Create fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);

        if (f == null ) {
             f = DetailFragment.newInstance(id);
        }
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f);
        fragmentTransaction.commit();
    }





}

