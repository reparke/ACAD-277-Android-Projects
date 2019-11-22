package itp341.firebase.advanced;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import itp341.firebase.advanced.FirebaseReferences.FirebaseRefs;
import itp341.firebase.R;
import itp341.firebase.advanced.model.Note;

public class NoteWriteFragment extends Fragment {

    private static final String ARG_URL = "itp341.firebase.ARG_URL";

    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    private Button buttonSave;


    private DatabaseReference dbRefCount;
    private DatabaseReference dbRefNotes;
    private DatabaseReference dbRefNoteToEdit;


    public NoteWriteFragment() {
        // Required empty public constructor
    }

    public static NoteWriteFragment newInstance(String reference)
    {
        Bundle b = new Bundle();
        b.putString(ARG_URL, reference);

        NoteWriteFragment newFragment = new NoteWriteFragment();
        newFragment.setArguments(b);
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        dbRefNotes = database.getReference(FirebaseRefs.NOTES);
        dbRefCount = database.getReference(FirebaseRefs.NOTE_COUNT);

        /*
        dbRefCount is the main count area
        dbRefNotes is the main note area
        dbRefNoteToEdit is the specific note to be edited

         */

        Bundle args = getArguments();
        if (args != null)
        {
            String urlNoteToEdit = args.getString(ARG_URL);
            if (urlNoteToEdit != null) {
                dbRefNoteToEdit = database.getReferenceFromUrl(urlNoteToEdit);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_write, container, false);

        editTitle = (EditText) v.findViewById(R.id.noteWriteTitle);
        editAuthor = (EditText) v.findViewById(R.id.noteWriteAuthor);
        editContent = (EditText) v.findViewById(R.id.noteWriteContent);
        buttonSave = (Button) v.findViewById(R.id.noteWriteSave);

        if (dbRefNoteToEdit != null)
        {
            dbRefNoteToEdit.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Note n = dataSnapshot.getValue(Note.class);
                    editTitle.setText(n.getTitle());
                    editAuthor.setText(n.getAuthor());
                    editContent.setText(n.getContent());
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                    Toast.makeText(getActivity(), "Could not load note.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // buttonSave to firebase by pushing a new value
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note n = new Note();
                n.setTitle(editTitle.getText().toString());
                n.setAuthor(editAuthor.getText().toString());
                n.setContent(editContent.getText().toString());

                if (dbRefNoteToEdit == null) {
                    DatabaseReference newNoteReference = dbRefNotes.push();
                    newNoteReference.setValue(n);

                    //todo set up count saving
                    dbRefCount.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            long noteCount;
                            if (dataSnapshot.getValue() == null) {      //only execute first time when nothing EVER when
                                                                        //DB is empty
                                noteCount = 0;
                            }
                            else {

                                noteCount = (Long) dataSnapshot.getValue();
                            }
                            dbRefCount.setValue(noteCount + 1);
                            getActivity().finish();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(getContext(), "Could not create note.", Toast
                                    .LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    dbRefNoteToEdit.setValue(n);
                    getActivity().finish();
                }
            }
        });

        return v;
    }

}
