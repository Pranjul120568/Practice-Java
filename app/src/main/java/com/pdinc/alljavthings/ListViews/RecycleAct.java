package com.pdinc.alljavthings.ListViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pdinc.alljavthings.R;

import java.util.ArrayList;

public class RecycleAct extends AppCompatActivity {
ArrayList<ClassCourse> cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        cc.addAll(ClassCourse.createBatches());
        RecyclerView rvCourseList = findViewById(R.id.courseList);
        AdapterCourse adapter=new AdapterCourse(this,cc);
        rvCourseList.setAdapter(adapter);
        rvCourseList.setLayoutManager(new LinearLayoutManager(this));
    }
}