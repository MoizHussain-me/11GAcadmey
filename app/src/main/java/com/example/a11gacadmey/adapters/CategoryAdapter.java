package com.example.a11gacadmey.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11gacadmey.databinding.CategoryRowBinding;
import com.example.a11gacadmey.models.CategoryModel;

import java.net.ProtocolFamily;

public class CategoryAdapter extends ListAdapter<CategoryModel,CategoryAdapter.myViewHolder> {


    public CategoryAdapter() {
        super(CategoryModel.catItemCallBack);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        CategoryRowBinding binding = CategoryRowBinding.inflate(inflater,parent,false);


        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        CategoryModel catModel = getItem(position);

        holder.catBinding.setCategory(catModel);




    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CategoryRowBinding catBinding;

        public myViewHolder(CategoryRowBinding binding) {
            super(binding.getRoot());
            catBinding = binding;

        }
    }




}
