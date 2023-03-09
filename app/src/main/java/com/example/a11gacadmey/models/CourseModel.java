package com.example.a11gacadmey.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.a11gacadmey.viewmodels.CourseViewModel;
import com.google.firebase.firestore.DocumentReference;

import java.util.Objects;

public class CourseModel {

   private String id,name,image,description,age,duration,language;
   private DocumentReference trainer;
   private int views,rating;


   //For firebase
   public  CourseModel(){


   }



    public CourseModel(String id,CourseModel c)
    {
//            String id, String name, String image, String description, String trainer, String age, String duration, String language, int views, double rating) {
        this.id = id;
        this.name = c.name;
        this.image = c.image;
        this.description = c.description;
        this.trainer = c.trainer;
        this.age = c.age;
        this.duration = c.duration;
        this.language = c.language;
        this.views = c.views;
        this.rating = c.rating;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentReference getTrainer() {
        return trainer;
    }

    public void setTrainer(DocumentReference trainer) {
        this.trainer = trainer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseModel that = (CourseModel) o;
        return getViews() == that.getViews() && Integer.compare(that.getRating(), getRating()) == 0 && getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getImage(), that.getImage()) && getDescription().equals(that.getDescription()) &&  Objects.equals(getAge(), that.getAge()) && getDuration().equals(that.getDuration()) && Objects.equals(getLanguage(), that.getLanguage());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static DiffUtil.ItemCallback<CourseModel> CourseCallBack =
            new DiffUtil.ItemCallback<CourseModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull CourseModel oldItem, @NonNull CourseModel newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull CourseModel oldItem, @NonNull CourseModel newItem) {
                    return oldItem.equals(newItem);
                }
            };



}
