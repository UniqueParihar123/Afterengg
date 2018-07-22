package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class algorithm extends Fragment implements View.OnClickListener  {

CardView cardView1;
    CardView cardView2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_algorithm, container, false);
         cardView1=(CardView)view.findViewById(R.id.cva);
        cardView2=(CardView)view.findViewById(R.id.cvb);

        cardView1.setOnClickListener((View.OnClickListener) algorithm.this);
        cardView2.setOnClickListener((View.OnClickListener) algorithm.this);






          return view;

    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int id=v.getId();
        Intent obj=new Intent(getActivity(),blankactivity5.class);
        obj.putExtra("pass",id);
        startActivity(obj);
    }



}
