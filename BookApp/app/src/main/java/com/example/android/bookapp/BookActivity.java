package com.example.android.bookapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    private String BOOK_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private TextView emptyTextView;
    private ProgressBar progressBar;
    private BookAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String text = getIntent().getStringExtra("Query");
        BOOK_URL += text;

        ListView listView = (ListView) findViewById(R.id.ListView);
        mAdapter = new BookAdapter(this,new ArrayList<Book>());

        emptyTextView = (TextView) findViewById(R.id.emptyTextView);
        listView.setEmptyView(emptyTextView);
        listView.setAdapter(mAdapter);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (networkinfo != null && networkinfo.isConnected()) {
            BookAsyncTask task = new BookAsyncTask();
            task.execute(BOOK_URL);
        } else {
            progressBar.setVisibility(View.GONE);
            emptyTextView.setText("Connect to internet");
            emptyTextView.setVisibility(View.VISIBLE);
        }

    }

    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>> {
        @Override
        protected void onPostExecute(List<Book> books) {
            mAdapter.clear();
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            if (books != null && !books.isEmpty()) {
                progressBar.setVisibility(View.INVISIBLE);
                mAdapter.addAll(books);
            }
            else{
                progressBar.setVisibility(View.INVISIBLE);
                emptyTextView.setText("No book found.");
                emptyTextView.setVisibility(View.VISIBLE);
            }
        }
        @Override
        protected List<Book> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null)
                return null;
            List<Book> books = QueryUtils.fetchBookData(urls[0]);
            if(books == null)
                return null;
            else
                return books;
        }
    }
}