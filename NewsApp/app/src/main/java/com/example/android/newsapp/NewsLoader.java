package com.example.android.newsapp;

/**
 * Created by abc on 04-07-2017.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


/**
 * Created by Sajan on 6/12/2017.
 */

public class NewsLoader  extends AsyncTaskLoader<List<News>> {

    private String mUrl;
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        } else {
            return QueryUtils.fetchNewsData(mUrl);

        }
    }
}
