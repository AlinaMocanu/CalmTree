package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.calmtree.model.FTB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.calmtree.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class AllHandouts extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("FTB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_handouts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Handouts");

        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout);

        // Create a LinearLayout element
        LinearLayout linearLayout = new LinearLayout(AllHandouts.this);
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
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ftb = dataSnapshot.getChildren();
                for (DataSnapshot d : ftb) {


                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + d.getValue());
                    FTB obj = d.getValue(FTB.class);
                    Button handout = new Button(AllHandouts.this);
                    handout.setBackgroundResource(R.drawable.button);
                    handout.setText(obj.getTitle());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams. MATCH_PARENT ,
                            LinearLayout.LayoutParams. WRAP_CONTENT);
                    params.setMargins( 30 , 10 , 30 , 0 ) ;
                    handout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(AllHandouts.this, SavedHandout.class);
                            intent.putExtra("FTB", obj);
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
