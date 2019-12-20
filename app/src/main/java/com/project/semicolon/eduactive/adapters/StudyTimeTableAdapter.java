package com.project.semicolon.eduactive.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.databinding.StudyTimeTableItemBinding;

import java.util.List;

public class StudyTimeTableAdapter extends
        RecyclerView.Adapter<StudyTimeTableAdapter.MyViewHolder> {
    List<StudyTimeTableModel> modelList;

    public void setModelList(List<StudyTimeTableModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        StudyTimeTableItemBinding binding = StudyTimeTableItemBinding
                .inflate(layoutInflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setModel(modelList.get(position));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        StudyTimeTableItemBinding binding;

        public MyViewHolder(@NonNull StudyTimeTableItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
