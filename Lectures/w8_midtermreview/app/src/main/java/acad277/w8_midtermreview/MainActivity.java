package acad277.w8_midtermreview;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private instance variables
    private SeekBar seekMonths;
    private TextView textMonths;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect "wire up"
        seekMonths = (SeekBar) findViewById(R.id.seekMonths);
        textMonths = (TextView) findViewById(R.id.textMonths);
        buttonReset = (Button) findViewById(R.id.buttonReset);

//        textMonths.setText("Hello!");
        String msg = textMonths.getText().toString();

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMonths.setText("");
                seekMonths.setProgress(0);

            }
        });


        seekMonths.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int adjMonth = progress + 1;
                textMonths.setText("You have selected month: " + adjMonth);


            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





//
//        String[] names = new String[10];
//        names[0] = "jaime";
//        names[1] = "sonika";
//        names[2] = "naylee";
//        names[3] = "ben";
//        names[2] = "";
//
//
//        ArrayList<String> pets = new ArrayList<>();
//        pets.add("Mocha");
//        pets.add("Lola");
//        pets.add("Rosie");
//        pets.add("Leo");
//        pets.add("Kahlo");
//
//        String favPet = pets.get(1);
//        pets.remove(2);
//        pets.set(0, "Mocha Poca");




    }
}
