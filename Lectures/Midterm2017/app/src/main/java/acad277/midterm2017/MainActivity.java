package acad277.midterm2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textName;
    EditText editName;
    CheckBox checkTerms;
    Button buttonRequest;
    RadioGroup groupLocation;
    RadioButton radioHome;
    RadioButton radioWork;
    RadioButton radioCurrent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (TextView) findViewById(R.id.textName);
        editName = (EditText) findViewById(R.id.editName);
        checkTerms = (CheckBox) findViewById(R.id.checkTerms);
        buttonRequest = (Button) findViewById(R.id.buttonRequest);
        groupLocation = (RadioGroup) findViewById(R.id.groupLocation);
        radioHome = (RadioButton) findViewById(R.id.radioHome);
        radioWork = (RadioButton) findViewById(R.id.radioWork);
        radioCurrent = (RadioButton) findViewById(R.id.radioCurrent);


        checkTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    buttonRequest.setEnabled(true);
                }
                else {
                    buttonRequest.setEnabled(false);
                }
            }
        });

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();
                String location = "";
                int id  = groupLocation.getCheckedRadioButtonId();
                switch(id) {
                    case R.id.radioHome:
                        location = "home";
                        break;
                    case R.id.radioWork:
                        location = "work";
                        break;
                    case R.id.radioCurrent:
                        location = "current location";
                        break;
                }
                Toast.makeText(getApplicationContext(),
                        name + ", a PikUp is on its way to your " + location,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
