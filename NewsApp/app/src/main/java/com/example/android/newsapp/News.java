package com.example.android.newsapp;

/**
 * Created by abc on 04-07-2017.
 */

public class News {
    private String mTitle;
    private String mSection;
    private String mUrl;

    public News(String title, String section ,  String url)
    {
        mTitle=title;
        mSection=section;
        mUrl=url;

    }
    public String getTitle(){
        return mTitle;
    }
    public  String getSection(){
        return mSection;
    }
    public String getUrl(){return mUrl; }

}
