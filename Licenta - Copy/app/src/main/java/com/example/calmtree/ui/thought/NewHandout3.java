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
import com.example.calmtree.model.FTB;
import com.example.calmtree.model.TT;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.Calendar;

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
                                    @RequiresApi(api = Build.VERSION_CODES.O)
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        evidenceForThought = findViewById(R.id.editText7);
                                        evidenceAgainstThought = findViewById(R.id.editText8);
                                        thoughtAccuracy = findViewById(R.id.editText9);
                                        Calendar calendar = Calendar.getInstance();
                                        String title = "Handout " + LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonth() + "-" +
                                                LocalDate.now().getYear() + "-" +  calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);

                                        TT handout = new TT();
                                        handout.setAccuracyOfThought(thoughtAccuracy.getText().toString());
                                        handout.setEvidenceForMyThought(evidenceForThought.getText().toString());
                                        handout.setEvidenceAgainstThought(evidenceAgainstThought.getText().toString());
                                        handout.setTitle(title);

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
