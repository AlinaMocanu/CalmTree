package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calmtree.R;
import com.example.calmtree.model.ETE;
import com.example.calmtree.model.FTB;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewHandout2 extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("ETE");
    EditText events;
    EditText thought;
    EditText emotions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_handout2);
        Button save = findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        events = findViewById(R.id.editText5);
                                        thought = findViewById(R.id.editText4);
                                        emotions = findViewById(R.id.editText6);

                                        ETE handout = new ETE();
                                        handout.setEvents(events.getText().toString());
                                        handout.setThoughts(thought.getText().toString());
                                        handout.setEmotions(emotions.getText().toString());

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
