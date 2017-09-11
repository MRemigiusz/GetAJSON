package com.example.remek.getajson;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.remek.getajson.NetworkTool.isConnected;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver networkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        networkStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String message = "";

                if (isConnected(context)) {
                    message = "Połączono z siecią";
                } else {
                    message = "Rozłączono z siecią. Sprawdź połączenie z siecią.";
                }

                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkStateReceiver, intentFilter);
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkStateReceiver);
    }
}

//check