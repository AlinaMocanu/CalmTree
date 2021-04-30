package com.example.calmtree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_signup);

        EditText username = findViewById(R.id.username);
        final Editable email = username.getText();

        EditText password = findViewById(R.id.password);
        final Editable pass = password.getText();

        Button registerbtn = findViewById(R.id.register);

        registerbtn.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {

                auth.createUserWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthUserCollisionException e) {
                                Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
