package com.example.calmtree.ui.thought;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.calmtree.R;
import com.example.calmtree.ui.thought.NewHandoutActivity;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;


public class ThoughtFragment extends Fragment {

    private ThoughtViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(ThoughtViewModel.class);
        View root = inflater.inflate(R.layout.fragment_thought, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Button ftb_button =  root.findViewById(R.id.button_ftb);
        ftb_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewHandoutActivity.class);
                startActivity(intent);
               // finish();
            }
        });

        Button ete_button =  root.findViewById(R.id.button_ete);
        ete_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewHandoutActivity2.class);
                startActivity(intent);
                // finish();
            }
        });

        Button tt_button =  root.findViewById(R.id.button_tt);
        tt_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewHandoutActivity3.class);
                startActivity(intent);
                // finish();
            }
        });
        FirebaseInAppMessaging.getInstance().triggerEvent("main_activity");

        return root;
    }
}
