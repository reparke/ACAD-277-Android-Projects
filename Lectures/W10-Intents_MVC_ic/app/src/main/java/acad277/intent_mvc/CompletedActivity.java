package acad277.intent_mvc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import acad277.intent_mvc.model.Order;
import acad277.intent_mvc.week5_intents.R;

public class CompletedActivity extends AppCompatActivity {
	
	private static final String TAG = CompletedActivity.class.getSimpleName();
	//TODO extra keys
    public static final String EXTRA_SHAME_CHOICE = "EXTRA_SHAME_CHOICE";

	private TextView textDrink;
	private ImageView imageDrink;
	private TextView textRewards;

	private Button buttonJoin;
	private Button buttonNew;
	//todo instance variables

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_completed);

		buttonJoin = findViewById(R.id.button_join);
		buttonNew = findViewById(R.id.button_new);

		textDrink = findViewById(R.id.text_drink);
		textRewards = findViewById(R.id.text_rewards);
		imageDrink = findViewById(R.id.image_drink);

        //todo read intent
        Intent intent = getIntent();

        //when you want to retrieve a custom object, you will need to CAST that from the intent
        Order order = (Order) intent.getSerializableExtra(MainActivity.EXTRA_ORDER);
        boolean wantsRewards = intent.getBooleanExtra(MainActivity.EXTRA_REWARDS, false);

        //todo display drink and rewards status
        String msg = "";
        if (order.isWantsIced()) {
            msg += "iced ";
        }
        else {
            msg += "hot ";
        }
        msg += order.getDrink();
        if (order.isWantsCream()) {
            msg += " with cream";
        }
        else {
            msg += " without cream";
        }
        textDrink.setText(msg);

        if(wantsRewards == true) {
            textRewards.setText("Thanks for joining the family!");
        }
        else {
            textRewards.setText("Clearly you don't love your family");
        }

        if (order.getDrink().equalsIgnoreCase("coffee")) {
            if (order.isWantsIced()) {                  //iced coffee
                imageDrink.setImageResource(R.drawable.coffee_iced);
            }
            else {                                      //hot tea
                imageDrink.setImageResource(R.drawable.coffee_hot);
            }
        }
        else {      //tea
            if (order.isWantsIced()) {  //iced tea
                imageDrink.setImageResource(R.drawable.tea_iced);
            }
            else {                      //hot tea
                imageDrink.setImageResource(R.drawable.tea_hot);
            }
        }

        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();       //end the activity
            }
        });
        buttonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                if you want to RETURN to the parent activity AND send data back
                you need to create BLANK INTENT
                frustratingly, you are using an intent SOLELY to send data
                 */
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);       //avoid
                Intent intent = new Intent();       //empty
                intent.putExtra(EXTRA_SHAME_CHOICE, true);

                //we want to return to the parent that created, we don't LAUNCH this intent
                //instead, we simply call SET RESULT
                //setResult takes two parameters
                //      Activity.RESULT_OK
                //      intent
                setResult(Activity.RESULT_OK, intent);
                finish();


            }
        });

	}

}




