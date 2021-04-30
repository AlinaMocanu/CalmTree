package com.example.calmtree.ui.thought;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calmtree.R;

public class ThoughtViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    public ThoughtViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a helpful guide for you to track your thought pattern");


    }

    public LiveData<String> getText() {
        return mText;
    }

}