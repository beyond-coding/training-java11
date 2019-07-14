package com.beyondcoding.java11.stream.advanced.sms;

public class Sms {

    private String label;
    private String text;

    public Sms(String label, String text) {
        this.label = label;
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }
}
