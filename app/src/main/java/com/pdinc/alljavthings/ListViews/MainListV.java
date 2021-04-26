package com.pdinc.alljavthings.ListViews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pdinc.alljavthings.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainListV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        String s[]={"Apple","Mango","Guava","Banana","Grapes","Melon","Watermelon","Pomegranate"};
        ArrayAdapter<String> arr;
        ListView l1=findViewById(R.id.list1);
        arr=new ArrayAdapter<String>(
                this,
                R.layout.lvfruits,
                R.id.fruitNameTv,
                s);
l1.setAdapter(arr);
l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView v=findViewById(R.id.fruitNameTv);
        Toast.makeText(getApplicationContext(),"I Ate "+position+" " + v.getText() ,Toast.LENGTH_LONG).show();
    }
});
    }
}