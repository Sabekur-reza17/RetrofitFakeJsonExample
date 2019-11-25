package com.appsgallery.retrofitfakejsonexample.model;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    protected Post(Parcel in) {
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        body = in.readString();
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
