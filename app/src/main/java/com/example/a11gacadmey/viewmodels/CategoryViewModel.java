package com.example.a11gacadmey.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a11gacadmey.models.CategoryModel;
import com.example.a11gacadmey.repo.CategoryRepo;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    CategoryRepo repo = new CategoryRepo();


    public  LiveData<List<CategoryModel>> getCatList(){

        return repo.getCatList();

    }





}
