package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.calmtree.model.FTB;
import com.example.calmtree.model.TT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

public class AllHandouts3 extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("TT");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_handouts3);
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
                Intent intent = new Intent(AllHandouts3.this, NewHandout3.class);
                startActivity(intent);
                finish();
            }
        });

        // Attach a listener to read the data at our posts reference
        handoutRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> tt = dataSnapshot.getChildren();
                for (DataSnapshot d : tt) {

                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + d.getValue());
                    TT obj = d.getValue(TT.class);
                    Button handout = new Button(AllHandouts3.this);
                    handout.setText(obj.getTitle());
                    handout.setBackgroundResource(R.drawable.button);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams. MATCH_PARENT ,
                            LinearLayout.LayoutParams. WRAP_CONTENT);
                    params.setMargins( 30 , 10 , 30 , 0 ) ;
                    handout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(AllHandouts3.this, SavedHandout3.class);
                            intent.putExtra("TT", obj);
                            startActivity(intent);
                            finish();
                        }
                    });
                    linearLayout.addView(handout, params);


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
