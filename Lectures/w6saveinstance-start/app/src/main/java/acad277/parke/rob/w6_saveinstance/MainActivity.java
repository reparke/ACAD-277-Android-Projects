package acad277.parke.rob.w6_saveinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //todo: add keys as constants

    private Button buttonMagenta;
    private Button buttonCyan;
    private TextView textOutput;

    //todo: create instance variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMagenta = findViewById(R.id.buttonMagenta);
        buttonCyan = findViewById(R.id.buttonCyan);
        textOutput = findViewById(R.id.textOutput);

        //todo read previous counters


        //todo: enable display counter
        buttonMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //todo: enable display counter
        buttonCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }




}
