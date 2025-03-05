package com.example.ex1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner soundSpinner;
   Button playBt,StopBt;
    SeekBar volumeSeekBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        soundSpinner = findViewById(R.id.soundSpinner);
        playBt = findViewById(R.id.playBt);
        StopBt = findViewById(R.id.StopBt);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);

        //建立ArrayAdapter
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.soundOptions, android.R.layout.simple_spinner_item
        );

        //設定顯示格式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //設定spinner的資料來源與格式
        soundSpinner.setAdapter(arrayAdapter);

        volumeSeekBar.setMax(100);//設定音量最大值
        volumeSeekBar.setProgress(50);//預設音量50

        //設定播放事件
        playBt.setOnClickListener(new playOnClickListener());
        //設定停止按鈕事件
        StopBt.setOnClickListener(new StopOnClickListener());
        //設定音量控制
        volumeSeekBar.setOnSeekBarChangeListener(new volumeSeekBarOnSeekBarChangeListener());

        playBt.setOnClickListener(new playOnClickListener());
        StopBt.setOnClickListener(new StopOnClickListener());
    }

    private class playOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int selectedSound = soundSpinner.getSelectedItemPosition();
//            Log.d("msg_show","selectedSound="+selectedSound);
            playSound(selectedSound);

        }
    }

    private void playSound(int selectedSound) {
        stopSound();
        int soundResId;
        switch (selectedSound) {
            case 0:
                soundResId = R.raw.chinese1;
                break;
            case 1:
                soundResId = R.raw.chinese2;
                break;
            case 2:
                soundResId = R.raw.chinese3;
                break;
            default:
                Toast.makeText(this, "Invalid selection", Toast.LENGTH_SHORT).show();
                return;
        }
        mediaPlayer = MediaPlayer.create(this, soundResId);//建立物件
        mediaPlayer.setLooping(true);//設定音樂循環
        mediaPlayer.start();//開始播放音樂


        }
    //停止播放音樂
    private void stopSound() {
        if (mediaPlayer!=null){
            mediaPlayer.stop();//停止播放
            mediaPlayer.release();//釋放音源
            mediaPlayer=null;
        }
    }

    private class StopOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            stopSound();

        }
    }

    private class volumeSeekBarOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (mediaPlayer!=null){
                float volume = progress/100f;//值轉換成0-1
                mediaPlayer.setVolume(volume,volume);

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}