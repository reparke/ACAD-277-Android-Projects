package acad277.http_get;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncTaskGetActivity extends AppCompatActivity {
    private final String TAG = AsyncTaskGetActivity.class.getName();
    private final String URL = "https://restcountries.eu/rest/v2/name/";

    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;

    ArrayAdapter<String> adapter;
    ArrayList<String> languages;

    private RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#fffbd6"));


        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_country_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);;
        listLanguages = (ListView) findViewById(R.id.list_languages);;

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

        //TODO execute AsyncTask
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetJSONFromAPI(getApplicationContext()).execute(URL + editCountryName.getText().toString().trim());

            }
        });
    }

    //TODO build asynctask
    private class GetJSONFromAPI extends AsyncTask<String, Void, String> {
        Context context;

        public GetJSONFromAPI(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder response = new StringBuilder("");
            try {
                //Create URL object from String (e.g. "http://www.google.com")
                java.net.URL url = new URL(params[0]);

                //HttpURLConnection is used to send / receive data over the web
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                //Provides a readable source of bytes
                InputStream is = httpURLConnection.getInputStream();

                //Wrap InputStream with InputStreamReader
                //Input stream of bytes is converted to stream of characters
                //Buffer reading operation to improve efficiency
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                //Read all characters into String data
                String line;
                while ((line = reader.readLine()) != null)
                    response.append(line);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response.toString();
        }

        @Override
        protected void onPostExecute(String jsonString) {
            textJSON.setText(jsonString);
            try {

                //IMPORTANT NOTE: This JSON string is stored in an array
                //so we need to use Tokener to make it a JSON array
                //in the case of the Volley version, the data is already a JSONArray
                JSONArray jsonArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
                Log.d(TAG, "json array: " + jsonArray.toString());

                JSONObject object = jsonArray.getJSONObject(0);
                Log.d(TAG, "first json object: " + object.toString());

                String population = object.getString("population");
                textPopulation.setText(population);

                JSONArray languagesJSON = object.getJSONArray("languages");
                Log.d(TAG, "json array: " + languagesJSON.toString());
                languages.clear();
                for (int i = 0; i<languagesJSON.length(); i++) {
                    JSONObject obj = (JSONObject) languagesJSON.get(i);
                    String lang = obj.getString("name");
                    languages.add(lang);
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
