package itp341.firebase_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //the main location we store data
    DatabaseReference dbParent;
    DatabaseReference dbNewLocation;

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize / point to the correct location in the database
        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        dbParent = firebase.getReference("ِACAD277 Sub Node");

        Toast.makeText(getApplicationContext(), dbParent.toString(), Toast.LENGTH_LONG).show();

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String input = editText.getText().toString();

                dbNewLocation = dbParent.push();    //new location
                //lets store the message into the database
                dbNewLocation.setValue(input);

                editText.setText("");
                return false;
            }
        });
    }
}
