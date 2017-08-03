package com.example.android.bookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        Book currentBook = getItem(position);

        TextView author = (TextView) listItemView.findViewById(R.id.author);
        author.setText("by "+currentBook.getAuthor());

        TextView publisher = (TextView) listItemView.findViewById(R.id.publisher);
        publisher.setText("Publisher: "+currentBook.getPublisher());

        TextView bookName = (TextView) listItemView.findViewById(R.id.book_title);
        bookName.setText(currentBook.getBookName());

        return listItemView;
    }
}