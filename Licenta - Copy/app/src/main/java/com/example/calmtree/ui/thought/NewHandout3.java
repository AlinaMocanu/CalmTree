package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calmtree.R;
import com.example.calmtree.model.FTB;
import com.example.calmtree.model.TT;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewHandout3 extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("TT");
    EditText evidenceForThought;
    EditText evidenceAgainstThought;
    EditText thoughtAccuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_handout3);
        Button save = findViewById(R.id.button2);

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        evidenceForThought = findViewById(R.id.editText7);
                                        evidenceAgainstThought = findViewById(R.id.editText8);
                                        thoughtAccuracy = findViewById(R.id.editText9);

                                        TT handout = new TT();
                                        handout.setAccuracyOfThought(thoughtAccuracy.getText().toString());
                                        handout.setEvidenceForMyThought(evidenceForThought.getText().toString());
                                        handout.setEvidenceAgainstThought(evidenceAgainstThought.getText().toString());

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
