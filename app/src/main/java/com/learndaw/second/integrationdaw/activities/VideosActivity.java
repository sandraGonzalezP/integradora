package com.learndaw.second.integrationdaw.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.learndaw.second.integrationdaw.R;


public class VideosActivity extends AppCompatActivity {
   private VideoView vView;
   private Uri vUri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        vView = (VideoView) findViewById(R.id.v_video);


    }
    public void videoPlay(View v) {
        vUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/integrationdaw.appspot.com/o/Videos_Grades%2Finstalacion.mp4?alt=media&token=7d83c6cd-7f69-4738-9e16-a89fff259e3f");
        vView.setVideoURI(vUri);
        vView.requestFocus();
        vView.start();
    }
    public void goMenu(View v) {
        Intent intentMenu = new Intent(VideosActivity.this, MenuActivity.class);
        startActivity(intentMenu);
        finish();
    }


}
