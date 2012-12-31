package com.mgwt.imustlearn.client.model;

public class Translation {

    private String text;
    private Language language;

    public Translation(String text, Language language) {
        this.text = text;
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}