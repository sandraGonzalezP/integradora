package com.learndaw.second.integrationdaw.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.learndaw.second.integrationdaw.R;


public class GifActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

    }
    public void goMenu (View v){
        Intent c= new Intent(GifActivity.this, MenuActivity.class);
        startActivity(c);
    }
}
