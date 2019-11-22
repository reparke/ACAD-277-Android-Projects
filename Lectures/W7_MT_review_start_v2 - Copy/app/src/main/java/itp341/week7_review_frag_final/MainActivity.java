package itp341.week7_review_frag_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String BUNDLE_NUM_VOTES = "BUNDLE_NUM_VOTES";

    private EditText editSpeak;
    private RadioGroup radioGroupVote;
    private TextView textNumVotes;
    private ImageView image;
    private TextView textSpeak;

    private int numVotes = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {   //means second time (or third etc.) that the activity has come to life
            numVotes = savedInstanceState.getInt(BUNDLE_NUM_VOTES);
        }


        editSpeak = findViewById(R.id.editSpeak);
        radioGroupVote = findViewById(R.id.radioGroupVote);
        textNumVotes = findViewById(R.id.textNumVotes);
        image = findViewById(R.id.image);
        textSpeak = findViewById(R.id.textSpeak);

        textNumVotes.setText(Integer.toString(numVotes));

        radioGroupVote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String speakText;

                switch (checkedId) {
                    case R.id.radioPirate:
                        image.setImageResource(R.drawable.pirate);
                        if(editSpeak.getText().toString().equalsIgnoreCase("")) {
                            speakText = getResources().getString(R.string.label_default_pirate_speak);
                        }
                        else {
                            speakText = editSpeak.getText().toString();
                        }
                        textSpeak.setText(speakText);
                        numVotes++;
                        radioGroupVote.clearCheck();
                        editSpeak.setText("");
                        break;
                    case R.id.radioWolf:
                        image.setImageResource(R.drawable.wolf);
                        if(editSpeak.getText().toString().equalsIgnoreCase("")) {
                            speakText = getResources().getString(R.string.label_default_wolf_speak);
                        }
                        else {
                            speakText = editSpeak.getText().toString();
                        }
                        textSpeak.setText(speakText);
                        numVotes++;
                        radioGroupVote.clearCheck();
                        editSpeak.setText("");
                        break;
                }
                textNumVotes.setText(Integer.toString(numVotes));
            }
        });



    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //store our data in the bundle
        //data is the VALUE, and the constant we made is the KEY (which is an index)
        outState.putInt(BUNDLE_NUM_VOTES, numVotes);
    }

}




