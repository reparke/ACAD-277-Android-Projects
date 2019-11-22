package acad277.intent_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import acad277.intent_mvc.week5_intents.R;

public class CompletedActivity extends AppCompatActivity {
	
	private static final String TAG = CompletedActivity.class.getSimpleName();
	public static final String EXTRA_DRINK = "EXTRA_DRINK";
	public static final String EXTRA_REWARDS = "EXTRA_REWARDS";

	private TextView textDrink;
	private ImageView imageDrink;
	private TextView textRewards;

	private Drink drink;
	private boolean joinRewards = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_completed);
	
		textDrink = findViewById(R.id.text_drink);
		textRewards = findViewById(R.id.text_rewards);
		imageDrink = findViewById(R.id.image_drink);

		Intent i = getIntent();
		drink = (Drink) i.getSerializableExtra(EXTRA_DRINK);
		joinRewards = i.getBooleanExtra(EXTRA_REWARDS, false);

		String msg = "";
		if (drink.isWantsHot() == true)
			msg = "hot";
		else
			msg="iced";
		msg += " " + drink.getType();
		textDrink.setText(msg);

		if (drink.getType().equalsIgnoreCase("coffee") && drink.isWantsHot() == true)
			imageDrink.setImageResource(R.drawable.coffee_hot);
		else if (drink.getType().equalsIgnoreCase("coffee") && drink.isWantsHot() == false)
			imageDrink.setImageResource(R.drawable.coffee_iced);
		else if (drink.getType().equalsIgnoreCase("tea") && drink.isWantsHot() == true)
			imageDrink.setImageResource(R.drawable.tea_hot);
        else
			imageDrink.setImageResource(R.drawable.tea_iced);
	

        if (joinRewards == true) {
            textRewards.setText("Thanks for joining our rewards program!");
        }
        else {
            textRewards.setText("Next time if you join the rewards program, you can save 10%");
        }
		
	}
	

	
}
