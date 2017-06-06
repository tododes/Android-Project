package com.example.gx60.semiproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.gx60.semiproject.databinding.AdapterBonBinding;

//import com.example.gx60.semiproject.databinding.AdapterSimpleProjectBinding;

/**
 * Created by GX60 on 16/05/2017.
 */

public class BonHolder extends RecyclerView.ViewHolder {

    private AdapterBonBinding binding;
    public Button button;

    public BonHolder(View itemView) {
        super(itemView);

    }

    public BonHolder(AdapterBonBinding b){
        super(b.getRoot());
        button = (Button) b.getRoot().findViewById(R.id.buycredits_button);
        binding = b;
    }

    public void Bind(Bon b){
        binding.setMyBon(b);
    }
}
