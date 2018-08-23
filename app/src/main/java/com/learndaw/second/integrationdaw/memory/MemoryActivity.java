package com.learndaw.second.integrationdaw.memory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.learndaw.second.integrationdaw.R;

import java.util.Arrays;
import java.util.Collections;

public class MemoryActivity extends AppCompatActivity {

    TextView tvScore;
    ImageView ivMemory11, ivMemory12, ivMemory13, ivMemory14,
            ivMemory21, ivMemory22, ivMemory23, ivMemory24;

    //Array for the images
    Integer targetsM[]={101,102,103,104,201,202,203,204};
    //Images
    int image_101,image_102,image_103,image_104,
            image_201, image_202,image_203, image_204;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber=1;
    int playerPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        tvScore = (TextView) findViewById(R.id.tv_score_count);
        ivMemory11 = (ImageView) findViewById(R.id.iv_memory_1);
        ivMemory12 = (ImageView) findViewById(R.id.iv_memory_2);
        ivMemory13 = (ImageView) findViewById(R.id.iv_memory_3);
        ivMemory14 = (ImageView) findViewById(R.id.iv_memory_4);
        ivMemory21 = (ImageView) findViewById(R.id.iv_memory_5);
        ivMemory22 = (ImageView) findViewById(R.id.iv_memory_6);
        ivMemory23 = (ImageView) findViewById(R.id.iv_memory_5);
        ivMemory24 = (ImageView) findViewById(R.id.iv_memory_8);

        ivMemory11.setTag("0");
        ivMemory12.setTag("1");
        ivMemory13.setTag("2");
        ivMemory14.setTag("3");
        ivMemory21.setTag("4");
        ivMemory22.setTag("5");
        ivMemory23.setTag("6");
        ivMemory24.setTag("7");

        //Load images
        frontCard();

        Collections.shuffle(Arrays.asList(targetsM));

        ivMemory11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory11, theCard);

            }
        });
        ivMemory12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory12, theCard);

            }
        });
        ivMemory13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory13, theCard);
            }
        });
        ivMemory14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory14, theCard);

            }
        });
        ivMemory21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory21, theCard);

            }
        });
        ivMemory22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory22, theCard);

            }
        });
        ivMemory23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard= Integer.parseInt((String) v.getTag());
                doStuff(ivMemory23, theCard);

            }
        });
        ivMemory24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(ivMemory24, theCard);

            }
        });

    }
    private void doStuff(ImageView image, int card){

        //Set correct image to imageView

        if(targetsM[card]==101){
            image.setImageResource(image_101);
        }
        else if(targetsM[card]==102){
            image.setImageResource(image_102);
        }
        else if(targetsM[card]==103){
            image.setImageResource(image_103);
        }
        else if(targetsM[card]==104){
            image.setImageResource(image_104);
        }

        else if(targetsM[card]==201){
            image.setImageResource(image_201);
        }
        else if(targetsM[card]==202){
            image.setImageResource(image_202);
        }
        else if(targetsM[card]==203){
            image.setImageResource(image_203);
        }

        else if(targetsM[card]==204){
            image.setImageResource(image_204);
        }

        //Check Selection and save ttemporaty
        if(cardNumber==1){
            firstCard=targetsM[card];
            if(firstCard > 200){
                firstCard= firstCard-100;
            }
            cardNumber=2;
            clickFirst=card;
            image.setEnabled(false);
        }
        else if(cardNumber==2){
           secondCard=targetsM[card];
            if(secondCard > 200){
                secondCard= secondCard-100;
            }
            cardNumber=1;
            clickSecond=card;


            ivMemory11.setEnabled(false);
            ivMemory12.setEnabled(false);
            ivMemory13.setEnabled(false);
            ivMemory14.setEnabled(false);
            ivMemory21.setEnabled(false);
            ivMemory22.setEnabled(false);
            ivMemory23.setEnabled(false);
            ivMemory24.setEnabled(false);

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Check if the selected image are equals
                    calculate();

                }
            },1000);

        }
    }

    private void calculate() {

        //if image are equal add point
        if(firstCard==secondCard){
            if(clickFirst == 0){
                ivMemory11.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 1){
                ivMemory12.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 2){
                ivMemory13.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 3){
                ivMemory14.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 4){
                ivMemory21.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 5){
                ivMemory22.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 6){
                ivMemory23.setVisibility(View.INVISIBLE);
            }
            else if(clickFirst == 7){
                ivMemory24.setVisibility(View.INVISIBLE);
            }


            if(clickSecond == 0){
                ivMemory11.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 1){
                ivMemory12.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 2){
                ivMemory13.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 3){
                ivMemory14.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 4){
                ivMemory21.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 5){
                ivMemory22.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 6){
                ivMemory23.setVisibility(View.INVISIBLE);
            }
            else if(clickSecond == 7){
                ivMemory24.setVisibility(View.INVISIBLE);
            }
            playerPoints++;
            tvScore.setText("Aciertos: "+ playerPoints );
        }
        else{
            ivMemory11.setImageResource(R.drawable.logo);
            ivMemory12.setImageResource(R.drawable.logo);
            ivMemory13.setImageResource(R.drawable.logo);
            ivMemory14.setImageResource(R.drawable.logo);
            ivMemory21.setImageResource(R.drawable.logo);
            ivMemory22.setImageResource(R.drawable.logo);
            ivMemory23.setImageResource(R.drawable.logo);
            ivMemory24.setImageResource(R.drawable.logo);
        }
        ivMemory11.setEnabled(true);
        ivMemory12.setEnabled(true);
        ivMemory13.setEnabled(true);
        ivMemory14.setEnabled(true);
        ivMemory21.setEnabled(true);
        ivMemory22.setEnabled(true);
        ivMemory23.setEnabled(true);
        ivMemory24.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd() {
        if(ivMemory11.getVisibility()==View.INVISIBLE &&
                ivMemory12.getVisibility()==View.INVISIBLE &&
                ivMemory13.getVisibility()==View.INVISIBLE &&
                ivMemory14.getVisibility()==View.INVISIBLE &&
                ivMemory21.getVisibility()==View.INVISIBLE &&
                ivMemory22.getVisibility()==View.INVISIBLE &&
                ivMemory23.getVisibility()==View.INVISIBLE &&
                ivMemory24.getVisibility()==View.INVISIBLE ){

            AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(MemoryActivity.this);
            alertDialogBuilder
                    .setMessage(getString(R.string.finish_game)+ playerPoints)
                    .setCancelable(false)
                    .setPositiveButton(R.string.new_game, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i= new Intent(getApplicationContext(), MemoryActivity.class);
                    startActivity(i);
                    finish();

                }
            }).setNegativeButton(R.string.exit_game, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    private void frontCard() {
        image_101=R.drawable.img101;
        image_102=R.drawable.img102;
        image_103=R.drawable.img103;
        image_104=R.drawable.img104;
        image_201=R.drawable.img201;
        image_202=R.drawable.img202;
        image_203=R.drawable.img203;
        image_204=R.drawable.img204;

    }
}
