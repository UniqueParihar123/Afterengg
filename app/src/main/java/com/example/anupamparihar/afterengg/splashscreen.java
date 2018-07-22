package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
     //   !! READ THESE COMMENTS TO KNOW IN SUMMARISED WAY WHAT IS PRESENT IN THE JAVA AND RELATED XML FILES TO IT
//Maine splash screen ke liye ek background jpg lgai
//Maine splash screen me jo textview hai uske liye design xml file bnai
//PROGRESS BAR KA CODE
//PROGRESS BAR NOT WORKING
//Used color hex ORANGE AND DARK GREEN
//ANIMATION IS NOT THAT GOOD IMPROVE IT LATER
//IMPROVE FONT OF TEXT
//TRY TO ADD PROGRESS BAR
//COLOR USED HERE ARE USED TO PROVIDE AN iNDIAN FLAG LOOK
//Used two textviews
//Used two animation.xml file to provide animation to text and image
//usead a song for splash screen

public class splashscreen extends AppCompatActivity {
private ProgressBar pb;
    private int ps;
    private Handler ph= new Handler();

    TextView textview2;
    Animation animation;
    Animation animation2;
    Animation animation3;
    ImageView imageview;
    MediaPlayer mediaplayer;
private static int SPLASH_TIME_OUT=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        pb=(ProgressBar)findViewById(R.id.pb);

        //PROGRESS BAR CODING
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ps<100) {
                    ps++;

                    android.os.SystemClock.sleep(50000);
                    ph.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(ps);
                        }
                    });
                }
                ph.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });


        textview2=(TextView)findViewById(R.id.tv2);
        imageview=(ImageView)findViewById(R.id.im);


        animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation2);//loading image with id of animation




        //CODE FOR CREATING SPLASH WITH INTENT
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT );
    }
}
