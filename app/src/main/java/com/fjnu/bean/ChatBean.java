package com.fjnu.bean;

/**
 * Created by Administrator on 2016/10/22.
 */

public class ChatBean {
    private String aswer;
    private String question;

    public String getAswer() {
        return aswer;
    }

    public void setAswer(String aswer) {
        this.aswer = aswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ChatBean{" +
                "aswer='" + aswer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
