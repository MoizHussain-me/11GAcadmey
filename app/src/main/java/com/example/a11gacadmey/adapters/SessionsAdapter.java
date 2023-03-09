package com.example.a11gacadmey.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a11gacadmey.databinding.SessionRowBinding;
import com.example.a11gacadmey.models.SessionsModel;

public class SessionsAdapter  extends ListAdapter<SessionsModel,SessionsAdapter.myViewHolder> {


    public SessionsAdapter() {
        super(SessionsModel.SessionCallBack);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SessionRowBinding binding = SessionRowBinding.inflate(inflater,parent,false);



        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        SessionsModel model = getItem(position);



        holder.binding.boldHead.setText(model.name);
        holder.binding.normalHead.setText(model.name);


    }

    class myViewHolder extends RecyclerView.ViewHolder{


        SessionRowBinding binding;

        public myViewHolder(SessionRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;



        }
    }


}
