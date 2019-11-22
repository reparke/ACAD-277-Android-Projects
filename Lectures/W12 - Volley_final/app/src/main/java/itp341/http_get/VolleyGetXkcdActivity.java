package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolleyGetXkcdActivity extends AppCompatActivity {
    private final String TAG = VolleyGetXkcdActivity.class.getName();
    private final String URL = "https://xkcd.com/info.0.json";


    private TextView textActivityTitle;
    private TextView textDescription;
    private TextView textTitle;
    private ImageView image;

    RequestQueue queue;

    private RelativeLayout layout;


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




        queue = Volley.newRequestQueue(this);
        requestJSONParse(URL);


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
                            String title = response.getString("safe_title");
                            String desc =  response.getString("alt");
                            String imgLocation =  response.getString("img");



                            textTitle.setText(title);
                            textDescription.setText(desc);
                            Picasso.get().load(imgLocation).into(image);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


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