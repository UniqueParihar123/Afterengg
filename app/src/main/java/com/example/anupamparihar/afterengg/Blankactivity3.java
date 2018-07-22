package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.anupamparihar.afterengg.R.id.bt;
import static com.example.anupamparihar.afterengg.R.id.bt2;
import static com.example.anupamparihar.afterengg.R.id.bt3;
import static com.example.anupamparihar.afterengg.R.id.bt4;
import static com.example.anupamparihar.afterengg.R.id.bt5;
import static com.example.anupamparihar.afterengg.R.id.cv1;
import static com.example.anupamparihar.afterengg.R.id.cv2;

public class Blankactivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blankactivity3);
        Intent obj=getIntent();
        Bundle bundle=obj.getExtras();
        int a=(Integer) bundle.get("pass");

        if(a==bt5)
        {
            Fragment eeefragment=new Fragment();
            FragmentManager fm2=getSupportFragmentManager();
            FragmentTransaction ft2=fm2.beginTransaction();
            ft2.replace(R.id.topics,new algorithm());

            ft2.commit();
        }
    if(a==bt)
    {

        FragmentManager fm3=getSupportFragmentManager();
        FragmentTransaction ft3=fm3.beginTransaction();
        ft3.replace(R.id.topics,new sorting());

        ft3.commit();
    }




    }
}
