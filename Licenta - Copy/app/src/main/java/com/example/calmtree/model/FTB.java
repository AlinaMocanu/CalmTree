package com.example.calmtree.model;

import android.widget.EditText;

import java.io.Serializable;

public class FTB implements Serializable {


    private String whatIFelt;
    private String whatIThought;
    private String WhatIDid;
    private String title;

    public String getWhatIFelt() {
        return whatIFelt;
    }

    public String getWhatIThought() {
        return whatIThought;
    }

    public String getWhatIDid() {
        return WhatIDid;
    }



    public void setWhatIFelt(String whatIFelt) {
        this.whatIFelt = whatIFelt;
    }

    public void setWhatIThought(String whatIThought) {
        this.whatIThought = whatIThought;
    }

    public void setWhatIDid(String whatIDid) {
        WhatIDid = whatIDid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
