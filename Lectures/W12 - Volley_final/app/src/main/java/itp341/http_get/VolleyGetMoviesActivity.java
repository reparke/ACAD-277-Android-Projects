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
    private final String URL = "http://www.omdbapi.com/?";
    private final String API_KEY = "785870d6";


    private Button buttonSend;
    private EditText editMovieName;
    private TextView textActivityTitle;
    private ListView listMovies;

    ArrayAdapter<String> adapter;
    ArrayList<String> movies;


    RequestQueue queue;

    private RelativeLayout layout;


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


        queue = Volley.newRequestQueue(this);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = editMovieName.getText().toString();
                String reqURL = URL + "apikey=" + API_KEY + "&s=" + country;
                Log.d(TAG, "URL: " + reqURL);
                requestJSONParse(reqURL);
            }
        });

    }

    //IMPORTANT NOTE: unlike the HTTP version, this JSON is already returned
    //as a JSONArray
    public void requestJSONParse(String reqURL) {

        JsonObjectRequest req = new JsonObjectRequest
                (Request.Method.GET, reqURL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // Parsing json array response
                        // loop through each json object and find the appropriate object.
                        try {
                            Log.d(TAG, "json array response: " + response.toString());

                            JSONArray moviesJSON = response.getJSONArray("Search");
                            Log.d(TAG, "json array: " + moviesJSON.toString());
                            movies.clear();
                            for (int i = 0; i<moviesJSON.length(); i++) {
                                JSONObject obj = (JSONObject) moviesJSON.get(i);
                                String lang = obj.getString("Title");
                                movies.add(lang);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Error: " + error.getMessage(),
                                Toast.LENGTH_LONG).show();

                    }

                });
        queue.add(req);

    }
}