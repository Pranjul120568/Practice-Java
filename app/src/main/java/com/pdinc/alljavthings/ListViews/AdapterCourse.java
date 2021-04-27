package com.pdinc.alljavthings.ListViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.pdinc.alljavthings.R;

import java.util.ArrayList;

public class AdapterCourse extends RecyclerView.Adapter<AdapterCourse.MyViewHolder> {
    private Context context;
    private ArrayList<ClassCourse> courseList;

    public AdapterCourse(Context context, ArrayList<ClassCourse> courseList) {
        this.context = context; this.courseList = courseList;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate has three parameters, layout to inflate, container in which it needs to be inflated
// attach to root layout, should be false
        View v = LayoutInflater.from((context)).inflate(R.layout.for_recycle, parent, false);
        return new MyViewHolder(v); // returns a viewHolder object
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Get the desired data
        String courseName = courseList.get(position).getName();
        String instructorName = courseList.get(position).getInstructor();
        int batchStrength = courseList.get(position).getBatchStrength();
        View view = holder.itemView;
TextView tvCourseName=view.findViewById(R.id.tvCourseName);
TextView tvInstName=view.findViewById(R.id.tvInstName);
TextView tvBatchStrength=view.findViewById(R.id.tvBatchStrength);
//Binding the data with help of viewholder
        tvCourseName.setText(courseName);
        tvInstName.setText(instructorName);
        tvBatchStrength.setText(batchStrength);
    }
    @Override
    public int getItemCount() {
        return courseList.size();
    }
    public class MyViewHolder extends ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
