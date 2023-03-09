package com.example.a11gacadmey.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.databinding.CourseBoxBinding;
import com.example.a11gacadmey.interfaces.CourseInterface;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;

import java.util.ArrayList;

public class CourseAdapter extends ListAdapter<CourseModel,CourseAdapter.myViewHolder> {

    CourseInterface courseInterface;

    public CourseAdapter(CourseInterface courseInterface) {
        super(CourseModel.CourseCallBack);
    this.courseInterface = courseInterface;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CourseBoxBinding binding = CourseBoxBinding.inflate(inflater,parent,false);


        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        CourseModel c = getItem(position);

        holder.courseBoxBinding.setCourse(c);
        holder.courseBoxBinding.setCourseDetail(courseInterface);



    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        CourseBoxBinding courseBoxBinding;

        public myViewHolder(CourseBoxBinding binding) {
            super(binding.getRoot());
            courseBoxBinding = binding;
        }
    }
}
