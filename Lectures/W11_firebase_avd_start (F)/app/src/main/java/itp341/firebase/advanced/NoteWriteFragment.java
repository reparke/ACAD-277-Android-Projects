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

import itp341.firebase.R;
import itp341.firebase.advanced.model.Note;

public class NoteWriteFragment extends Fragment {

    private static final String ARG_URL = "itp341.firebase.ARG_URL";

    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    private Button buttonSave;


    //todo database references


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

        //todo get database

        //todo get database reference paths

        Bundle args = getArguments();
        //todo get reference to note to be edited (if it exists)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_write, container, false);

        editTitle = (EditText) v.findViewById(R.id.noteWriteTitle);
        editAuthor = (EditText) v.findViewById(R.id.noteWriteAuthor);
        editContent = (EditText) v.findViewById(R.id.noteWriteContent);
        buttonSave = (Button) v.findViewById(R.id.noteWriteSave);

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

        return v;
    }

}
