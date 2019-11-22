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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import itp341.firebase.R;
import itp341.firebase.advanced.model.Note;

public class NoteWriteActivity extends AppCompatActivity {
    public static final String NOTES = "Notes";
    public static final String NOTE_COUNT = "Note Count";

    public static final String EXTRA_URL = "itp341.firebase.EXTRA_URL";


    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    private Button buttonSave;


    //todo database references
    DatabaseReference dbRefNotes;
    DatabaseReference dbRefNoteToEdit;  //for later
    DatabaseReference dbRefNoteCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);


        //todo get database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //todo get database reference paths
        dbRefNotes = database.getReference(NOTES);
        dbRefNoteCount = database.getReference(NOTE_COUNT);

        //todo get reference to note to be edited (if it exists)
        Intent i = getIntent();
        String referenceURL = i.getStringExtra(EXTRA_URL);  //retrieve
        //if referenceURL is null, that means this is a new note
        if (referenceURL != null) { //existing note
            dbRefNoteToEdit = database.getReferenceFromUrl(referenceURL);
        }


        editTitle = findViewById(R.id.noteWriteTitle);
        editAuthor = findViewById(R.id.noteWriteAuthor);
        editContent = findViewById(R.id.noteWriteContent);
        buttonSave = findViewById(R.id.noteWriteSave);

        //todo read selected note
        if (dbRefNoteToEdit != null) { //existing note
            dbRefNoteToEdit.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //this is where you add code for when you successfully read from the database
                    Note n = dataSnapshot.getValue(Note.class);

                    editTitle.setText(n.getTitle());
                    editContent.setText(n.getContent());
                    editAuthor.setText(n.getAuthor());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }


        // todo implement saving
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note n = new Note();    //this is the object we are going to store in Firebase

                n.setContent(editContent.getText().toString());
                n.setAuthor(editAuthor.getText().toString());
                n.setTitle(editTitle.getText().toString());

                if (dbRefNoteToEdit == null) {  //new note
                    DatabaseReference dbNewNote = dbRefNotes.push();    //getting a child NODE from the main NOTES branch
                    dbNewNote.setValue(n);
                }
                else {  //existing note
                    dbRefNoteToEdit.setValue(n);
                }

                finish();   //closes the activity
                //todo enable saving new note
                //todo enable updating existing note
                //todo set up count saving



            }
        });

    }
}

