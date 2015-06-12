package com.ad.admobile.listener;

import android.graphics.Bitmap;

/**
 * Created by biswac on 6/11/2015.
 */
public interface NetworkListener {

    public void onFailure();
    public void onSuccess(Bitmap image);
}
