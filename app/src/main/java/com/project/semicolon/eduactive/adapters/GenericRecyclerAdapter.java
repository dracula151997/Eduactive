package com.project.semicolon.eduactive.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.listeners.OnListItemClickListener;

import java.util.List;

public class GenericRecyclerAdapter<T extends ListItemViewModel>
        extends RecyclerView.Adapter<GenericRecyclerAdapter<T>.GenericViewHolder<T>> {
    private List<T> items;
    @LayoutRes
    private int layoutRes;
    private LayoutInflater inflater;
    private OnListItemClickListener onListItemClickListener;

    public GenericRecyclerAdapter(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
        this.onListItemClickListener = onListItemClickListener;
    }

    @NonNull
    @Override
    public GenericViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutRes, parent, false);
        return new GenericViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder<T> holder, int position) {
        T t = items.get(position);
        t.adapterPosition = position;
        t.onListItemClickListener = onListItemClickListener;
        holder.bind(t);


    }

    @Override
    public int getItemCount() {
        if (items == null) return 0;

        return items.size();
    }

    public class GenericViewHolder<T> extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public GenericViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(T t) {
            binding.setVariable(BR.obj, t);
            binding.executePendingBindings();
        }
    }
}
