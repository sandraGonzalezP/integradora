package com.learndaw.second.integrationdaw.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.learndaw.second.integrationdaw.activities.MenuActivity;
import com.learndaw.second.integrationdaw.R;

public class LevelsActivity extends AppCompatActivity implements View.OnClickListener, FragUnitOne.OnFragmentInteractionListener, FragUnitTwo.OnFragmentInteractionListener, FragUnitThree.OnFragmentInteractionListener, FragUnitFour.OnFragmentInteractionListener, FragUnitFive.OnFragmentInteractionListener {
    Button btFrag1, btFrag2, btFrag3, btFrag4, btFrag5;
    ImageView ivLogo;
    Dialog DMyDialog;
    TextView tvclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //Agregar Fragments como contenedor
        FragUnitOne Fragment1 = new FragUnitOne();

        getSupportFragmentManager().beginTransaction().add(R.id.Contetnt,Fragment1);

        btFrag1 =(Button)findViewById(R.id.fg_unit1);
        btFrag2 =(Button)findViewById(R.id.fg_unit2);
        btFrag3 =(Button)findViewById(R.id.fg_unit3);
        btFrag4 =(Button)findViewById(R.id.fg_unit4);
        btFrag5 =(Button)findViewById(R.id.fg_unit5);
        ivLogo =(ImageView)findViewById(R.id.iv_logo);

        DMyDialog = new Dialog(this);

        DMyDialog.setContentView(R.layout.custompopuplevels);
        tvclose =(TextView) DMyDialog.findViewById(R.id.tv_close);
        tvclose.setText("X");

        //Dinamica en los botones

        btFrag1.setOnClickListener(this);
        btFrag2.setOnClickListener(this);
        btFrag3.setOnClickListener(this);
        btFrag4.setOnClickListener(this);
        btFrag5.setOnClickListener(this);

        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(LevelsActivity.this, MenuActivity.class);
                startActivity(m);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fg_unit1:
                FragUnitOne Fragment1 = new FragUnitOne();
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Contetnt, Fragment1);
                transaction.commit();
                break;
            case R.id.fg_unit2:
                FragUnitTwo Fragment2 = new FragUnitTwo();
                FragmentTransaction transaction2= getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.Contetnt, Fragment2);
                transaction2.commit();
                break;
            case R.id.fg_unit3:
                FragUnitThree Fragment3 = new FragUnitThree();
                FragmentTransaction transaction3= getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.Contetnt, Fragment3);
                transaction3.commit();
                break;
            case R.id.fg_unit4:
                FragUnitFour Fragment4 = new FragUnitFour();
                FragmentTransaction transaction4= getSupportFragmentManager().beginTransaction();
                transaction4.replace(R.id.Contetnt, Fragment4);
                transaction4.commit();
                break;
            case R.id.fg_unit5:
                FragUnitFive Fragment5 = new FragUnitFive();
                FragmentTransaction transaction5= getSupportFragmentManager().beginTransaction();
                transaction5.replace(R.id.Contetnt, Fragment5);
                transaction5.commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DMyDialog.dismiss();
            }
        });
        DMyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DMyDialog.show();

    }
}
