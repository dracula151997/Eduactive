package com.project.semicolon.eduactive.adapters;

import androidx.room.Ignore;

import com.project.semicolon.eduactive.listeners.OnListItemClickListener;

public abstract class ListItemViewModel {
    @Ignore
    public int adapterPosition = -1;
    @Ignore
    public OnListItemClickListener onListItemClickListener = null;
}
