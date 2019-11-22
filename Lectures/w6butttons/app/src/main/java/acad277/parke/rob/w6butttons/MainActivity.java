package acad277.parke.rob.w6butttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //EVERY PROJECT, YOU NEED TO GET REFERENCES TO ALL THE WIDGETS YOU WANT TO INTERACT WITH
    //in the class but NOT in any method, define references
    private EditText editFood;
    private Button buttonAdd;
    private TextView textOutput;
    private ArrayList<String> foods;        //making the arraylist variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 2 -- ALWAYS DO THIS
        editFood = findViewById(R.id.editFood);
        buttonAdd = findViewById(R.id.buttonAdd);
        textOutput = findViewById(R.id.textOutput);

        //initialize the arraylist
        foods = new ArrayList<>();

        //listener for the button click
        //generally, all our "listener" code will be in onCreate
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this is what should when the button is clicked
                String foodToAdd = editFood.getText().toString();
                editFood.setText("");
                foods.add(foodToAdd);

//                String output = "Here are the foods: \n";
//                String output = getResources().getString(R.string.label_here_are_foods);
//                String output = getResources().getString(R.string.);
//                for (int i = 0; i < foods.size(); i++) {
//                    output = output + foods.get(i) + "\n";
//                }
//                textOutput.setText(output);
            }
        });

    }
}








