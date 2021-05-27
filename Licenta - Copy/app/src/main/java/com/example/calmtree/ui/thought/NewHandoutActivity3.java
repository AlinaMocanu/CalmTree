package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;

import com.example.calmtree.R;

public class NewHandoutActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_handout3);

        FloatingActionButton btn3 = findViewById(R.id.new_file3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewHandoutActivity3.this, NewHandout3.class);
                startActivity(intent);
                finish();
            }
        });

        Button seeAllHandouts = findViewById(R.id.button3);
        seeAllHandouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewHandoutActivity3.this, AllHandouts3.class);
                startActivity(intent);
                finish();

            }
        });
    }

}
