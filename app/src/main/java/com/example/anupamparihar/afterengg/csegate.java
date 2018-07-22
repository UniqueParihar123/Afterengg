package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class csegate extends AppCompatActivity implements View.OnClickListener {
CardView cardView1;
    CardView cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csegate);
cardView1=(CardView)findViewById(R.id.cv1);
       cardView2=(CardView)findViewById(R.id.cv2);
     cardView1.setOnClickListener((View.OnClickListener) csegate.this);
        cardView2.setOnClickListener((View.OnClickListener) csegate.this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
int id=v.getId();
        Intent obj=new Intent(csegate.this,Blankactivity2.class);
        obj.putExtra("pass",id);
        startActivity(obj);

    }

}
