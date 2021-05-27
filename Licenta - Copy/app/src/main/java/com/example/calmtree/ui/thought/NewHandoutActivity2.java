package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;
import android.widget.Button;

import com.example.calmtree.R;

public class NewHandoutActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_handout2);

        FloatingActionButton btn2 = findViewById(R.id.new_file2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewHandoutActivity2.this, NewHandout2.class);
                startActivity(intent);
                finish();


            }
        });

        Button seeAllHandouts = findViewById(R.id.button3);
        seeAllHandouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewHandoutActivity2.this, AllHandouts2.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
