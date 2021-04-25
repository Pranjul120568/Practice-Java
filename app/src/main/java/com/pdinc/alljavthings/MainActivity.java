package com.pdinc.alljavthings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
                ConnectivityManager cm=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo netInfo=cm.getActiveNetworkInfo();
                boolean isConnected=netInfo!= null && netInfo.isConnected();
                TextView tv1=findViewById(R.id.tv1);
                tv1.setText(isConnected ? "Connected":"DisConnected");
            }
        });

         void onButtonClicked() {
            Intent i;
            i=new Intent(this,MainActivity2.class);
            startActivity(i);
        }
    }
    Button btn3;
    @Override
    public void onClick(View v) {
        btn3 = findViewById(R.id.btn3);
        Log.d("TAG", "Btn 3 is pressed");
    }

}