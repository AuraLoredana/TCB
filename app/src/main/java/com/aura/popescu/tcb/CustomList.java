package com.aura.popescu.tcb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by POPESCU on 5/10/2018.
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] listviewTitle;
    private final Integer[] listviewImage;
    public CustomList(Activity context,
                      String[] listviewTitle, Integer[] listviewImage) {
        super(context, R.layout.list_single, listviewTitle);
        this.context = context;
        this.listviewTitle = listviewTitle;
        this.listviewImage = listviewImage;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(listviewTitle[position]);

        imageView.setImageResource(listviewImage[position]);
        return rowView;
    }
}