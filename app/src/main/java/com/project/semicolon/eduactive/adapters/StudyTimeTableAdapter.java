package com.project.semicolon.eduactive.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.databinding.StudyTimeTableItemBinding;
import com.project.semicolon.eduactive.utils.AppHelper;
import com.project.semicolon.eduactive.utils.ViewAnimation;

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final StudyTimeTableModel model = modelList.get(position);
        holder.binding.setModel(model);
        holder.binding.btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean show = toggleExpandLayout(!model.expanded, view, holder.binding.expandLayout);
                modelList.get(position).expanded = show;
            }
        });

        if (model.expanded) {
            holder.binding.expandLayout.setVisibility(View.VISIBLE);
        } else {
            holder.binding.expandLayout.setVisibility(View.GONE);
        }

        AppHelper.toggleArrow(model.expanded, holder.binding.btnExpand, false);

    }

    private boolean toggleExpandLayout(boolean show, View view, RelativeLayout expandLayout) {
        AppHelper.toggleArrow(show, view);
        if (show) {
            ViewAnimation.expand(expandLayout);
        } else {
            ViewAnimation.collapse(expandLayout);
        }

        return show;

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
