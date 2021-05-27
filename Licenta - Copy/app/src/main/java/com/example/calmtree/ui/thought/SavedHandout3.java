package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calmtree.R;
import com.example.calmtree.model.TT;

public class SavedHandout3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_handout3);
        TT handout = (TT) getIntent().getSerializableExtra("TT");
        TextView evidenceForThought = findViewById(R.id.textView25);
        evidenceForThought.setText(handout.getEvidenceForMyThought());
        TextView evidenceAgainstThought = findViewById(R.id.textView26);
        evidenceAgainstThought.setText(handout.getEvidenceAgainstThought());
        TextView thoughtAccuracy = findViewById(R.id.textView28);
        thoughtAccuracy.setText(handout.getAccuracyOfThought());
    }
}
