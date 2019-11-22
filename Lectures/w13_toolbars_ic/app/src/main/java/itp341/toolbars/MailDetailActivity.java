package itp341.toolbars;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import itp341.toolbars.Model.Mail;

public class MailDetailActivity extends AppCompatActivity {


    public static final String INDEX = "INDEX";
    public static final String MAIL_OBJECT = "MAIL_OBJECT";
    public static final String OPERATION = "OPERATION";

    // TODO: Create reference to Toolbar.
    private Toolbar toolbar;

    private TextView mTextViewSender;
    private TextView mTextViewTitle;
    private TextView mTextViewMessage;

    private Mail mMail;
    private int mIndex;

    //this is the method to perform actions when the menu is clicked
    //aka the listeners for button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //this methods ALMOST ALWAYS looks the same
        int id = item.getItemId();  //retrieve item that was clicked
        Intent i = new Intent();        //dummy intent
        switch (id) {
            case R.id.menu_detail_delete:
                //put the action for when this is clicked
                i.putExtra(OPERATION, "delete");
                i.putExtra(INDEX, mIndex);
                setResult(Activity.RESULT_OK, i);
                finish();
                break;
            case R.id.menu_detail_unread:
                i.putExtra(OPERATION, "unread");
                i.putExtra(INDEX, mIndex);
                setResult(Activity.RESULT_OK, i);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //this is the method to load menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ALMOST ALWAYS the same
        //just change the first parameter
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

        //TODO read intent
        Intent i = getIntent();
        Mail mail = (Mail) i.getSerializableExtra(MAIL_OBJECT);
        mIndex = i.getIntExtra(INDEX, -1);




        // TODO: Find Toolbar in view and set as support ActionBar.
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Email");
            //show "UP button" and enabled to return home
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }


        // TODO: Get SupportActionBar. If not null, do the following:
        // TODO: Enable Home Button.
        // TODO: Enable Home as up.
        // TODO: Disable Title.
        // TODO: Add the following to the activity in mainifest:
        // TODO: android:parentActivityName=".View.MainActivity"


        mTextViewTitle = (TextView) findViewById(R.id.detail_title);
        mTextViewSender = (TextView) findViewById(R.id.detail_sender);
        mTextViewMessage = (TextView) findViewById(R.id.detail_message);

        mTextViewTitle.setText(mail.getTitle());
        mTextViewSender.setText(mail.getSender());
        mTextViewMessage.setText(mail.getMessage());
        mail.setRead(true);
        //just for today



    }

    // TODO: Implement onCreateOptionsMenu by inflating the menu.


    // TODO: Implement onOptionsItemSelected and switch on the item's id to take action.

}
