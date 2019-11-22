package itp341.exercises.asynctask_palette;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import itp341.exercises.asynctask_palette.model.Shiba;


public class Fragment_Palette extends Fragment {
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

    public Fragment_Palette() {
        // Required empty public constructor
    }


    public static Fragment_Palette newInstance() {

        Fragment_Palette f = new Fragment_Palette();

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);


        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mTextName = (TextView) v.findViewById(R.id.textName);
        mTextAge = (TextView) v.findViewById(R.id.textAge);
        mTextColor = (TextView) v.findViewById(R.id.textColor);
        mEditName = (EditText) v.findViewById(R.id.editName);
        mSpinnerColor = (Spinner) v.findViewById(R.id.spinnerColor);
        mEditAge = (EditText) v.findViewById(R.id.editAge);
        mButtonAdd = (Button) v.findViewById(R.id.buttonAdd);
        mListView = (ListView) v.findViewById(R.id.listView);
        mImageView = (ImageView) v.findViewById(R.id.imageView);
        mLayout = (LinearLayout) v.findViewById(R.id.outerLayout);


        mDogList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mDogList);
        mListView.setAdapter(mAdapter);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shiba s = new Shiba();
                s.setName(mEditName.getText().toString());

                String tempInt = mEditAge.getText().toString();
                if (tempInt.equals(""))
                    s.setAge(0);
                else
                    s.setAge(Integer.parseInt(tempInt));


                s.setColor(mSpinnerColor.getSelectedItem().toString());

                mDogList.add(s);
                mAdapter.notifyDataSetChanged();
                Log.d("Shiba", s.toString());
                Log.d("Shiba array", mDogList.toString());
            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shiba s = mDogList.get(i);
                mEditName.setText(s.getName());
                mEditAge.setText(String.valueOf(s.getAge()));
                Log.d("Shiba List", s.toString());
                Bitmap bm;
                int resId;

                if (s.getColor().equalsIgnoreCase("black")) {
                    resId = R.drawable.shiba_black;
                } else if (s.getColor().equalsIgnoreCase("sesame")) {
                    resId = R.drawable.shiba_sesame;
                } else {
                    resId = R.drawable.shiba_white;
                }

                mImageView.setImageResource(resId);
                bm = BitmapFactory.decodeResource(getResources(), resId);
                new PaletteTask(getActivity()).execute(bm);


            }
        });

        return v;
    }

    //TODO - Palette - change colors
    /*
    Common available Paletter colors
        Vibrant
        Vibrant Dark
        Vibrant Light
        Muted
        Muted Dark
        Muted Light
    */
    private void updateColors(Palette p) {
        //change background color of activity
        mLayout.setBackgroundColor(p.getDarkMutedColor(0x000));

        //change background color of mListview and other views
        int lightMutedColor = p.getLightMutedColor(0x000);
        int darkVibrantColor = p.getDarkVibrantColor(0x000);

        mListView.setBackgroundColor(lightMutedColor);
        mEditName.setBackgroundColor(lightMutedColor);
        mEditAge.setBackgroundColor(lightMutedColor);
        mTextAge.setBackgroundColor(lightMutedColor);
        mTextName.setBackgroundColor(lightMutedColor);
        mTextColor.setBackgroundColor(lightMutedColor);
        mSpinnerColor.setBackgroundColor(lightMutedColor);

        //change color of toolbar background
        mToolbar.setBackgroundColor(p.getDarkMutedColor(0x000));


    }

    //TODO - Palette Task
    public class PaletteTask extends AsyncTask<Bitmap, Void, Palette> {

        private final String TAG = PaletteTask.class.getSimpleName();
        private Context context;

        public PaletteTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Palette doInBackground(Bitmap... params) {
            Bitmap bm = params[0];
            Palette p = Palette.from(bm).generate();

            return p;
        }

        @Override
        protected void onPostExecute(Palette p) {
            super.onPostExecute(p);

            updateColors(p);
        }
    }
}


