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
    private final static int MAX_LENGTH_TITLE = 20; //20 characters for the subject
    private final static int MAX_LENGTH_MESSAGE = 44;

    private int mLayoutResource;


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
        if (titleString.length() >= MAX_LENGTH_TITLE) {
            titleString = titleString.substring(0, MAX_LENGTH_TITLE - 1) + "...";
        }
        if (messageString.length() >= MAX_LENGTH_MESSAGE) {
            messageString = messageString.substring(0, MAX_LENGTH_MESSAGE-1) + "...";
        }

        //TODO implement length check

        textViewSender.setText(mail.getSender());
        textViewTitle.setText(titleString);
        textViewMessage.setText(messageString);


        //TODO modify Read / unread
        if (mail.isRead() == false) { //message is unread
            textViewSender.setTypeface(Typeface.DEFAULT_BOLD);
            textViewSender.setTextColor(Color.parseColor("#000000"));
            textViewMessage.setTypeface(Typeface.DEFAULT_BOLD);
            textViewMessage.setTextColor(Color.parseColor("#000000"));
            textViewTitle.setTypeface(Typeface.DEFAULT_BOLD);
            textViewTitle.setTextColor(Color.parseColor("#000000"));
        }
        else {
            textViewSender.setTypeface(Typeface.DEFAULT);
            textViewSender.setTextColor(Color.parseColor("#aaaaaa"));
            textViewMessage.setTypeface(Typeface.DEFAULT);
            textViewMessage.setTextColor(Color.parseColor("#aaaaaa"));
            textViewTitle.setTypeface(Typeface.DEFAULT);
            textViewTitle.setTextColor(Color.parseColor("#aaaaaa"));
        }



        return convertView;
    }
}
