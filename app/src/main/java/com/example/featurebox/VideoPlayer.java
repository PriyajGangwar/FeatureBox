package com.example.featurebox;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoPlayer extends AppCompatActivity {
    Button b1;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_player);
        b1=(Button) findViewById(R.id.button2);
        vv=(VideoView) findViewById(R.id.videoView);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        vv.setVideoURI(uri);
        vv.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vv.isPlaying()) vv.pause();
                else vv.resume();
            }
        });

    }
}