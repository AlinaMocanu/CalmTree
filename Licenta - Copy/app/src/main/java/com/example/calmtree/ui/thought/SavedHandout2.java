package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calmtree.R;
import com.example.calmtree.model.ETE;

public class SavedHandout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_handout2);
        ETE handout = (ETE) getIntent().getSerializableExtra("ETE");
        TextView thoughts = findViewById(R.id.textView18);
        thoughts.setText(handout.getThoughts());
        TextView event = findViewById(R.id.textView21);
        event.setText(handout.getEvents());
        TextView behaviour = findViewById(R.id.textView22);
        behaviour.setText(handout.getBehaviour());
    }
}
