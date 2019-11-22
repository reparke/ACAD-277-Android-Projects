package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolleyGetMoviesActivity extends AppCompatActivity {
    private final String TAG = VolleyGetMoviesActivity.class.getName();
    private final String URL = "";
    private final String API_KEY = "";


    private Button buttonSend;
    private EditText editMovieName;
    private TextView textActivityTitle;
    private ListView listMovies;
    private RelativeLayout layout;

    ArrayAdapter<String> adapter;
    ArrayList<String> movies;


    //TODO Volley



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_movies);
        layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#d6fffc"));

        buttonSend = (Button) findViewById(R.id.button_send);
        editMovieName = (EditText) findViewById(R.id.edit_movie_name);
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);
        listMovies = (ListView) findViewById(R.id.list_movies);

        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);


        movies = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                movies);
        listMovies.setAdapter(adapter);


        //TODO set up Volley queue



        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    //TODO This will contact the Volley request for String data
    public void requestString(String reqURL) {

    }

    //TODO This will contact the Volley request for JSON data
    public void requestJSONParse(String reqURL) {

    }
}