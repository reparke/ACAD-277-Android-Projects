package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class VolleyGetActivity extends AppCompatActivity {
    private final String TAG = VolleyGetActivity.class.getName();
    private final String URL = "https://restcountries.eu/rest/v2/name/";


    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;

    ArrayAdapter<String> adapter;
    ArrayList<String> languages;


    RequestQueue queue;

    private RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#d6fffc"));

        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_movie_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);;
        listLanguages = (ListView) findViewById(R.id.list_movies);;

        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);


        languages = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                languages);
        listLanguages.setAdapter(adapter);


        queue = Volley.newRequestQueue(this);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = editCountryName.getText().toString();
                String reqURL = URL + country;
//                requestString(reqURL);
                requestJSONParse(reqURL);
            }
        });
        listLanguages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), LanguagesActivity.class);
                i.putExtra(LanguagesActivity.EXTRA_LANGUAGE, adapter.getItem(position));
                startActivityForResult(i, 0);
            }
        });
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

                            JSONObject object = (JSONObject) response.get(0);
                            Log.d(TAG, "first json object: " + object);
                            textJSON.setText(object.toString());

                            String name = object.getString("population");
                            Log.d(TAG, "json object name: " + name);
                            textPopulation.setText(name);

                            JSONArray languagesJSON = object.getJSONArray("languages");
                            Log.d(TAG, "json array: " + languagesJSON.toString());
                            languages.clear();
                            for (int i = 0; i<languagesJSON.length(); i++) {
                                JSONObject obj = (JSONObject) languagesJSON.get(i);
//                                String lang = obj.getString("name");
                                String lang = obj.getString("iso639_1");
                                languages.add(lang);
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
                Log.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        queue.add(req);
    }

//not covered in class anymore
//    public void requestString(String reqURL) {
//        // requestString a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, reqURL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        textJSON.setText(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "That didn't work", Toast.LENGTH_SHORT).show();
//            }
//        });
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//
//
//    }


}
