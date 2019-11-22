package itp341.toolbars;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import itp341.toolbars.Model.Mail;


public class MainActivity extends AppCompatActivity {

    private static final int DETAIL_ACTIVITY_REQUEST_CODE = 100;

    private ListView mListView;

    // TODO: Create a reference to Toolbar.
    //toolbar is a widget
    private Toolbar toolbar;

    private MailAdapter mMailAdapter;
    private ArrayList<Mail> mails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mails == null) {
            mails = new ArrayList<>();
            loadMail();
        }


        mMailAdapter = new MailAdapter(this, R.layout.layout_item_mail, mails);

        mListView = (ListView) findViewById(R.id.main_list);
        mListView.setAdapter(mMailAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MailDetailActivity.class);
                Mail m = mails.get(position);
                i.putExtra(MailDetailActivity.MAIL_OBJECT, m);
                i.putExtra(MailDetailActivity.INDEX, position);
                mails.get(position).setRead(true);
                startActivityForResult(i, DETAIL_ACTIVITY_REQUEST_CODE);
            }
        });

        // TODO: Find Toolbar from View and set as ActionBar.
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);   //tells android "Hey, here's the toolbar"
        ActionBar actionBar = getSupportActionBar();

        //now, any thing you want to do with the title, etc, you can use the actionbar
        if (actionBar != null) {
            actionBar.setTitle("Academy Inbox");
        }



        // TODO: Get Support ActionBar and if not null, set the title.
    }

    //TODO enable delete and unread
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String operation = data.getStringExtra(MailDetailActivity.OPERATION);
            if (operation != null) {
                switch (operation) {
                    case "delete":
                        mails.remove(data.getIntExtra(MailDetailActivity.INDEX, -1));
                        break;
                    case "unread":
                        mails.get(data.getIntExtra(MailDetailActivity.INDEX,-1)).setRead(false);
                        break;
                }
            }
        }

        mMailAdapter.notifyDataSetChanged();
    }

    private void loadMail() {
        mails.add(new Mail("Rob", "Howdy!", "What a wonderful day for toolbars!"));
        mails.add(new Mail("Sean", "Yo!", "Let me know if you need any help!"));
        mails.add(new Mail("Neelam", "Hi!", "Nice to see you in class again!"));
        mails.add(new Mail("Karthik", "Hello!", "We are covering some cool topics!"));
        mails.add(new Mail("Mocha", "Woof woof woof woof woof woof woof woof woof woof!",
                "Woof woof woof WOOF WOOF WOOF wooF Woof Woof. Woof woof woof. Woof Woof " +
                        ",WOOF WoOF, WooF. WOof, WOOF woof woof woof. Woof woof woof " +
                        "woof, wOOF."));
        mails.add(new Mail("Chris", "Hey!", "Why am I on the bottom?"));
    }
}
