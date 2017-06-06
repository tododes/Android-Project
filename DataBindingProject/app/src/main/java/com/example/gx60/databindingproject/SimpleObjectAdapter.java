package com.example.gx60.databindingproject;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.gx60.databindingproject.databinding.AdapterSimpleProjectBinding;

import java.util.ArrayList;

/**
 * Created by GX60 on 12/05/2017.
 */

public class SimpleObjectAdapter extends RecyclerView.Adapter<SimpleObjectHolder> {
    @Override
    public SimpleObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        AdapterSimpleProjectBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_simple_project, parent, false);
        return new SimpleObjectHolder(binding);
    }

    @Override
    public void onBindViewHolder(SimpleObjectHolder holder, int position) {
        holder.BindConnection(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private ArrayList<SimpleObject> items;

    public SimpleObjectAdapter(ArrayList<SimpleObject> items)
    {
        super();
        this.items = items;
    }
}
