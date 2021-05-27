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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.Calendar;

public class NewHandout extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("FTB");
    EditText whatIFelt;
    EditText whatIThought;
    EditText whatIDid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_handout);
        Button save = findViewById(R.id.button4);

        save.setOnClickListener(new View.OnClickListener() {
                                    @RequiresApi(api = Build.VERSION_CODES.O)
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        whatIFelt = findViewById(R.id.editText);
                                        whatIThought = findViewById(R.id.editText2);
                                        whatIDid = findViewById(R.id.editText3);
                                        Calendar calendar = Calendar.getInstance();
                                        String title = "Handout " + LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonth() + "-" +
                                                LocalDate.now().getYear() + "-" +  calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
                                        FTB handout = new FTB();
                                        handout.setWhatIFelt(whatIFelt.getText().toString());
                                        handout.setWhatIThought(whatIThought.getText().toString());
                                        handout.setWhatIDid(whatIDid.getText().toString());
                                        handout.setTitle(title);

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
