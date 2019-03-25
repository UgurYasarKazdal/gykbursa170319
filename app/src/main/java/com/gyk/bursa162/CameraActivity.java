package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class CameraActivity extends Activity {

    private Button mBtn_resim;
    private Button mBtn_video;
    private static final int REQUEST_RESIM=10;
    private static final int REQUEST_VIDEO=20;
    private VideoView mVideoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mBtn_resim = findViewById(R.id.btn_camera_resimGoster);
        mBtn_video=findViewById(R.id.btn_camera_videoGoster);

        mBtn_resim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimGoster();
            }
        });

        mBtn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoGoster();
            }
        });

        findViewById(R.id.imgBtn_camera_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.start();
            }
        });

        findViewById(R.id.imgBtn_camera_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.pause();
            }
        });
    }

    private void resimGoster() {
        Intent intentResim=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentResim,REQUEST_RESIM);
    }

    private void videoGoster()
    {
        Intent intentVideo=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intentVideo,REQUEST_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode!=RESULT_OK)
        {
            return;
        }

        switch (requestCode)
        {
            case REQUEST_VIDEO:
                mVideoView =findViewById(R.id.video_camera_video);
                mVideoView.setVideoURI(data.getData());
                mVideoView.setMediaController(new MediaController(this));
                mVideoView.requestFocus();
                mVideoView.start();
                break;

            case REQUEST_RESIM:
                ((ImageView) findViewById(R.id.img_camera_resim)).setImageBitmap((Bitmap) data.getExtras().get("data")) ;
                break;
            default:
                break;
        }
    }
}
