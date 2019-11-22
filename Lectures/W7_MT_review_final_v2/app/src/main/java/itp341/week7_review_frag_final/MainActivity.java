package itp341.week7_review_frag_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textNumVotes;
    private RadioGroup radioGroupVote;
    private EditText editSpeak;
    private TextView textSpeak;
    private ImageView image;

    public final static String BUNDLE_NUM_VOTES = "BUNDLE_NUM_VOTES";

    public final static int CODE_PIRATE = 4;
    public final static int CODE_WOLF = 7;

    private int numVotes = 0;
    private String speak;
    private String vote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupVote = findViewById(R.id.radioGroupVote);
        textNumVotes = findViewById(R.id.textNumVotes);
        editSpeak = findViewById(R.id.editSpeak);
        textSpeak = findViewById(R.id.textSpeak);
        image = findViewById(R.id.image);


        if (savedInstanceState != null) {
            numVotes = savedInstanceState.getInt(BUNDLE_NUM_VOTES, 0);
        }
        textNumVotes.setText(Integer.toString(numVotes));





        radioGroupVote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                speak = editSpeak.getText().toString();


                switch(i) {
                    case R.id.radioPirate:
                        numVotes++;
                        textNumVotes.setText(Integer.toString(numVotes));
                        image.setImageResource(R.drawable.pirate);
                        if (speak.isEmpty()) {
                            textSpeak.setText(R.string.label_default_pirate_speak);
                        }
                        else {
                            textSpeak.setText(speak);
                        }
                        radioGroupVote.clearCheck();    //to prevent "votes" on rotation

                        break;
                    case R.id.radioWolf:
                        numVotes++;
                        textNumVotes.setText(Integer.toString(numVotes));
                        vote = getResources().getString(R.string.label_wolf);
                        image.setImageResource(R.drawable.wolf);
                        if (speak.isEmpty()) {
                            textSpeak.setText(R.string.label_default_wolf_speak);
                        }
                        else {
                            textSpeak.setText(speak);
                        }
                        radioGroupVote.clearCheck();    //to prevent "votes" on rotation

                        break;
                }
            }
        });


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_NUM_VOTES, numVotes);
    }
}






