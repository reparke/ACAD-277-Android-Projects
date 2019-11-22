package itp341.firebase_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //version 1 - overwrites everything
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference dbParent = database.getReference();
//                dbParent.setValue(editText.getText().toString() );

                //version 2 - generate new ids
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference dbParent = database.getReference();
//                DatabaseReference dbNewRef = dbParent.push();
//                dbNewRef.setValue(editText.getText().toString() );
//
                //version 3 - add data to new node
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference dbParent = database.getReference("Sweet new node");
                DatabaseReference dbNewRef = dbParent.push();
                dbNewRef.setValue(editText.getText().toString() );

                editText.setText("");
                return false;
            }
        });
    }
}
