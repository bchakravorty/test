package com.ad.admobile.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by biswac on 6/11/2015.
 */
public class Downloader {

    public HttpURLConnection getUrlConnection(String url) throws IOException{
        URL localURL = new URL(url);
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
        return localHttpURLConnection;
    }

    public Bitmap getBitMap(String url) throws IOException {
        HttpURLConnection connection = getUrlConnection(url);
        connection.setRequestMethod("GET");
        connection.connect();
        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream(), 8192);
        Bitmap bm = BitmapFactory.decodeStream(bis);
        return bm;
    }
}
