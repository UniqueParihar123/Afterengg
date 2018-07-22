package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.example.anupamparihar.afterengg.R.id.bt5;
import static com.example.anupamparihar.afterengg.R.id.cva;
import static com.example.anupamparihar.afterengg.R.id.cvb;

public class blankactivity5 extends YouTubeBaseActivity {

    Button button;
    YouTubePlayerView youTubePlayerView; //key AIzaSyC7z36hFQsaaJE18bdr3upJRkzcgGF7gyE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blankactivity5);
        button=(Button)findViewById(R.id.btn2);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.ypv);
        Intent obj=getIntent();
        Bundle bundle=obj.getExtras();
        String a=(String) bundle.get("pass");

        if(a=="cva")
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override//yahan pe string google ki api key
                public void onClick(View v) {
                    youTubePlayerView.initialize("AIzaSyC7z36hFQsaaJE18bdr3upJRkzcgGF7gyE", new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                            youTubePlayer.loadVideo("SAcpESN_Fk4");          //use parameter object of youtubeplayer
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                        }
                    });
                }
            });
        }

       else if(a=="cvb")
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override//yahan pe string google ki api key
                public void onClick(View v) {
                    youTubePlayerView.initialize("AIzaSyC7z36hFQsaaJE18bdr3upJRkzcgGF7gyE", new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                            youTubePlayer.loadVideo("K4juJWyexYM");          //use parameter object of youtubeplayer
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                        }
                    });
                }
            });
        }



    }
}
