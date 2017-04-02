package com.a2j.ssetultimerough;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Belal on 9/22/2015.
 */

public class Customlist extends ArrayAdapter<String> {
    private String[] BOOKNAME;
    private String[] AUTHOR;
    private String[] STOCK;
    private Activity context;


    public Customlist(Activity context, String[] BOOKNAME, String[] AUTHOR, String[] STOCK) {
        super(context, R.layout.activity_booksearch, BOOKNAME);
        this.context = context;
        this.BOOKNAME = BOOKNAME;
        this.AUTHOR = AUTHOR;
        this.STOCK = STOCK;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_booksearch, null, true);
        TextView textViewOrgan = (TextView) listViewItem.findViewById(R.id.BOOKNAME);
        TextView textViewBlood = (TextView) listViewItem.findViewById(R.id.AUTHOR);
        TextView textViewContact = (TextView) listViewItem.findViewById(R.id.STOCK);

        textViewOrgan.setText(BOOKNAME[position]);
        textViewBlood.setText(AUTHOR[position]);
        textViewContact.setText(STOCK[position]);
        return listViewItem;
    }
}

