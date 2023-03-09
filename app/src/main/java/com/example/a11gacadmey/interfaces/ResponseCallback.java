package com.example.a11gacadmey.interfaces;

import com.example.a11gacadmey.models.CourseModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public interface ResponseCallback {

    public void OnSuccessReplicated(QuerySnapshot data);



}
