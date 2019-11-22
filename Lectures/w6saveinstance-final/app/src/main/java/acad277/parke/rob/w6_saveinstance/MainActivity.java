package acad277.parke.rob.w6_saveinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //todo: add keys as constants
    private static final String BUNDLE_MAGENTA = "BUNDLE_MAGENTA";
    private static final String BUNDLE_CYAN = "BUNDLE_CYAN";



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

        //todo read previous counters
        if (savedInstanceState != null) {
            counterMagenta = savedInstanceState.getInt(BUNDLE_MAGENTA);
            counterCyan = savedInstanceState.getInt(BUNDLE_CYAN);
        }

        buttonMagenta = findViewById(R.id.buttonMagenta);
        buttonCyan = findViewById(R.id.buttonCyan);
        textOutput = findViewById(R.id.textOutput);

        //todo: enable display counter
        buttonMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterMagenta++;
                updateOutput();
            }
        });

        //todo: enable display counter
        buttonCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterCyan++;
                updateOutput();
            }
        });
        updateOutput();
    }

    private void updateOutput() {
        String msg = "Magenta clicks: " + counterMagenta;
        msg += "\nCyan clicks: " + counterCyan;
        textOutput.setText(msg);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_MAGENTA, counterMagenta);
        outState.putInt(BUNDLE_CYAN, counterCyan);
    }
}
/*
    1. want to display button clicks
        add counters
        complete listeners
        write output
     2.demo
     3. add write output in oncreate
     4. rotate
     5. go back to slides for onsave instance state
     6. enable on save

 */