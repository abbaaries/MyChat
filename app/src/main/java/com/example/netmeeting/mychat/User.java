package com.example.netmeeting.mychat;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String TopicSN;
    public int like;
    public HashMap<String,String> likes;
    public String name;
    public String stfn;
    public int tag;
    public String text;
    public long timestamp;

    public String getTopicSN() {
        return TopicSN;
    }

    public void setTopicSN(String topicSN) {
        TopicSN = topicSN;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public HashMap<String, String> getLikes() {
        return likes;
    }

    public void setLikes(HashMap<String, String> likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStfn() {
        return stfn;
    }

    public void setStfn(String stfn) {
        this.stfn = stfn;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "TopicSN='" + TopicSN + '\'' +
                ", like=" + like +
                ", likes=" + likes +
                ", name='" + name + '\'' +
                ", stfn='" + stfn + '\'' +
                ", tag=" + tag +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public User(String topicSN, int like, HashMap<String, String> likes, String name, String stfn, int tag, String text, long timestamp) {
        TopicSN = topicSN;
        this.like = like;
        this.likes = likes;
        this.name = name;
        this.stfn = stfn;
        this.tag = tag;
        this.text = text;
        this.timestamp = timestamp;
    }

    public User() {
    }
}
