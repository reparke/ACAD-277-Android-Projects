package itp341.firebase.advanced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import itp341.firebase.R;

public class NoteListActivity extends AppCompatActivity {
    private final static String TAG = NoteListActivity.class.getSimpleName();
    private ListView list;
    private TextView textCount;
    private Button buttonNewNote;

    //todo database references



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        setContentView(R.layout.activity_note_list);
        list = findViewById(R.id.listNotes);
        textCount = findViewById(R.id.textNoteCount);
        buttonNewNote = findViewById(R.id.buttonNewNote);

        //todo get database

        //todo get database reference paths


        //todo instantiate adapter

        //todo set adapter for listview


        //todo list item click listener


        buttonNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NoteWriteActivity.class);
                startActivity(i);
            }
        });
        //todo read count value



    }




//todo onDetach


//todo create custom FirebaseListAdapter
}



