package com.example.dynamicalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    List<GitRepos> items=new ArrayList<>();


    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem, parent, false);
        return new RecyclerHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        GitRepos item=items.get(position);
        holder.text.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<GitRepos> items) {
        this.items = items;
    }

    public List<GitRepos> getItems() {
        return items;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder{
        TextView  text;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.recyclerItem);
        }
    }
}
