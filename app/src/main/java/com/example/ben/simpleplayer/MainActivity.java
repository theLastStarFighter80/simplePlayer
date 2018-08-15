package com.example.ben.simpleplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.alone);

        Button butt1 = (Button) findViewById(R.id.b1);
        Button butt2 = (Button) findViewById(R.id.b2);

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        // Initialize listener using setOnCompletionListener for mediaPlayer object
        // and declare new method OnCompletionListener as an argument.
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            // Override onCompletion method to apply desired operations.
            @Override
            public void onCompletion(MediaPlayer mediaPlayer){
                // Whatever you want to do when the audio playback is done...
                // Here I show a toast message as an indicator
                //for audio playback completion.
                Toast.makeText(MainActivity.this,"I'm done!",Toast.LENGTH_LONG).show();
            }
        } );
    }

}
