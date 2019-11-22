package itp341.toolbars;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;
import itp341.toolbars.R;

import itp341.toolbars.Model.Mail;

public class MailAdapter extends ArrayAdapter<Mail>{
    //TODO Constants

    private int mLayoutResource;
    private final int MAX_LENGTH_TITLE = 20;
    private final int MAX_LENGTH_MESSAGE = 44;

    public MailAdapter(Context context, int resource, List<Mail> objects) {
        super(context, resource, objects);
        mLayoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(mLayoutResource, parent, false);
        }

        Mail mail = getItem(position);

        TextView textViewSender = (TextView) convertView.findViewById(R.id.list_mail_sender);
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.list_mail_title);
        TextView textViewMessage = (TextView) convertView.findViewById(R.id.list_mail_message);

        String titleString = mail.getTitle();
        String messageString = mail.getMessage();

        //TODO implement length check
        int titleLength = titleString.length();
        if (titleLength > MAX_LENGTH_TITLE) {
            titleString = titleString.substring(0, MAX_LENGTH_TITLE);
        }

        if (titleLength > titleString.length())
        {
            titleString += "...";
        }

        int messageLength = messageString.length();
        if (messageLength > MAX_LENGTH_MESSAGE) {
            messageString = messageString.substring(0, MAX_LENGTH_MESSAGE);
        }

        if (messageLength > messageString.length())
        {
            messageString += "...";
        }

        textViewSender.setText(mail.getSender());
        textViewTitle.setText(titleString);
        textViewMessage.setText(messageString);


        //TODO modify Read / unread
        if (!mail.isRead())
        {
            textViewSender.setTypeface(Typeface.DEFAULT_BOLD);
            textViewTitle.setTypeface(Typeface.DEFAULT_BOLD);
            textViewSender.setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Medium);
            textViewTitle.setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Medium);
            textViewSender.setTextColor(Color.parseColor("#0000FF"));
            textViewTitle.setTextColor(Color.parseColor("#0000FF"));
            textViewMessage.setTextColor(Color.parseColor("#0000FF"));
        }
        else
        {
            textViewSender.setTypeface(Typeface.DEFAULT);
            textViewTitle.setTypeface(Typeface.DEFAULT);
            textViewMessage.setTypeface(Typeface.DEFAULT);
            textViewSender.setTextAppearance(android.R.style.TextAppearance_DeviceDefault);
            textViewTitle.setTextAppearance(android.R.style.TextAppearance_DeviceDefault);
            textViewMessage.setTextAppearance(android.R.style.TextAppearance_DeviceDefault);
        }

        return convertView;
    }
}
