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
    private Toolbar mToolbar;
    private TextView mTextViewSender;
    private TextView mTextViewTitle;
    private TextView mTextViewMessage;

    private Mail mMail;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

        Intent i = getIntent();
        mIndex = i.getIntExtra(INDEX, -1);

        mMail = (Mail) i.getSerializableExtra(MAIL_OBJECT);

        if (mMail == null)
        {
            finish();
        }

        // TODO: Find Toolbar in view and set as support ActionBar.
        mToolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(mToolbar);

        // TODO: Get SupportActionBar. If not null, do the following:
        // TODO: Enable Home Button.
        // TODO: Enable Home as up.
        // TODO: Disable Title.
        // TODO: Add the following to the activity in mainifest:
        // TODO: android:parentActivityName=".View.MainActivity"
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mTextViewTitle = (TextView) findViewById(R.id.detail_title);
        mTextViewSender = (TextView) findViewById(R.id.detail_sender);
        mTextViewMessage = (TextView) findViewById(R.id.detail_message);

        mTextViewTitle.setText(mMail.getTitle());
        mTextViewSender.setText(mMail.getSender());
        mTextViewMessage.setText(mMail.getMessage());
//        MailSingleton.getInstance().markReadStatus(mIndex, true);
    }

    // TODO: Create a menu folder and a menu resource in that folder.
    // TODO: Add a "delete" and a "mark as unread" item to the menu.
    // TODO: Implement onCreateOptionsMenu by inflating the menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // TODO: Implement onOptionsItemSelected and switch on the item's id to take action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent();

        switch(item.getItemId())
        {
            case R.id.menu_detail_delete:
//                MailSingleton.getInstance().deleteMail(mIndex);
                i.putExtra(OPERATION, "delete");
                i.putExtra(INDEX, mIndex);
                setResult(Activity.RESULT_OK, i);
                finish();
                break;
            case R.id.menu_detail_unread:
//                MailSingleton.getInstance().markReadStatus(mIndex, false);
                i.putExtra(OPERATION, "unread");
                i.putExtra(INDEX, mIndex);
                setResult(Activity.RESULT_OK, i);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
