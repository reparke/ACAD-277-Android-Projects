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
import android.widget.ToggleButton;

import acad277.intent_mvc.week5_intents.R;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

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

				//todo create and launch intent

			}
		});
	}

}
