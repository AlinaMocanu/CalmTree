package com.example.calmtree.ui.breathe;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calmtree.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BreatheFragment extends Fragment {

   // private BreatheViewModel galleryViewModel;
    private View view;
    private Button start;
    Context context;
    TextView breathe;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_breathe, container, false);

        context = container.getContext();
        view = root.findViewById(R.id.view_circle);
        breathe = root.findViewById(R.id.breathe);
        breathe.setText("inhale");



        start =  root.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Animation animZoomIn = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.zoom_in);
                Animation animZoomOut = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.zoom_out);
                view.startAnimation(animZoomIn);
                animZoomIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        view.startAnimation(animZoomOut);
                        breathe.setText("exhale");


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                animZoomOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        view.startAnimation(animZoomIn);
                        breathe.setText("inhale");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        return root;
    }


}
