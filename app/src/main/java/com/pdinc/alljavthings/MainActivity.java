package com.pdinc.alljavthings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.number.SimpleNotation;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "Btn 2 is pressed");
                //NORMAL PERMISSION
                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                boolean isConnected = netInfo != null && netInfo.isConnected();
                TextView tv1 = findViewById(R.id.tv1);
                tv1.setText(isConnected ? "Connected" : "DisConnected");
            }
        });
        Button btnYes;
        btnYes = findViewById(R.id.btn3);
//        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
////Only to devices having greater OS than Oreo
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//            nm.createNotificationChannel(new NotificationChannel("first","default", NotificationManager.IMPORTANCE_DEFAULT));
//        }
        btnYes.setOnClickListener(v -> {
//            //************************************Building Notification
//            Notification sn= new NotificationCompat.Builder(this,"first")
//                    .setContentTitle("Hello")
//                    .setContentText("Hello World!")
//                    .setSmallIcon(R.drawable.ic_launcher_foreground)
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                    .build();
//                    nm.notify(1,sn);
        });
    }

    public void onButtonClicked(View view) {
        Intent i;
        i=new Intent(this,MainActivity2.class);
        startActivity(i);
    }

}