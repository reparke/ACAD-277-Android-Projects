package itp341.http_get;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class VolleyGetActivity extends AppCompatActivity {
    private final String TAG = VolleyGetActivity.class.getName();

    //TODO URL string
    private final String URL = "";


    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;
    private RelativeLayout layout;

    ArrayAdapter<String> adapter;
    ArrayList<String> languages;

    //TODO Volley


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        layout = (RelativeLayout) findViewById(R.id.layout);
        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_country_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);
        listLanguages = (ListView) findViewById(R.id.list_languages);

        layout.setBackgroundColor(Color.parseColor("#d6fffc"));

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
