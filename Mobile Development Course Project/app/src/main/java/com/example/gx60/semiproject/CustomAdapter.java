package com.example.gx60.semiproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GX60 on 08/03/2017.
 */

public class CustomAdapter extends ArrayAdapter<String>
{

    public CustomAdapter(Context context, String[] names) {
        super(context, R.layout.custom_row, names);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String item = getItem(position);
        TextView myText = (TextView) customView.findViewById(R.id.List_Text);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageView);

        myText.setText(item);

        return customView;
    }
}
