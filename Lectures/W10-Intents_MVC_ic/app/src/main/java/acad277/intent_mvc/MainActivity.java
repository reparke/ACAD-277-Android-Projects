package acad277.intent_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import acad277.intent_mvc.model.Order;
import acad277.intent_mvc.week5_intents.R;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	public static final String EXTRA_ORDER = "EXTRA_ORDER";
	public static final String EXTRA_REWARDS = "EXTRA_REWARDS";

	private ToggleButton toggleHot;
	private RadioGroup groupType;
	private Switch switchCream;
	private Button buttonPurchase;
	private CheckBox checkRewards;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toggleHot = findViewById(R.id.toggle_hot_iced);
		groupType =  findViewById(R.id.group_drink);
		switchCream = findViewById(R.id.switch_cream);
		buttonPurchase = findViewById(R.id.button_purchase);
		checkRewards = findViewById(R.id.check_rewards);


		buttonPurchase.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//todo read data from UI
				Order order = new Order();
                if (groupType.getCheckedRadioButtonId() == R.id.radio_coffee) {
                    order.setDrink("coffee");
                } else {
                    order.setDrink("tea");
                }
                order.setWantsCream(switchCream.isChecked());
                order.setWantsIced(!toggleHot.isChecked());

                boolean wantsRewards = checkRewards.isChecked();


				//todo create and launch intent
                Intent intent = new Intent(getApplicationContext(), CompletedActivity.class);
                //add whatever data you want to send to the other activity
                intent.putExtra(EXTRA_ORDER, order);
                intent.putExtra(EXTRA_REWARDS, wantsRewards);

                //if you want to send an object that YOU built (any custom class)
                //you need to IMPLEMENTS SERIALIZABLE to the class declaration

                //send the message
                startActivityForResult(intent, 0);  //code is made up by you

			}
		});
	}

	//what is this?
    //this method gets called by Android when the child activity we started finally finishes
    //so here is where we process any data the child wanted to send
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) { //why 0? because that was the code we made when we launched the activity
            boolean choice = data.getBooleanExtra(CompletedActivity.EXTRA_SHAME_CHOICE, false);
            if (choice == true) {
                Toast.makeText(getApplicationContext(), "Glad you finally care about your family", Toast.LENGTH_SHORT).show();
            }
        }
    }
}






