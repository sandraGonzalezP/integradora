package com.learndaw.second.integrationdaw.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.learndaw.second.integrationdaw.R;
import com.learndaw.second.integrationdaw.fragment.LevelsActivity;
import com.learndaw.second.integrationdaw.glosary.GlosaryActivity;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {
    Dialog myDialog;
    TextView tvClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        myDialog = new Dialog(this);

        myDialog.setContentView(R.layout.custompopup);
        tvClose =(TextView) myDialog.findViewById(R.id.tv_close);
        tvClose.setText("X");
    }

    public void goGraph(View v) {
        Intent g = new Intent(MenuActivity.this, GraphActivity.class);
        startActivity(g);

    }




    public void goVideos(View v) {
        Intent vi = new Intent(MenuActivity.this, VideosActivity.class);
        startActivity(vi);
    }

    public void goInfo(View v) {
        Intent i = new Intent(MenuActivity.this, IntroductionActivity.class);
        startActivity(i);
    }

    public void goLevel(View v) {
        Intent l = new Intent(MenuActivity.this, LevelsActivity.class);
        startActivity(l);
    }
    public void goGlosary(View v) {
        Intent g = new Intent(MenuActivity.this, GlosaryActivity.class);
        startActivity(g);

    }
    public void goShare(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "splash.gif");
        intent.setPackage("com.facebook.katana");
        startActivity(intent);

    }

    public void close(View v) {
        logOut();
    }

    private void logOut() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            goToLogin();
        }
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    private void goToLogin() {
        Intent c = new Intent(MenuActivity.this, RegisterActivity.class);
        startActivity(c);
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            goToLogin();
        }




            tvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

    }
}
