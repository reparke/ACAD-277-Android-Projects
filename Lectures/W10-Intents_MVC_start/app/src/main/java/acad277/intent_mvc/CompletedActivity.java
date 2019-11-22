package acad277.intent_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import acad277.intent_mvc.week5_intents.R;

public class CompletedActivity extends AppCompatActivity {
	
	private static final String TAG = CompletedActivity.class.getSimpleName();
	//TODO extra keys

	private TextView textDrink;
	private ImageView imageDrink;
	private TextView textRewards;

	//todo instance variables

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_completed);
	
		textDrink = findViewById(R.id.text_drink);
		textRewards = findViewById(R.id.text_rewards);
		imageDrink = findViewById(R.id.image_drink);

        //todo read intent

        //todo display drink and rewards status


	}

}
