package com.example.kwesi.totaap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kwesi on 3/14/2018.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoHolder> {

    ArrayList<ToDoItem> itemList;
    RecyclerView recyclerView;


    ToDoAdapter(ToDoItem[] items,RecyclerView recyclerView){
        ArrayList<ToDoItem> itemList = new ArrayList<ToDoItem>(items.length);
        this.itemList = itemList;
        this.recyclerView = recyclerView;
        for(int i = 0;i < items.length;i++){
            this.itemList.add(items[i]);
        }
    }

    public void add(ToDoItem[] items){
        for(int i = 0;i < items.length;i++){
            itemList.add(items[i]);
        }

        this.notifyDataSetChanged();
    }

    public void remove(int[] indices){
        for(int i = 0;i < indices.length;i++){
            itemList.remove(indices[i]);
            recyclerView.removeViewAt(indices[i]);
        }
        this.notifyDataSetChanged();
    }

    @Override
    public ToDoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.to_do_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId,parent,false);
        return new ToDoHolder(view);

    }

    @Override
    public void onBindViewHolder(ToDoHolder holder, int position) {
        holder.textView.setText(itemList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class ToDoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public ToDoHolder(View view){
            super(view);
            this.textView = view.findViewById(R.id.to_do_item );
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            
        }
    }

}