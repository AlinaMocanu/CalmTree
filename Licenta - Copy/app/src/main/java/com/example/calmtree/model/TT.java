package com.example.calmtree.model;

import java.io.Serializable;

public class TT implements Serializable {
    private String evidenceForMyThought;
    private String evidenceAgainstThought;
    private String accuracyOfThought;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public String getEvidenceForMyThought() {
        return evidenceForMyThought;
    }

    public void setEvidenceForMyThought(String evidenceForMyThought) {
        this.evidenceForMyThought = evidenceForMyThought;
    }

    public String getEvidenceAgainstThought() {
        return evidenceAgainstThought;
    }

    public void setEvidenceAgainstThought(String evidenceAgainstThought) {
        this.evidenceAgainstThought = evidenceAgainstThought;
    }

    public String getAccuracyOfThought() {
        return accuracyOfThought;
    }

    public void setAccuracyOfThought(String accuracyOfThought) {
        this.accuracyOfThought = accuracyOfThought;
    }


}
