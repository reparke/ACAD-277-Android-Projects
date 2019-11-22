package itp341.firebase.advanced;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import itp341.firebase.advanced.FirebaseReferences.FirebaseRefs;
import itp341.firebase.R;
import itp341.firebase.advanced.model.Note;


public class NoteListFragment extends Fragment {

    private final static String TAG = NoteListFragment.class.getSimpleName();
    private ListView list;
    private TextView textCount;
    private long noteCount;
    private Button buttonNewNote;

    private DatabaseReference dbRefNotes;
    private DatabaseReference dbRefCount;


    FirebaseListAdapter mAdapter;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRefNotes = database.getReference(FirebaseRefs.NOTES);
        dbRefCount = database.getReference(FirebaseRefs.NOTE_COUNT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_list, container, false);

        list = (ListView) v.findViewById(R.id.noteFragmentList);

        mAdapter = new NoteFirebaseAdapter(getActivity(), Note.class, R.layout.list_note_item,
                dbRefNotes);

        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DatabaseReference clickedReference = mAdapter.getRef(position);
                Intent i = new Intent(getActivity(), NoteWriteActivity.class);
                i.putExtra(NoteWriteActivity.EXTRA_URL, clickedReference.toString());
                startActivity(i);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final DatabaseReference clickedReference = mAdapter.getRef(position);
                final Note n = (Note) mAdapter.getItem(position);
                clickedReference.removeValue();

                noteCount--;
                dbRefCount.setValue(noteCount);

                Snackbar.make(getActivity().findViewById(R.id.note_list_layout), "Deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                clickedReference.setValue(n);
                                noteCount++;
                                dbRefCount.setValue(noteCount);
                            }
                        })
                        .show();
                return true;

            }
        });
        textCount = v.findViewById(R.id.fragmentMainCount);
        buttonNewNote = v.findViewById(R.id.fragmentMainNewNote);
        buttonNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), NoteWriteActivity.class);
                startActivity(i);
            }
        });

        dbRefCount.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                noteCount = (Long) dataSnapshot.getValue();
                textCount.setText(String.valueOf(noteCount));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), "Could not load textCount.", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mAdapter.cleanup();
    }

    public static class NoteFirebaseAdapter extends FirebaseListAdapter<Note> {

        public NoteFirebaseAdapter(Activity activity, Class<Note> modelClass, int modelLayout, DatabaseReference ref) {
            super(activity, modelClass, modelLayout, ref);
        }

        @Override
        protected void populateView(View v, Note model, int position) {
            TextView title = (TextView) v.findViewById(R.id.listNoteTitle);
            TextView author = (TextView) v.findViewById(R.id.listNoteAuthor);
            TextView content = (TextView) v.findViewById(R.id.listNoteContent);

            title.setText(model.getTitle());
            author.setText(model.getAuthor());
            content.setText(model.getContent());
        }
    }
}
