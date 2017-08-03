package com.example.android.newsapp;

/**
 * Created by abc on 04-07-2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter( Context context, List<News> list) {
        super(context,0,list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        News data = getItem(position);

        TextView textView = (TextView) convertView.findViewById(R.id.title);
        textView.setText(data.getTitle());

        textView = (TextView) convertView.findViewById(R.id.section);
        textView.setText(data.getSection());

        return convertView;
    }
}
