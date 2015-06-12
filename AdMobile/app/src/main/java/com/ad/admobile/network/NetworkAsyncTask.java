package com.ad.admobile.network;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.ad.admobile.listener.NetworkListener;

import java.io.IOException;

/**
 * Created by biswac on 6/11/2015.
 */
public class NetworkAsyncTask  extends AsyncTask <String, Void, Bitmap> {
    private Downloader downloader;
    private String urlString;
    private NetworkListener networkListener;

    public NetworkAsyncTask( NetworkListener nListener){
        downloader = new Downloader();
        networkListener = nListener;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        Bitmap bm = null;
        try {
            bm = downloader.getBitMap(url);
        } catch (IOException e) {
            Log.e("doInBackground", "Error while getting bitmap");
        }
        return bm;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap == null) {
            networkListener.onFailure();
        } else {
            networkListener.onSuccess(bitmap);
        }
//        super.onPostExecute(bitmap);
    }
}
