package com.example.a11gacadmey.repo;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.a11gacadmey.interfaces.ResponseCallback;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class CourseSectionRepo {

    MutableLiveData<List<CourseSectionModel>>
    courseSectionLiveData;
    ArrayList<CourseModel> Dev  = new ArrayList<>();
    MutableLiveData<List<CourseModel>> AllCourseLiveData ;

    MutableLiveData<List<CourseModel>> AllCourseByTrainer ;
    FirebaseFirestore db;

    public void getCoursesByCategory(String catID , ResponseCallback resp){

        db = FirebaseFirestore.getInstance();


        DocumentReference reference = db.collection("Categories").document(catID);




        db.collection("Courses").whereEqualTo("category", reference).get()
                .addOnSuccessListener(
                        new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                    resp.OnSuccessReplicated(queryDocumentSnapshots);

   }
                });


    }






    private void getCoursesByTrainer(String trainerID , ResponseCallback resp){

        db = FirebaseFirestore.getInstance();


        DocumentReference reference = db.collection("Trainers").document(trainerID);




        db.collection("Courses").whereEqualTo("trainer", reference).get()
                .addOnSuccessListener(
                        new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                                resp.OnSuccessReplicated(queryDocumentSnapshots);

                            }
                        });


    }


    public MutableLiveData<List<CourseModel>> getCoursesByTrainer(String trainerId){

        AllCourseByTrainer = new MutableLiveData<>();

        getCoursesByTrainer(trainerId, new ResponseCallback() {
            @Override
            public void OnSuccessReplicated(QuerySnapshot data) {

                ArrayList<CourseModel> temp = new ArrayList<>();


                for (DocumentSnapshot ds  :  data.getDocuments()) {

                        temp.add(new CourseModel(ds.getId(),ds.toObject(CourseModel.class)));

                }


                AllCourseByTrainer.setValue(temp);


                }
        });

        return  AllCourseByTrainer;

    }






    public MutableLiveData<List<CourseModel>> getAllCourses(){

      db = FirebaseFirestore.getInstance();
      AllCourseLiveData = new MutableLiveData<>();


      db.collection("Courses").get()
              .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                  @Override
                  public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                      for (DocumentSnapshot ds  :  queryDocumentSnapshots.getDocuments()) {



                          Dev.add(new CourseModel(ds.getId(),ds.toObject(CourseModel.class)));

                      }

                      AllCourseLiveData.setValue(Dev);



                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {

                  }
              });



       return AllCourseLiveData;


    }


   public MutableLiveData<List<CourseSectionModel>> getCourseSection(){
       db = FirebaseFirestore.getInstance();
       courseSectionLiveData = new MutableLiveData<>();
       ArrayList<CourseSectionModel> data1 = new ArrayList<CourseSectionModel>();

       db.collection("Categories").get()
               .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                   @Override
                   public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                       for(DocumentSnapshot ds : queryDocumentSnapshots.getDocuments())
                       {

                           getCoursesByCategory(ds.getId(), new ResponseCallback() {
                               @Override
                               public void OnSuccessReplicated(QuerySnapshot data) {

                                   ArrayList<CourseModel> coursesList= new ArrayList<>();

                                   for (DocumentSnapshot ds  :  data.getDocuments()) {


                                       coursesList.add(new CourseModel(ds.getId(),ds.toObject(CourseModel.class)));

                                   }


                                   data1.add(new CourseSectionModel(ds.getData().get("Name").toString(), coursesList));

                                   courseSectionLiveData.setValue(data1);

                               }
                           });





                       }


                   }
               }).addOnCanceledListener(new OnCanceledListener() {
                   @Override
                   public void onCanceled() {
                       Log.d("SIZE", "onFailure: "+"Get Category failed");
                   }
               });
        return courseSectionLiveData;
    }




}
