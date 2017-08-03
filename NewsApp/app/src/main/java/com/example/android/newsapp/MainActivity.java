package com.example.android.newsapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {
    private static final String NEWS_URL = "http://content.guardianapis.com/search?q=world&api-key=test";
    LoaderManager loaderManager;
    private NewsAdapter mAdapter;
    private ProgressBar progressBar;
    private TextView mEmptyTextView;
    private LinearLayout mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.loading_indicator);

        ListView listView = (ListView) findViewById(R.id.list_view);
        List<News> news = new ArrayList<>();
        mAdapter = new NewsAdapter(this, news);
        listView.setAdapter(mAdapter);
        setEmptyListView(listView);
        setItemListener(listView);

        if (!getNetworkInfo())
            setNoInternet();
        else
            startLoader();

    }

    private void startLoader() {
        loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, this);
    }

    private void setNoInternet() {
        mEmptyTextView.setText(getString(R.string.no_connection));

    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this, NEWS_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        progressBar.setVisibility(View.GONE);

        if (data == null) {
            setNoData();
            return;
        }

        mAdapter.addAll(data);
    }

    private void setNoData() {
        mEmptyTextView.setText(getString(R.string.no_data_found));
    }

    private void setEmptyListView(ListView listView) {

        mEmptyView = (LinearLayout) findViewById(R.id.empty_view);
        mEmptyTextView = (TextView) mEmptyView.getChildAt(0);
        mEmptyView.setVisibility(View.GONE);

        listView.setEmptyView(mEmptyView);

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        mAdapter.clear();

    }

    private boolean getNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo Info = connectivityManager.getActiveNetworkInfo();
        return Info != null && Info.isConnectedOrConnecting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.restart:
                restartLoader();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void restartLoader() {
        mAdapter.clear();
        mEmptyView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        loaderManager = getLoaderManager();
        loaderManager.restartLoader(0, null, this);
    }

    private void setItemListener(ListView listView) {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Uri webpage = Uri.parse(mAdapter.getItem(position).getUrl());

                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

                if(intent.resolveActivity(getPackageManager())!=null)
                    startActivity(intent);
            }
        });

    }
}