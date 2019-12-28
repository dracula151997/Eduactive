package com.project.semicolon.eduactive.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.database.entities.NewsEntity;
import com.project.semicolon.eduactive.databinding.NewsListItemBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsEntity> articles;


    public void setNewsList(List<NewsEntity> articles) {
        this.articles = articles;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsListItemBinding binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        NewsEntity article = articles.get(position);
        holder.itemBinding.setNews(article);

    }

    @Override
    public int getItemCount() {
        if (articles == null) return 0;
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public NewsListItemBinding itemBinding;

        public ViewHolder(@NonNull NewsListItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;


        }
    }
}
