package acad277.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
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

                Shiba s = new Shiba();
                if (mEditAge.getText().toString().equals("")) {
                    s.setAge(0);
                }
                else {
                    s.setAge(Integer.valueOf(mEditAge.getText().toString()));
                }

                s.setColor(mSpinnerColor.getSelectedItem().toString());
                s.setName(mEditName.getText().toString());

                mDogList.add(s);
                mAdapter.notifyDataSetChanged();


            }
        });


        //TODO complete image loading
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Shiba s = mDogList.get(position);

                Bitmap bm;
                int resId;

                if (s.getColor().equalsIgnoreCase("black")) {
                    //retrieve the id for the black shiba
                    resId = R.drawable.shiba_black;
                }
                else if (s.getColor().equalsIgnoreCase("sesame")) {
                    resId = R.drawable.shiba_sesame;
                }
                else {
                    resId = R.drawable.shiba_white;
                }

                mImageView.setImageResource(resId);

                //palette needs a bitmap
                bm = BitmapFactory.decodeResource(getResources(), resId);

                Palette.from(bm).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        //this is where we change colors
                        //colors are reprsented as ints
                        int darkMutedColor = palette.getDarkMutedColor(0xF58C99);
                        int lightMutedColor = palette.getLightMutedColor(0xF58C99);
                        int darkVibrantColor = palette.getDarkVibrantColor(0x000);

//                        Color c = Color.valueOf)


                        mLayout.setBackgroundColor(darkMutedColor);
                        mListView.setBackgroundColor(lightMutedColor);
                        mEditName.setBackgroundColor(lightMutedColor);
                        mEditAge.setBackgroundColor(lightMutedColor);
                        mTextAge.setBackgroundColor(lightMutedColor);
                        mTextColor.setBackgroundColor(lightMutedColor);
                        mTextName.setBackgroundColor(lightMutedColor);
                        mSpinnerColor.setBackgroundColor(lightMutedColor);



                    }
                });



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





