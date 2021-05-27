package com.example.calmtree.ui.thought;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calmtree.R;
import com.example.calmtree.model.ETE;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.Calendar;

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
                                    @RequiresApi(api = Build.VERSION_CODES.O)
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        events = findViewById(R.id.editText5);
                                        thought = findViewById(R.id.editText4);
                                        emotions = findViewById(R.id.editText6);
                                        Calendar calendar = Calendar.getInstance();
                                        String title = "Handout " + LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonth() + "-" +
                                                LocalDate.now().getYear() + "-" +  calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);

                                        ETE handout = new ETE();
                                        handout.setEvents(events.getText().toString());
                                        handout.setThoughts(thought.getText().toString());
                                        handout.setBehaviour(emotions.getText().toString());
                                        handout.setTitle(title);

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
