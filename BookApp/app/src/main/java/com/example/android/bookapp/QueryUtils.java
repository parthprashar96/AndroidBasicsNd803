package com.example.android.bookapp;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    private static String LOG_TAG = QueryUtils.class.getName();

    private QueryUtils() {
    }

    public static List<Book> fetchBookData(String requestUrl) {
        URL url = QueryUtils.createUrl(requestUrl);
        if (url == null) {
            return null;
        }

        String jsonResponse = null;
        try {
            jsonResponse = QueryUtils.makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Book> books = extractFeatureFromJson(jsonResponse);
        return books;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(15000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the Books JSON results.", e);
        } finally {

            if (inputStream != null) {
                inputStream.close();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<Book> extractFeatureFromJson(String BookJSON) {

        if (BookJSON.isEmpty()) {
            return null;
        }

    List<Book> books = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(BookJSON);

            String author = "";
            String publisher = "";

                JSONArray items = root.getJSONArray("items");

                if(items == null){
                    return null;
                }

                else {
                    for (int i = 0; i < items.length(); i++) {

                        JSONObject itemsAtIndex = items.getJSONObject(i);
                        JSONObject volumeInfo = itemsAtIndex.getJSONObject("volumeInfo");

                        String bookTitle = volumeInfo.getString("title");

                        if (volumeInfo.has("authors"))
                            author = volumeInfo.getJSONArray("authors").getString(0);

                        if (volumeInfo.has("publisher"))
                            publisher = volumeInfo.getString("publisher");

                        books.add(new Book(bookTitle, author, publisher));
                    }

                }


        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the book JSON results", e);

        }

        return books;
    }

}