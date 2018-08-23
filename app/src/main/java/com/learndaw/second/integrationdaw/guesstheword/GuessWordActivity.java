package com.learndaw.second.integrationdaw.guesstheword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learndaw.second.integrationdaw.R;
import com.learndaw.second.integrationdaw.fragment.LevelsActivity;

public class GuessWordActivity extends AppCompatActivity {
    Button btPlay, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_word);

        btPlay =(Button)findViewById(R.id.bt_play);
        btExit =(Button)findViewById(R.id.bt_exit);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(GuessWordActivity.this, PlayGuessActivity.class);
                startActivity(play);
            }
        });
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir= new Intent(GuessWordActivity.this, LevelsActivity.class);
                startActivity(salir);
            }
        });
    }
}
