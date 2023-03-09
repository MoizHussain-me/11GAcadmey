package com.example.a11gacadmey.repo;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a11gacadmey.models.CategoryModel;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepo {

    MutableLiveData<List<CategoryModel>> catList;
    FirebaseFirestore db;

   public LiveData<List<CategoryModel>> getCatList(){

        db = FirebaseFirestore.getInstance();
        catList = new MutableLiveData<>();


        ArrayList<CategoryModel> myList = new ArrayList<CategoryModel>();


        db.collection("Categories")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()) {


                            for (QueryDocumentSnapshot ds : task.getResult())
                            {

                                //Log.d("TestingFirebase", "onComplete: "+ds.getId()+","+ds.getData());
                                myList.add(new CategoryModel(ds.getId(),ds.getData().get("Name").toString(),ds.getData().get("image").toString()));

                            }

                            catList.setValue(myList);

                        }


                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {

                        Log.d("Error", "onCanceled: Something went wrong in Categories");


                    }
                });


//        myList.add(new CategoryModel("0","Marketing","https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg"));
//        myList.add(new CategoryModel("1","Development","https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg"));
//        myList.add(new CategoryModel("2","Economics","https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__480.jpg"));
//        myList.add(new CategoryModel("3","Designing","image"));
//        myList.add(new CategoryModel("4","Ecommerce","image"));









        return catList;
    }







}
