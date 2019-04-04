package com.example.louisli.live;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;

import com.baidu.cloud.media.player.BDCloudMediaPlayer;
import com.baidu.cloud.media.player.IMediaPlayer;
import com.example.louisli.live.widget.BDCloudVideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDCloudMediaPlayer.setAK("9c0d143e0fce44cb9dc51debeea2c186");
        BDCloudVideoView videoView = findViewById(R.id.video_view);
        MediaController controller = findViewById(R.id.video_controller);
        controller.setMediaPlayer(videoView);
        String s = "http://tb-video.bdstatic.com/tieba-smallvideo/1116878_e3a8d2b10bd099f523cbc9e87a64f53a.mp4";
        videoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                Log.e("onPrepared", "onPrepared");
            }
        });
        videoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                Log.e("onCompletion", "onCompletion");
            }
        });
        videoView.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.e("onError", "onError");
                return false;
            }
        });
        videoView.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.e("onInfo", "onInfo");
                return false;
            }
        });
        videoView.setOnPlayerStateListener(new BDCloudVideoView.OnPlayerStateListener() {
            @Override
            public void onPlayerStateChanged(BDCloudVideoView.PlayerState nowState) {
                Log.e("onPlayerStateChanged:nowState:", nowState.name());
            }
        });
        videoView.setVideoPath("rtmp://10.2.19.84/live/stream");
        videoView.start();
    }
}
