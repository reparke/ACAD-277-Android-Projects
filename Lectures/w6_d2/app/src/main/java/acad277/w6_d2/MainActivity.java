package acad277.w6_d2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //store reference (variables) to EVERY widget we care about
    //instance variables
    private TextView textOutput;
    private Button buttonReset;
    private Button buttonClickMe;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_main2);

        //once the layout is created (we called INFLATED)
        //inflation is the process of turning XML into a objects on the screen
        textOutput = (TextView) findViewById(R.id.text_output);
        buttonClickMe = (Button) findViewById(R.id.button_click_me);
        buttonReset = (Button) findViewById(R.id.button_reset);

        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textOutput.setText(String.valueOf(5));
//                Toast.makeText(getApplicationContext(), "This is a toast!", Toast.LENGTH_LONG).show();
                counter++;
                textOutput.setText(String.valueOf(counter));
//                textOutput.setText(R.string.label_hello);
//                textOutput.setText("Hi y'all!");


            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                textOutput.setText(String.valueOf(counter));
            }
        });


    }
}






