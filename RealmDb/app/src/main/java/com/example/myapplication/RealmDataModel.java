package com.example.myapplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmDataModel  extends RealmObject {
    @PrimaryKey
    private long id;
    private String UserName;
    private String UserPosition;

    public  RealmDataModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPosition() {
        return UserPosition;
    }

    public void setUserPosition(String userPosition) {
        UserPosition = userPosition;
    }
}

