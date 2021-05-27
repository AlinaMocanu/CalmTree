package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.example.calmtree.model.ETE;
import com.example.calmtree.model.FTB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.calmtree.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class AllHandouts2 extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("ETE");
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_handouts2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Handouts");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        NestedScrollView ll = (NestedScrollView) findViewById(R.id.layout2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Attach a listener to read the data at our posts reference
        handoutRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ete = dataSnapshot.getChildren();
                for (DataSnapshot d : ete) {

                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + d.getValue());
                    ETE obj = d.getValue(ETE.class);

                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

                    Button handout = new Button(AllHandouts2.this);
                    handout.setBackgroundResource(R.drawable.button);
                    handout.setText(obj.getTitle());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams. MATCH_PARENT ,
                            LinearLayout.LayoutParams. WRAP_CONTENT);
                    params.setMargins( 30 , 10 , 30 , 0 ) ;
                    handout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(AllHandouts2.this, SavedHandout2.class);
                            intent.putExtra("ETE", obj);
                            startActivity(intent);
                            finish();
                        }
                    });

                    linearLayout.addView(handout, params);

                    // layout.addView(handout);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        ll.addView(linearLayout);
    }
}
