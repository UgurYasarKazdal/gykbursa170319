package com.gyk.bursa162;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;

public class VoiceActivity extends Activity implements View.OnClickListener {

    private Button mBtn_record;
    private Button mBtn_stop;
    private Button mBtn_play;
    private MediaRecorder mMediaRecorder;
    private MediaPlayer mMediaPlayer;
    private final String filePath = Environment.getExternalStorageDirectory().getPath() + "/record.3gp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        mBtn_play = findViewById(R.id.btn_voice_play);
        mBtn_play.setOnClickListener(this);
        mBtn_record = findViewById(R.id.btn_voice_record);
        mBtn_record.setOnClickListener(this);
        mBtn_stop = findViewById(R.id.btn_voice_stop);
        mBtn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtn_record) {
            if (checkPermissions()) {
                startRecording();
            } else {
                requestAllPermissions();
                startRecording();
            }
        } else if (v == mBtn_stop) {
            stopRecording();
        } else {
            startPlaying();
        }
    }

    private void startPlaying() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setVolume(1.0f, 1.0f);
        try {
            mMediaPlayer.setDataSource(filePath);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            Toast.makeText(this, "Kayıt çalınıyor...", Toast.LENGTH_SHORT).show();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        if (mMediaRecorder != null) {
            Toast.makeText(this, "Kayıt durduruldu...", Toast.LENGTH_SHORT).show();
            mMediaRecorder.stop();
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;

        }
    }

    private void startRecording() {
        mMediaRecorder = new MediaRecorder();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mMediaRecorder.setOutputFile(filePath);

        try {
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            Toast.makeText(this, "Ses kayıt yapılıyor...", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void requestAllPermissions() {
        ActivityCompat.requestPermissions(VoiceActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO,}, 1);
    }

    private boolean checkPermissions() {
        int resultStorage = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int resultAudio = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);

        return resultAudio == PackageManager.PERMISSION_GRANTED && resultStorage == PackageManager.PERMISSION_GRANTED;
    }
}
