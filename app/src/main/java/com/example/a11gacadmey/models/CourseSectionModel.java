package com.example.a11gacadmey.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class CourseSectionModel {

    String Category;
    ArrayList<CourseModel> CourseList = new ArrayList<>();

    public CourseSectionModel(String category, ArrayList<CourseModel> courseList) {
        Category = category;
        CourseList = courseList;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public ArrayList<CourseModel> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<CourseModel> courseList) {
        CourseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSectionModel that = (CourseSectionModel) o;
        return getCategory().equals(that.getCategory()) && getCourseList().equals(that.getCourseList());
    }

    @Override
    public String toString() {
        return "CourseSectionModel{" +
                "Category='" + Category + '\'' +
                ", CourseList=" + CourseList +
                '}';
    }

    public static DiffUtil.ItemCallback<CourseSectionModel> CourseSectionCallBack = new DiffUtil.ItemCallback<CourseSectionModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull CourseSectionModel oldItem, @NonNull CourseSectionModel newItem) {

                    return oldItem.getCategory().equals(newItem.getCategory());
                }

                @Override
                public boolean areContentsTheSame(@NonNull CourseSectionModel oldItem, @NonNull CourseSectionModel newItem) {
                    return oldItem.equals(newItem);
                }
            };



}

