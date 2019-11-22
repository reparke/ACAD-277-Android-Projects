package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class VolleyGetXkcdActivity extends AppCompatActivity {
    private final String TAG = VolleyGetXkcdActivity.class.getName();
    private final String URL = "";


    private TextView textActivityTitle;
    private TextView textDescription;
    private TextView textTitle;
    private ImageView image;
    private RelativeLayout layout;

    //TODO Volley



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_xkcd);
        layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#d6fffc"));

        image = findViewById(R.id.image);
        textDescription = findViewById(R.id.text_description);
        textTitle = findViewById(R.id.text_title);
        textActivityTitle = findViewById(R.id.text_activity_title);


        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);

        //TODO set up Volley queue

    }

    //TODO This will contact the Volley request for JSON data
    public void requestJSONParse(String reqURL) {

    }
}