package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //First, Create a ArrayList and put some data man!
        final ArrayList<Words> colors = new ArrayList<Words>( );

        //Add on ArrayList
        colors.add(new Words("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new Words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colors.add(new Words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Words("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Words("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Words("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Words("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Words("white", "kelelli", R.drawable.color_white, R.raw.color_white));

        //Instaciate a objeact to inflate two textview instead of one
        WordsAdapter colorsAdapter = new WordsAdapter(this, colors, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                Words getSong = colors.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this, getSong.getSongResource( ));
                releaseMediaPlayer();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener( ) {
                    @Override
                    public void onCompletion( MediaPlayer mediaPlayer ) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
        private void releaseMediaPlayer(){
          if (mediaPlayer != null){
              mediaPlayer.release();
              mediaPlayer = null;
          }
    }
}
