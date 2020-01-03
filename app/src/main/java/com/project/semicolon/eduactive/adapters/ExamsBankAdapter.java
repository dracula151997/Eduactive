package com.project.semicolon.eduactive.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.databinding.ExamsBankItemBinding;

import java.util.List;

public class ExamsBankAdapter extends RecyclerView.Adapter<ExamsBankAdapter.ViewHolder> {
    private List<ExamsBankEntity> exams;

    public void setExams(List<ExamsBankEntity> exams) {
        this.exams = exams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ExamsBankItemBinding binding = ExamsBankItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setModel(exams.get(position));

    }

    @Override
    public int getItemCount() {
        if (exams == null)
            return 0;
        return exams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ExamsBankItemBinding binding;

        public ViewHolder(@NonNull ExamsBankItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
