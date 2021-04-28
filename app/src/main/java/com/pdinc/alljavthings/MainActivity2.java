package com.pdinc.alljavthings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pdinc.alljavthings.DataStorage.RWActivity;
import com.pdinc.alljavthings.ListViews.MainListV;
import com.pdinc.alljavthings.ListViews.RecycleAct;
import com.pdinc.alljavthings.fragments.DownFragment;
import com.pdinc.alljavthings.fragments.UpFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = findViewById(R.id.dialBtn);
        Button btn1 = findViewById(R.id.SwitchBtn1);
        EditText et1 = findViewById(R.id.dialTv);
        Button addBtn =findViewById(R.id.fragAddBtn);
        Button subBtn =findViewById(R.id.fragSubBtn);
        Bundle b= new Bundle();
        final int[] count={0};
        b.putIntArray("Key",count);
        Fragment Up= new UpFragment();
        Up.setArguments(b);
        Bundle b1= new Bundle();
        b1.putIntArray("Key",count);
        Fragment Down= new DownFragment();
        Down.setArguments(b1);
        FragmentManager i=getSupportFragmentManager();
        addBtn.setOnClickListener(v -> {
            i.beginTransaction().replace(R.id.frag1, Up).setReorderingAllowed(true)
                    .addToBackStack("name").commit();
        });
        subBtn.setOnClickListener(v -> {
            i.beginTransaction().replace(R.id.frag1, Down).setReorderingAllowed(true)
                    .addToBackStack("name").commit();
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission = ContextCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.CALL_PHONE);
                if (permission == PackageManager.PERMISSION_GRANTED) {
                    callNumber();
                } else {
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
                String telNo = et1.getText().toString();
                Uri uri = Uri.parse("tel:" + telNo);
                Intent i = new Intent(Intent.ACTION_CALL);
                startActivity(i);
            }
        });
    }
    public void SwitchActivity (View view){
startActivity(new Intent(this, RWActivity.class));
    }
}