package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class csefragment extends Fragment {

    CardView cardview1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_csefragment, container, false);
        cardview1=(CardView)view.findViewById(R.id.cv1);
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), csegate.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
