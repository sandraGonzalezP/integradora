package com.learndaw.second.integrationdaw.glosary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learndaw.second.integrationdaw.R;

public class GlosaryActivity extends AppCompatActivity {
    Button btWOne, btWTwo, btWThree, btWFour, btWFive, btWSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glosary);

        btWOne =(Button)findViewById(R.id.bt_encapsulation);
        btWTwo =(Button)findViewById(R.id.bt_system);
        btWThree =(Button)findViewById(R.id.bt_set_get);
        btWFour =(Button)findViewById(R.id.bt_abstract_factory);
        btWFive =(Button)findViewById(R.id.bt_flush);
        btWSix =(Button)findViewById(R.id.bt_prototype);

        btWOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_encaptulation)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        btWTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_system)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_set_get)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });


        btWFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_abstract_factory)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_flush)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.description_prototype)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glosary,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit_glosary,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

    }
}
