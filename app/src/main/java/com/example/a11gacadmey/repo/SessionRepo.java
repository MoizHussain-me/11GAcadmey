package com.example.a11gacadmey.repo;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a11gacadmey.interfaces.ResponseCallback;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.example.a11gacadmey.models.SessionsModel;
import com.example.a11gacadmey.views.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SessionRepo {


    MutableLiveData<List<SessionsModel>> sessionList ;
    FirebaseFirestore db;


    public void getSessions(String CourseId , ResponseCallback resp){

        sessionList = new MutableLiveData<>();
        db = FirebaseFirestore.getInstance();


        db.collection("Courses")
                .document(CourseId).collection("sessions")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        resp.OnSuccessReplicated(queryDocumentSnapshots);


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        System.out.println(e.getMessage());

                    }
                });







    }




    public LiveData<List<SessionsModel>> Sessions(String CourseId){

        getSessions(CourseId, new ResponseCallback() {
            @Override
            public void OnSuccessReplicated(QuerySnapshot data) {

                ArrayList<SessionsModel> sessions = new ArrayList<>();
                sessions.clear();
                for (DocumentSnapshot ds  :  data.getDocuments()) {


                    sessions.add(new SessionsModel(ds.getId(),ds.get("name").toString() , ds.get("session_url").toString()));

                }


                sessionList.setValue(sessions);





            }
        });


        return sessionList;


    }




}
