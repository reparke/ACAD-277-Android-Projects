package itp341.lists;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import itp341.lists.R;
import itp341.lists.model.Food;

public class MainActivity extends AppCompatActivity {

    //get references
    private TextView textChoice;
    private Button buttonAdd;
    private EditText editName;
    private EditText editQuantity;
    private EditText editLocation;
    private ListView listFood;

//    ArrayList<String> foods;        //model aka your data
//    ArrayAdapter<String> adapter;   //controller which populates model data to the listview (aka view)
    ArrayList<Food> foods;        //model aka your data
    ArrayAdapter<Food> adapter;   //controller which populates model data to the listview (aka view)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textChoice = findViewById(R.id.textChoice);
        buttonAdd = findViewById(R.id.button_add);
        editName = findViewById(R.id.edit_add_name);
        editQuantity = findViewById(R.id.edit_add_quantity);
        editLocation = findViewById(R.id.edit_add_location);
        listFood = findViewById(R.id.list_food);

        foods = new ArrayList<>();

        foods.add(new Food("pineapple",  "Hawaii", 4));
        foods.add(new Food("tofu",  "Illinois", 10));
        foods.add(new Food("chocolate",  "Trinidad", 20));
        foods.add(new Food("cheese",  "Wisconsin", 5));
        foods.add(new Food("bread",  "France", 6));



        //initialize adapter
        adapter = new ArrayAdapter<Food>(
                getApplicationContext(),
                R.layout.list_row,
                foods);

        listFood.setAdapter(adapter);

        //click listener for list
        listFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food f = foods.get(position);
                textChoice.setText(f.getName() + " from " + f.getLocation());
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food f = new Food();
                f.setName(editName.getText().toString());
                f.setLocation(editLocation.getText().toString());
                f.setQuantityLeft(Integer.valueOf(editQuantity.getText().toString()));

                foods.add(f);

                adapter.notifyDataSetChanged();
            }
        });


    }

}












