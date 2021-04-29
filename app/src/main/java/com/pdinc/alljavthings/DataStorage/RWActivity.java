package com.pdinc.alljavthings.DataStorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pdinc.alljavthings.MainActivity;
import com.pdinc.alljavthings.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RWActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_w);
        EditText writeEt=findViewById(R.id.enterEt);
        Button btnWrite=findViewById(R.id.writeBtn);
        TextView tvread=findViewById(R.id.showTv);
        Button readBtn=findViewById(R.id.readBtn);
        btnWrite.setOnClickListener(v->{
            String text=writeEt.getText().toString();
            File myDataDir= ContextCompat.getDataDir(RWActivity.this);
            File myFile=new File(myDataDir,"file.txt");
            try {
                FileOutputStream fos=new FileOutputStream(myFile,true);
                fos.write(text.getBytes());
            } catch (FileNotFoundException e) {
                Toast.makeText(this,"File Not Found",Toast.LENGTH_SHORT).show();
            } catch (Exception IO){
                Toast.makeText(this,"Error while writing file",Toast.LENGTH_SHORT).show();
            }
        });

        readBtn.setOnClickListener(v ->{
            File dataDir=ContextCompat.getDataDir(RWActivity.this);
            File myFile=new File(dataDir,"file.txt");
            try {
                FileInputStream fis=new FileInputStream(myFile);
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                StringBuilder sb=new StringBuilder();
                String buffer=br.readLine();
                while(buffer!=null){
                    sb.append(buffer);
                    buffer=br.readLine();
                }
                String text=sb.toString();
                tvread.setText(text);

            } catch (FileNotFoundException e) {
                Toast.makeText(this,"File Not Found",Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this,"Error while reading file",Toast.LENGTH_SHORT).show();
            }
        });
        Button redBtn=findViewById(R.id.redbtn);
        Button blueBtn=findViewById(R.id.bluebtn);
        Button greenBtn=findViewById(R.id.greenbtn);
        int red=getResources().getColor(R.color.red);
        int blue=getResources().getColor(R.color.blue);
        int green=getResources().getColor(R.color.green);
        LinearLayout ll=findViewById(R.id.rwlayout);

        SharedPreferences sPref=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor spe= sPref.edit();
        //here we use shared preferences in order to remember the last color background which was present
        //here we use mode private so that other apps cant read them
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "RW.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        Button btn1=findViewById(R.id.SaveDatabtn);
        btn1.setOnClickListener(v->{
            saveData(db);
        });
        Button btn2=findViewById(R.id.FetchDatabtn);
        btn2.setOnClickListener(v->{
            FetchData(db);
        });




        spe.putInt("COLOR",Color.red(red)).apply();

        redBtn.setOnClickListener(v -> {
            ll.setBackgroundColor(red);
          //  saveColor(red);
        });
        blueBtn.setOnClickListener(v -> {
            ll.setBackgroundColor(blue);
           // saveColor(blue);

        });
        greenBtn.setOnClickListener(v -> {
            ll.setBackgroundColor(green);
           // saveColor(green);

        });
    }

    private void saveData(AppDatabase db) {

                db.userDao().insert(new User("Pranjul","999111","Delhi",21));

    }
//    private void saveColor(Integer color) {
//        spe.putInt("COLOR",color).apply();
//
//    }

    public void FetchData(AppDatabase db) {
        //spe.putInt("COLOR",Color.red(red)).apply();
        TextView nameTv=findViewById(R.id.nametv);
        TextView addressTv=findViewById(R.id.addresstv);
        TextView ageTv=findViewById(R.id.agetv);
        TextView numberTv=findViewById(R.id.numberTv);
        List<User> l=db.userDao().getAll();
        if(!l.isEmpty()){
            nameTv.setText(l.get(0).name);
            addressTv.setText(l.get(0).address);
            ageTv.setText(l.get(0).age.toString());
            numberTv.setText(l.get(0).number);
        }
    }
}