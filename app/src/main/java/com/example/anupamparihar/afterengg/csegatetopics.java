package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class csegatetopics extends Fragment implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_csegatetopics, container, false);
        button1=(Button)view.findViewById(R.id.bt);
        button2=(Button)view.findViewById(R.id.bt2);
        button3=(Button)view.findViewById(R.id.bt3);
        button4=(Button)view.findViewById(R.id.bt4);
        button5=(Button)view.findViewById(R.id.bt5);


        button1.setOnClickListener( csegatetopics.this);
        button2.setOnClickListener(csegatetopics.this);
        button3.setOnClickListener( csegatetopics.this);
        button4.setOnClickListener(csegatetopics.this);
        button5.setOnClickListener( csegatetopics.this);
    return view;
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int id=v.getId();
        Intent obj=new Intent(getActivity(),Blankactivity3.class);
        obj.putExtra("pass",id);
        startActivity(obj);
    }

}
