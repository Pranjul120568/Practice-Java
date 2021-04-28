package com.pdinc.alljavthings.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pdinc.alljavthings.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link DownFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class DownFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_down, container, false);
        Button minus=v.findViewById(R.id.subBtn);
        final Integer[] count = {0};
        int[] s=getArguments().getIntArray("Key");
        TextView tv1=v.findViewById(R.id.minusTv);
        tv1.setText(s.toString());
        count[0]=s[0];

        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                count[0]--;
                tv1.setText(count[0].toString());

            }
        });
        return v;
    }
}