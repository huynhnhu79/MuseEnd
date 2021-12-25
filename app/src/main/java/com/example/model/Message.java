package com.example.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class Message {
    @PrimaryKey
    @NonNull
    private String id;
    private String type;
    private String massage;

    public Message() {
    }

    public Message(String id, String type, String massage) {
        this.id = id;
        this.type = type;
        this.massage = massage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
