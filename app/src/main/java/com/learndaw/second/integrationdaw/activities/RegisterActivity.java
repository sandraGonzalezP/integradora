package com.learndaw.second.integrationdaw.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.learndaw.second.integrationdaw.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Defined view onjects
    private EditText etEmail;
    private EditText txtPassword;
    private Button btRegister, btLogin;
    private ProgressDialog progressDialog;

    //Declare object firebase
    private FirebaseAuth auth;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private LoginButton lb;
    private CallbackManager callbackManager;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Inicialize object firebase
        auth = FirebaseAuth.getInstance();

        //References view
        etEmail = (EditText) findViewById(R.id.tv_email);
        txtPassword = (EditText) findViewById(R.id.et_password);
        btRegister = (Button) findViewById(R.id.bt_register);
        btLogin = (Button) findViewById(R.id.bt_login);
        progressDialog= new ProgressDialog(this);

        //Attaching listener o button
        btRegister.setOnClickListener(this);
        btLogin.setOnClickListener(this);

        //Facebook
        progressBar = (ProgressBar) findViewById(R.id.pb_load);

        callbackManager = CallbackManager.Factory.create();

        lb = (LoginButton) findViewById(R.id.lb);

        lb.setReadPermissions(Arrays.asList("email"));

        lb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    goMainScreen();
                }
            }
        };
    }
    //FACEBOOK
    private void handleFacebookAccessToken(AccessToken accessToken) {
        progressBar.setVisibility(View.VISIBLE);
        lb.setVisibility(View.GONE);

        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), R.string.firebase_error_login, Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
                lb.setVisibility(View.VISIBLE);
            }
        });
    }



    private void goMainScreen() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    private void registrarUsuario(){
        String email = etEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        //Verificates that TexBox it arent blank
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, R.string.need_email, Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.need_password, Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage(getString(R.string.load_register));
        progressDialog.show();

        //Creatting new user

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Checking if succes
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, R.string.success_register, Toast.LENGTH_LONG).show();


                        }
                        else{
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(RegisterActivity.this, R.string.duplicate_register, Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(RegisterActivity.this, R.string.fail_register, Toast.LENGTH_LONG).show();
                            }
                        }

                        progressDialog.dismiss();
                    }
                });

    }


    private void loguearUsuario(){
        final String email = etEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        //Verificates that TexBox it arent blank
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,  R.string.need_email, Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,  R.string.need_password, Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage(getString(R.string.dates_load));
        progressDialog.show();

        //Login user

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Checking if succes
                        if(task.isSuccessful()){
                            int pos=email.indexOf("@");
                            String user=email.substring(0,pos);
                            Toast.makeText(RegisterActivity.this,getString(R.string.welcome_to) + etEmail.getText(), Toast.LENGTH_LONG).show();
                           Intent intencion = new Intent(getApplication(), MenuActivity.class);
                            startActivity(intencion);

                        }
                        else{
                                Toast.makeText(RegisterActivity.this, R.string.incorrect_email_or_password, Toast.LENGTH_LONG).show();

                        }

                        progressDialog.dismiss();
                    }
                });
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_register:
                registrarUsuario();
                break;
            case R.id.bt_login:
                loguearUsuario();
                break;
        }


    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            goToMenu();
        }
    }
    private void goToMenu(){
        Intent intencion = new Intent(getApplication(), MenuActivity.class);
        startActivity(intencion);
    }
    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListener);
    }


    public EditText getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(EditText etEmail) {
        this.etEmail = etEmail;
    }

}
