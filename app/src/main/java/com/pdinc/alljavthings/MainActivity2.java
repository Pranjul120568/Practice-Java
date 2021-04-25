package com.pdinc.alljavthings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn=findViewById(R.id.dialBtn);
        EditText  et1=findViewById(R.id.dialTv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission= ContextCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.CALL_PHONE);
                if(permission== PackageManager.PERMISSION_GRANTED){
                    callNumber();
                }else{
                    ActivityCompat.requestPermissions(
                            MainActivity2.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE
                            },
                     121
                    );
                }
            }

            private void callNumber() {
                String telNo=et1.getText().toString();
                Uri uri =Uri.parse("tel:" + telNo);
                Intent i=new Intent(Intent.ACTION_CALL);
                startActivity(i);
            }
        });
        }
    }