package itp341.firebase.advanced;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import itp341.firebase.R;
import itp341.firebase.advanced.model.Note;

import static itp341.firebase.advanced.NoteWriteActivity.EXTRA_URL;
import static itp341.firebase.advanced.NoteWriteActivity.NOTES;
import static itp341.firebase.advanced.NoteWriteActivity.NOTE_COUNT;

public class NoteListActivity extends AppCompatActivity {
    private final static String TAG = NoteListActivity.class.getSimpleName();
    private ListView list;
    private TextView textCount;
    private Button buttonNewNote;

    //todo database references
    DatabaseReference dbRefNotes;
    DatabaseReference dbRefNoteCount;

    NoteAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        setContentView(R.layout.activity_note_list);
        list = findViewById(R.id.listNotes);
        textCount = findViewById(R.id.textNoteCount);
        buttonNewNote = findViewById(R.id.buttonNewNote);

        //todo get database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //todo get database reference paths
        dbRefNotes = database.getReference(NOTES);
        dbRefNoteCount = database.getReference(NOTE_COUNT);

        //todo instantiate adapter
        adapter = new NoteAdapter(this,
                Note.class,
                R.layout.list_note_item,
                dbRefNotes);

        list.setAdapter(adapter);
        //todo set adapter for listview

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //get the reference
                final DatabaseReference refClicked = adapter.getRef(position);
                final Note savedNote = adapter.getItem(position);

                //delete the data
                refClicked.removeValue();
                Snackbar.make(findViewById(R.id.layout_list_activity), "Note deleted", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                refClicked.setValue(savedNote);
                            }
                        })
                        .show();

                /*
                undo
                    action on the snack restores what was deleted
                    before deleting, we need to store two things:
                        1) store the unique ID (reference)
                        2) WE need to store the data at the deleted reference (AKA a note)
                    when the user presses undo,
                        set the value of the saved reference to saved note

                 */

                return true;    //did we process the action? if yes, true; if not, false
            }
        });

        //todo list item click listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), NoteWriteActivity.class);

                DatabaseReference dbSelectedNote = adapter.getRef(position);
                i.putExtra(EXTRA_URL, dbSelectedNote.toString());

                startActivityForResult(i, 0);
            }
        });


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

    //this is always the same
    //the only part that changes are 1) the class inside <>
    // and 2) the populateView method
    //todo create custom FirebaseListAdapter
    private class NoteAdapter extends FirebaseListAdapter<Note> {

        public NoteAdapter(Activity activity, Class<Note> modelClass, int modelLayout, DatabaseReference ref) {
            super(activity, modelClass, modelLayout, ref);
        }

        @Override
        protected void populateView(View v, Note model, int position) {
            //read ONE note from firebase (this this the model)
            //load the individual items from the model into the textviews in ONE ROW of the list
            //View v represents the ONE ROW

            //step 1: get references to the textview in the row
            TextView textTitle = v.findViewById(R.id.listNoteTitle);
            TextView textContent = v.findViewById(R.id.listNoteContent);
            TextView textAuthor = v.findViewById(R.id.listNoteAuthor);

            //step 2: load the data from model into row
            textTitle.setText(model.getTitle());
            textAuthor.setText(model.getAuthor());
            textContent.setText(model.getContent());



        }
    }
}











