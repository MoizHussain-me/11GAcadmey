package com.example.a11gacadmey.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class SessionsModel {

    public String id, name ,session_url;

//For Firebase
    public SessionsModel() {
    }


    public SessionsModel(String id, String name, String session_url) {
        this.id = id;
        this.name = name;
        this.session_url = session_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSession_url() {
        return session_url;
    }

    public void setSession_url(String session_url) {
        this.session_url = session_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionsModel that = (SessionsModel) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getSession_url().equals(that.getSession_url());
    }


    public static DiffUtil.ItemCallback<SessionsModel> SessionCallBack =
            new DiffUtil.ItemCallback<SessionsModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull SessionsModel oldItem, @NonNull SessionsModel newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull SessionsModel oldItem, @NonNull SessionsModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

}
