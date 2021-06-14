package com.example.calmtree.ui.home;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calmtree.R;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView lightBulb;
    private ImageView breathe;
    private ImageView palmTree;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        context = container.getContext();
        lightBulb = root.findViewById(R.id.lightbulb);
        breathe = root.findViewById(R.id.breathe);
        palmTree = root.findViewById(R.id.palmTree);


        Animation animFadeIn1 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut1 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_out);
        lightBulb.startAnimation(animFadeIn1);

        animFadeIn1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                lightBulb.startAnimation(animFadeOut1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animFadeOut1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                lightBulb.startAnimation(animFadeIn1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Animation animFadeIn2 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut2 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_out);
        breathe.startAnimation(animFadeIn2);
        animFadeIn2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                breathe.startAnimation(animFadeOut2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animFadeOut2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                breathe.startAnimation(animFadeIn2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Animation animFadeIn3 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut3 = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_out);
        palmTree.startAnimation(animFadeIn3);
        animFadeIn3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                palmTree.startAnimation(animFadeOut3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animFadeOut3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                palmTree.startAnimation(animFadeIn3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return root;
    }
}
