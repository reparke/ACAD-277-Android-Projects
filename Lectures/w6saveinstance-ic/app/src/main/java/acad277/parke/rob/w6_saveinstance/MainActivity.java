package acad277.parke.rob.w6_saveinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //todo: add keys as constants
    public static final String BUNDLE_MAGENTA = "BUNDLE_MAGENTA";
    public static final String BUNDLE_CYAN = "BUNDLE_CYAN";

    private Button buttonMagenta;
    private Button buttonCyan;
    private TextView textOutput;

    //todo: create instance variables
    private int counterMagenta = 0;
    private int counterCyan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMagenta = findViewById(R.id.buttonMagenta);
        buttonCyan = findViewById(R.id.buttonCyan);
        textOutput = findViewById(R.id.textOutput);

        //todo read previous counters
        if (savedInstanceState != null ){ //this will be NULL when the activity is FIRST launched
            counterCyan = savedInstanceState.getInt(BUNDLE_CYAN, 0);
            counterMagenta = savedInstanceState.getInt(BUNDLE_MAGENTA, 0);
        }

        //todo: enable display counter
        buttonMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterMagenta++;
                displayOutput();
            }
        });

        //todo: enable display counter
        buttonCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterCyan++;
                displayOutput();
            }
        });

        displayOutput();
    }

    private void displayOutput() {
        String msg = "Magenta clicks: " + counterMagenta;
        msg += "\nCyan clicks: " + counterCyan;

        textOutput.setText(msg);
    }

    //method is called right before screen rotates and activity is destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //store our data in this temporary bundle

        outState.putInt(BUNDLE_MAGENTA, counterMagenta);
        outState.putInt(BUNDLE_CYAN, counterCyan);

    }
}







