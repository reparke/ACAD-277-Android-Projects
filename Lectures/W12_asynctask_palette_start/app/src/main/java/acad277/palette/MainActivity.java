package acad277.palette;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import acad277.palette.asynctask_palette.R;
import acad277.palette.model.Shiba;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();



    TextView mTextName;
    TextView mTextAge;
    TextView mTextColor;
    EditText mEditName;
    Spinner mSpinnerColor;
    EditText mEditAge;
    Button mButtonAdd;
    ListView mListView;
    ImageView mImageView;
    LinearLayout mLayout;
    Toolbar mToolbar;

    ArrayList<Shiba> mDogList;
    ArrayAdapter<Shiba> mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextName = (TextView) findViewById(R.id.textName);
        mTextAge = (TextView) findViewById(R.id.textAge);
        mTextColor = (TextView) findViewById(R.id.textColor);
        mEditName = (EditText) findViewById(R.id.editName);
        mSpinnerColor = (Spinner) findViewById(R.id.spinnerColor);
        mEditAge = (EditText) findViewById(R.id.editAge);
        mButtonAdd = (Button) findViewById(R.id.buttonAdd);
        mListView = (ListView) findViewById(R.id.listView);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mLayout = (LinearLayout) findViewById(R.id.outerLayout);


        mDogList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                mDogList);
        mListView.setAdapter(mAdapter);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //TODO complete image loading
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



            }
        });

    }

    //TODO - Palette - change colors
    /*
    Common available Palette colors
        Vibrant
        Vibrant Dark
        Vibrant Light
        Muted
        Muted Dark
        Muted Light
    */

}





