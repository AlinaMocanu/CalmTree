package com.example.calmtree;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calmtree.model.User;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;


public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_login);
        EditText username = findViewById(R.id.username);
        final Editable email = username.getText();

        EditText password = findViewById(R.id.password);
        final Editable pass = password.getText();


        Button signinbtn = findViewById(R.id.login);
        Button registerbtn = findViewById(R.id.register);
        Button resetpass = findViewById(R.id.changepass);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //startActivity(new Intent(MainActivity.this,StandingsActivity.class));
                if (email.length() == 0 || pass.length() == 0) {

                    Toast toast = Toast.makeText(getApplicationContext(), "All fields are mandatory!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    auth.signInWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthUserCollisionException e) {
                                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        resetpass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                auth.sendPasswordResetEmail(email.toString()).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Reset link sent to your email", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthUserCollisionException e) {
                                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), "Unable to send reset mail", Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

    }
}
