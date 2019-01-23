package ru.usetech.qa.model;

public class ManIncData {

    private String postUrlField;
    private String postText;


    public String getPostUrlField() {
        return postUrlField;
    }

    public String getPostText() {
        return postText;
    }


    public ManIncData postUrlField(String postUrl) {
        this.postUrlField = postUrl;
        return this;
    }

    public ManIncData postText(String postText) {
        this.postText = postText;
        return this;
    }


}