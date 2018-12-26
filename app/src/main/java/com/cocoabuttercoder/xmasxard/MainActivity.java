package com.cocoabuttercoder.xmasxard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.video);

        String videoPath = "android.resource://com.cocoabuttercoder.xmasxard/" + R.raw.xmas_tree_and_fireplace;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp){
                mp.setLooping(true);
            }
        });
    }

    public void openCard(View view){
        Intent i =  new Intent(this, CardActivity.class);
        startActivity(i);
    }
}
