package com.example.android.recyclercards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
    //6.2
    private ArrayList<ItemsList> mItemsLists;

    //1
    public static class ItemsViewHolder extends RecyclerView.ViewHolder{

        //4
        public static ImageView imageView;
        public static TextView textView;

        //2
        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }

    //6.1
    public ItemsAdapter(ArrayList<ItemsList> itemsLists){
        mItemsLists = itemsLists;
    }

    //3
    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        ItemsViewHolder itemsViewHolder = new ItemsViewHolder(view);
        return itemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        //7
        ItemsList currentItem = mItemsLists.get(position);
        ItemsViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        ItemsViewHolder.textView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mItemsLists.size();
    }

}
