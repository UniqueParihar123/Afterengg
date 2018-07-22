package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.anupamparihar.afterengg.R.id.cv1;
import static com.example.anupamparihar.afterengg.R.id.cv2;

public class Blankactivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blankactivity2);

        Intent obj=getIntent();
        Bundle bundle=obj.getExtras();
        int a=(Integer) bundle.get("pass");
        if(a==cv1)
        {
            Fragment csefragment=new Fragment();
            FragmentManager fm1=getSupportFragmentManager();
            FragmentTransaction ft1=fm1.beginTransaction();
            ft1.replace(R.id.csegate,new csegatesyllfragment());
            ft1.remove(csefragment);
            ft1.commit();


        }
        if(a==cv2)
        {
            Fragment eeefragment=new Fragment();
            FragmentManager fm2=getSupportFragmentManager();
            FragmentTransaction ft2=fm2.beginTransaction();
            ft2.replace(R.id.csegate,new csegatetopics());
            ft2.remove(eeefragment);
            ft2.commit();
        }
        if(a==2)
        {  Fragment ecefragment=new Fragment();
            FragmentManager fm3=getSupportFragmentManager();
            FragmentTransaction ft3=fm3.beginTransaction();
            ft3.replace(R.id.content2,new ecefragment());
            ft3.remove(ecefragment);
            ft3.commit();
        }
        if(a==3)
        {       Fragment mefragment=new Fragment();
            FragmentManager fm4=getSupportFragmentManager();
            FragmentTransaction ft4=fm4.beginTransaction();
            ft4.replace(R.id.content2,new mefragment());
            ft4.remove(mefragment);
            ft4.commit();
        }


    }
}
