package com.example.a11gacadmey.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11gacadmey.databinding.CatBoxBinding;
import com.example.a11gacadmey.databinding.CategoryRowBinding;
import com.example.a11gacadmey.models.CategoryModel;

public class CategoryAdapterHome extends ListAdapter<CategoryModel, CategoryAdapterHome.myViewHolder> {


    public CategoryAdapterHome() {
        super(CategoryModel.catItemCallBack);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        CatBoxBinding binding = CatBoxBinding.inflate(inflater,parent,false);


        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        CategoryModel catModel = getItem(position);

        holder.catBinding.setCategory(catModel);




    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CatBoxBinding catBinding;

        public myViewHolder(CatBoxBinding binding) {
            super(binding.getRoot());
            catBinding = binding;

        }
    }




}
