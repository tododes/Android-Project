package com.example.gx60.databindingproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gx60.databindingproject.databinding.AdapterSimpleProjectBinding;

/**
 * Created by GX60 on 12/05/2017.
 */

public class SimpleObjectHolder extends RecyclerView.ViewHolder {
    private AdapterSimpleProjectBinding binding;

    public SimpleObjectHolder(AdapterSimpleProjectBinding b)
    {
        super(b.getRoot());
        binding = b;
    }

    public SimpleObjectHolder(View itemView) {
        super(itemView);
    }

    public void BindConnection(SimpleObject simpleobj)
    {
        binding.setSimpleobject(simpleobj);
    }
}
