package com.example.calmtree.ui.breathe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BreatheViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BreatheViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a helpful guide for breathing exercises");
    }

    public LiveData<String> getText() {
        return mText;
    }
}