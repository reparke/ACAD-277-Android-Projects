package itp341.exercises.week4pizzaorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {

    // TAG
    private static final String TAG = MainActivity.class.getSimpleName();

    // variables for widgets
    CheckBox checkPepperoni;
    CheckBox checkPineapple;
    CheckBox checkTofu;
    RadioGroup radioGroupSize;
    SeekBar seekBarNumPizzas;
    TextView textNumPizzasSeekBarProgress;
    Spinner spinnerSpecials;
    TextView textOrderDisplay;
    EditText editName;

    //TODO instance variables
    boolean wantsPepperoni = false;
    boolean wantsPineapple = false;
    boolean wantsTofu = false;
    String size;
    String specials = "none";
    int numPizzas = 1;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to widgets
        textOrderDisplay = (TextView) findViewById(R.id.textOrderDisplay);
        checkPepperoni = (CheckBox) findViewById(R.id.checkPepperoni);
        checkPineapple = (CheckBox) findViewById(R.id.checkPineapple);
        checkTofu = (CheckBox) findViewById(R.id.checkTofu);
        radioGroupSize = (RadioGroup) findViewById(R.id.radioGroupSize);
        textNumPizzasSeekBarProgress = (TextView) findViewById(R.id.textNumPizzasSeekBarProgress);
        seekBarNumPizzas = (SeekBar) findViewById(R.id.seekBarNumPizzas);
        spinnerSpecials = (Spinner) findViewById(R.id.spinnerSpecials);
        editName = (EditText) findViewById(R.id.editName);

        //TODO create EditorActionListener
        editName.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Log.d(TAG, "inside onEditorAction");

                name = editName.getText().toString();

                displayPizzaOrder();
                return false;
            }
        });


        //TODO create checkbox listeners
        checkPepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "in onCheckedChanged for checkPepperoni");
                //update pepperoni variable
                wantsPepperoni = b;
                displayPizzaOrder();

            }
        });
        checkPineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "in onCheckedChanged for checkPineapple");
                //update pepperoni variable
                wantsPineapple = b;
                displayPizzaOrder();

            }
        });
        checkTofu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "in onCheckedChanged for checkTofu");
                //update pepperoni variable
                wantsTofu = b;
                displayPizzaOrder();

            }
        });


        //TODO create radiogroup listener
        radioGroupSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Log.d(TAG, "in oncheckedchangedlistener for radio group");

                switch(checkedId) {
                    case R.id.radioSmall:
                        size = getResources().getString(R.string.label_small);
                        break;
                    case R.id.radioMedium:
                        size = getResources().getString(R.string.label_medium);
                        break;
                    case R.id.radioLarge:
                        size = getResources().getString(R.string.label_large);
                        break;
                    default:
                        Log.d(TAG, "onCheckChangedListener - invalid checkedId");
                }
                displayPizzaOrder();

            }
        });


        //TODO seekbar listener
        seekBarNumPizzas.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d(TAG, "in onProgressChanged for seekBar");
                numPizzas = i;
                textNumPizzasSeekBarProgress.setText(Integer.toString(numPizzas));
                displayPizzaOrder();



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        //TODO create spinner listener
        spinnerSpecials.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {
                Log.d(TAG, "spinner onitemselected");
                specials = ((TextView) v).getText().toString();
                displayPizzaOrder();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

    }
    //TODO generate "human-readable" description of pizza and write to textView
    public void displayPizzaOrder() {
        Log.d(TAG, name);
        StringBuilder msg;

        if (isOrderValid() == true) {
            msg = new StringBuilder("Order for " + name + "\nYou ordered ");

            msg.append(String.valueOf(numPizzas) + " ");
            msg.append(" ");
            msg.append(size);
            msg.append(" pizzas with the following toppings: cheese");
            if (wantsPepperoni)
                msg.append(", "
                        + getResources().getString(R.string.label_pepperoni));
            if (wantsPineapple)
                msg.append(", "
                        + getResources().getString(R.string.label_pineappple));
            if (wantsTofu)
                msg.append(", " + getResources().getString(R.string.label_tofu));
            msg.append("\n");

            msg.append("You will get the following specials: ");
            msg.append(specials);
        }
        else {
            msg = new StringBuilder("Please complete order form");
        }

        textOrderDisplay.setText(msg);

    }

    //TODO determine what qualifies as a valid order
    public boolean isOrderValid() {
        Log.d(TAG, name);

        boolean validOrder = false;

        if (!editName.getText().toString().equals("") && radioGroupSize.getCheckedRadioButtonId() != -1) {
            validOrder = true;
        }
        return validOrder;
    }

}
