package com.example.a11gacadmey.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.databinding.CourseRowBinding;
import com.example.a11gacadmey.interfaces.CourseInterface;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.example.a11gacadmey.viewmodels.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class CourseSectionAdapter extends ListAdapter<CourseSectionModel,CourseSectionAdapter.myViewHolder> {


    CourseInterface courseInterface;


    public CourseSectionAdapter(CourseInterface courseInterface){
        super(CourseSectionModel.CourseSectionCallBack);

        this.courseInterface = courseInterface;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CourseRowBinding binding = CourseRowBinding.inflate(inflater,parent,false);



        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        CourseSectionModel data = getItem(position);
        holder.binding.setCourseInterface(courseInterface);
        holder.binding.setCategory(data.getCategory());

        CourseAdapter c = new CourseAdapter(courseInterface);
        holder.binding.courses.setAdapter(c);

         c.submitList(data.getCourseList());






    }


    class myViewHolder extends RecyclerView.ViewHolder{

        CourseRowBinding binding;

        public myViewHolder(CourseRowBinding binding) {
            super(binding.getRoot());


            this.binding  = binding;

        }
    }


}
