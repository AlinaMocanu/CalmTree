package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calmtree.R;
import com.example.calmtree.model.FTB;

public class SavedHandout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_handout);
        FTB handout = (FTB) getIntent().getSerializableExtra("FTB");
        TextView whatIFelt = findViewById(R.id.textView18);
        whatIFelt.setText(handout.getWhatIFelt());
        TextView whatIThought = findViewById(R.id.textView21);
        whatIThought.setText(handout.getWhatIThought());
        TextView whatIDid = findViewById(R.id.textView22);
        whatIDid.setText(handout.getWhatIDid());

    }
}
