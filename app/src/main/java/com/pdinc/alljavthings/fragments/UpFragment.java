package com.pdinc.alljavthings.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pdinc.alljavthings.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link UpFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class UpFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_up, container, false);
        final Integer[] count = {0};
        Button add=v.findViewById(R.id.addBtn);

        int[] s=getArguments().getIntArray("Key");
        TextView tv=v.findViewById(R.id.Updatetv);
        tv.setText(s.toString());
        count[0]=s[0];
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                count[0]++;
                tv.setText(count[0].toString());
            }
        });
                return v;
    }
}