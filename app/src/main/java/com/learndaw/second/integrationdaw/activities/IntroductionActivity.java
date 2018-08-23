package com.learndaw.second.integrationdaw.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.learndaw.second.integrationdaw.R;

public class IntroductionActivity extends AppCompatActivity {
    TextView tvMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        tvMainMenu = (TextView) findViewById(R.id.tv_menu);

        tvMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(IntroductionActivity.this, MenuActivity.class);
                startActivity(intentMenu);
                finish();

            }

        });
    }
}
