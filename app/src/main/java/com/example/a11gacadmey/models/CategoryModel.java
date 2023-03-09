package com.example.a11gacadmey.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class CategoryModel {

    String id,name,image;

    public CategoryModel(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return getId().equals(that.getId()) && getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

   public static DiffUtil.ItemCallback<CategoryModel> catItemCallBack = new DiffUtil.ItemCallback<CategoryModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull CategoryModel oldItem, @NonNull CategoryModel newItem) {

            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull CategoryModel oldItem, @NonNull CategoryModel newItem) {
            return oldItem.equals(newItem);
        }
    };



}
