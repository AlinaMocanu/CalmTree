package com.example.calmtree.ui.sleep;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SleepViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SleepViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a helpful guide for you to improve your sleep");

    }

    public LiveData<String> getText() {
        return mText;
    }

}