package com.example.a11gacadmey.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.example.a11gacadmey.repo.CourseSectionRepo;

import java.util.List;

public class CourseViewModel extends ViewModel {

    CourseSectionRepo repo = new CourseSectionRepo();

    String category;
    CourseModel courseModel;

    public CourseModel getCourseModel() {
        return courseModel;
    }

    public void setCourseModel(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public LiveData<List<CourseModel>> getAllCoursesByTrainer(String trainerId)
    {
        return  repo.getCoursesByTrainer(trainerId);

    }




    public LiveData<List<CourseModel>> getAllCourses(){

        return repo.getAllCourses();
    }


    public LiveData<List<CourseSectionModel>> getCourseSection(){


        return repo.getCourseSection();

    }






}
