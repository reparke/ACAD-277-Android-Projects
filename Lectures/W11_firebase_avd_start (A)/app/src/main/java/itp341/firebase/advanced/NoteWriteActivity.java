package itp341.firebase.advanced;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import itp341.firebase.R;

public class NoteWriteActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "itp341.firebase.EXTRA_URL";

    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    private Button buttonSave;


    //todo database references

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);


        //todo get database

        //todo get database reference paths

        //todo get reference to note to be edited (if it exists)


        editTitle = findViewById(R.id.noteWriteTitle);
        editAuthor = findViewById(R.id.noteWriteAuthor);
        editContent = findViewById(R.id.noteWriteContent);
        buttonSave = findViewById(R.id.noteWriteSave);

        //todo read selected note


        // todo implement saving
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //todo enable saving new note
                //todo enable updating existing note
                //todo set up count saving



            }
        });

    }
}

