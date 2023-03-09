package com.example.a11gacadmey.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a11gacadmey.interfaces.ResponseCallback;
import com.example.a11gacadmey.models.SessionsModel;
import com.example.a11gacadmey.repo.SessionRepo;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class SessionViewModel extends ViewModel {


    SessionRepo repo = new SessionRepo();



    public LiveData<List<SessionsModel>> getSessions(String CourseId){

        return repo.Sessions(CourseId);

    }



}
