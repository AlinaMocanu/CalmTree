package com.example.calmtree.model;

import java.io.Serializable;

public class ETE implements Serializable {

    private String thoughts;
    private String event;
    private String behaviour;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getEvents() {
        return event;
    }

    public void setEvents(String events) {
        this.event = events;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }



}
