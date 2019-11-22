package itp341.w7_d2_listview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import itp341.w7_d2_listview.model.Food;

public class MainActivity extends AppCompatActivity {

    //    private String[] foods;
    private ArrayList<Food> foods;
    //    private ArrayAdapter<String> adapter;
    private FoodAdapter foodAdapter;

    //get references
    private TextView textChoice;
    private Button buttonAdd;
    private EditText editName;
    private EditText editQuantity;
    private EditText editLocation;
    private ListView listFood;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inspect the parent View and get references to our widgets
        textChoice = (TextView) findViewById(R.id.textChoice);
        buttonAdd = (Button) findViewById(R.id.button_add);
        editName = (EditText) findViewById(R.id.edit_add_name);
        editQuantity= (EditText) findViewById(R.id.edit_add_quantity) ;
        editLocation= (EditText) findViewById(R.id.edit_add_location) ;
        listFood = (ListView) findViewById(R.id.list_food);

        //the model data (aka all the foods we want to see)
//        foods = getResources().getStringArray(R.array.array_food);
        foods = new ArrayList<>();

        //create the adapter--the adapter is the controller
//        adapter = new ArrayAdapter<String>(getApplicationContext(),
//                                            android.R.layout.simple_list_item_1,
//                                            foods);
        foodAdapter = new FoodAdapter(foods);

        //connect the adapter (aka controller) to the listview
        listFood.setAdapter(foodAdapter);

        listFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //this is the ROW that the user clicked
                Food f = foods.get(position);

                textChoice.setText("You clicked " + f.getName());


                //======== alternate approach ========
//                String[] foodArray = getResources().getStringArray(R.array.array_food);
//                String food = foodArray[position];


            }
        });
        listFood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                foods.remove(position);
                foodAdapter.notifyDataSetChanged();
                return true;
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create empty shell object
                Food f = new Food();
                //fill object with data from screen
                f.setName(editName.getText().toString());
                f.setLocation(editLocation.getText().toString());
                f.setQuantityLeft(
                        Integer.valueOf(editQuantity.getText().toString()));

                //add object to array list
                foods.add(f);

                Toast.makeText(getApplicationContext(), "length of list: " + foods.size(), Toast.LENGTH_SHORT).show();

                //refresh the adapter
                //to redraw the screen
                foodAdapter.notifyDataSetChanged();


            }
        });


    }

    //create the adapter
    private class FoodAdapter extends ArrayAdapter<Food> {
        //we need a way to store the model data
        //so we need an arraylist
        ArrayList<Food> foods = new ArrayList<>();

        //alwayys a constructor
        //typically the adapter needs and a list
        public FoodAdapter(ArrayList<Food> foods) {
            //remember inheritance!
            //calling the parent const will almost alwaays look like this
            super(getApplicationContext(), 0, foods);
            this.foods = foods;
        }

        //the job of getView is to create ONE row of our list
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //this will always be here
            //check if row exists--> if not, create
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_row_food_card, null);
            }

            //load the proper data
            Food f = foods.get(position);

            //we need references to each view within the list row
            TextView textName = (TextView) convertView.findViewById(R.id.list_item_name);
            TextView textLocation = (TextView) convertView.findViewById(R.id.list_item_location);
            TextView textQuantity = (TextView) convertView.findViewById(R.id.list_item_quantity);

            //loads the data from the object into the view
            textName.setText(f.getName());
            textLocation.setText(f.getLocation());
            textQuantity.setText(String.valueOf(f.getQuantityLeft()));


            return convertView;
        }
    }

}












