package com.example.remek.getajson;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Remek on 11.09.2017.
 */

public class NetworkTool {
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return (networkInfo != null
                && networkInfo.isConnected()
                && (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
        );
    }
}
