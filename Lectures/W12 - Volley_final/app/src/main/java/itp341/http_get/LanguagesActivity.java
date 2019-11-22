package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LanguagesActivity extends AppCompatActivity {
    public final static String EXTRA_LANGUAGE = "extra_language";
    private final static String TAG = LanguagesActivity.class.getSimpleName();
    private final String URL = "https://restcountries.eu/rest/v2/lang/";


    private ListView listCountries;
    private TextView textLanguage;

    private RequestQueue queue;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> countries;
    private RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#d6fffc"));


        textLanguage = (TextView) findViewById(R.id.text_language);
        listCountries = (ListView) findViewById(R.id.list_countries);

        Intent i = getIntent();
        String language = i.getStringExtra(EXTRA_LANGUAGE);

        textLanguage.setText(language);

        countries  = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries);
        listCountries.setAdapter(adapter);


        queue = Volley.newRequestQueue(this);
        requestJSONParse(URL + language);



    }
    //IMPORTANT NOTE: unlike the HTTP version, this JSON is already returned
    //as a JSONArray
    public void requestJSONParse(String reqURL) {
        JsonArrayRequest req = new JsonArrayRequest(reqURL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Parsing json array response
                            // loop through each json object and find the appropriate object.
                            Log.d(TAG, "json array response: " + response.toString());

                            for (int i = 0; i<response.length(); i++) {
                                JSONObject obj = (JSONObject) response.get(i);
                                String country = obj.getString("name");
                                countries.add(country);

                            }
                            adapter.notifyDataSetChanged();



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        queue.add(req);
    }
}
