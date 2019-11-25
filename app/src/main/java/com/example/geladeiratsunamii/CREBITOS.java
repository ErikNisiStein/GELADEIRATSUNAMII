package com.example.geladeiratsunamii;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class CREBITOS extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onStop()
    {
        player.stop();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crebitos);
        player = MediaPlayer.create(getApplicationContext(),R.raw.geladeiratsunami);
        player.start();
    }
}
