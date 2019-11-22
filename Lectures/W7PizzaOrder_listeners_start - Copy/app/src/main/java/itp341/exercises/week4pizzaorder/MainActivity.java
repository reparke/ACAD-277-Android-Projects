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

    //  variables for widgets
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
    private String name = "";
    private boolean wantsPepperoni = false;
    private boolean wantsTofu = false;
    private boolean wantsPineapple = false;
    private String size = "";
    private int numPizzas = 1;
    private String specials = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to widgets
        editName = findViewById(R.id.editName);
        checkPepperoni = findViewById(R.id.checkPepperoni);
        checkPineapple = findViewById(R.id.checkPineapple);
        checkTofu = findViewById(R.id.checkTofu);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        seekBarNumPizzas = findViewById(R.id.seekBarNumPizzas);
        textNumPizzasSeekBarProgress = findViewById(R.id.textNumPizzasSeekBarProgress);
        spinnerSpecials = findViewById(R.id.spinnerSpecials);
        textOrderDisplay = findViewById(R.id.textOrderDisplay);



        //TODO create EditorActionListener
        editName.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                name = editName.getText().toString();
                displayPizzaOrder();
                return true;
            }
        });

        //TODO create checkbox listeners
        checkTofu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wantsTofu = isChecked;
                displayPizzaOrder();
            }
        });
        checkPineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wantsPineapple = isChecked;
                displayPizzaOrder();
            }
        });

        checkPepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wantsPepperoni = isChecked;
                displayPizzaOrder();
            }
        });



        //TODO create radiogroup listener
        radioGroupSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioSmall) { //user selected small
//                    size = "small"; // this won't localize
                    size = getResources().getString(R.string.label_small);
                }
                else if (checkedId == R.id.radioMedium) {
                    size = getResources().getString(R.string.label_medium);
                }
                else {
                    size = getResources().getString(R.string.label_large);
                }

                displayPizzaOrder();
            }
        });


        //TODO seekbar listener
        seekBarNumPizzas.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numPizzas = progress;

                //update the textview next to seekbar MANUALLY
                textNumPizzasSeekBarProgress.setText(String.valueOf(numPizzas));
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
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] options = getResources().getStringArray(R.array.label_array_specials);
                specials = options[position];

                displayPizzaOrder();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //TODO generate "human-readable" description of pizza and write to textView

    }
    public void displayPizzaOrder() {
        String result = "";
        if (isOrderValid() == true) {
            result = name + ":\n";
            //ONE LARGE pizza
            //TOPPINGS
            //SPECIALS
            result += numPizzas + " " + size + " pizzas\n";

            if (wantsPepperoni == true) {
                result += getResources().getString(R.string.label_pepperoni) + ", ";
            }
            if (wantsPineapple == true) {
                result += getResources().getString(R.string.label_pineappple) + ", ";
            }
            if (wantsTofu == true) {
                result += getResources().getString(R.string.label_tofu) + ", ";
            }
            result += specials;
        }
        else {
            //add String resources for localization that says "Please complete order"
        }

        textOrderDisplay.setText(result);

    }

    //TODO determine what qualifies as a valid order
    public boolean isOrderValid() {
        if (name.equalsIgnoreCase("") || size.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }


}



