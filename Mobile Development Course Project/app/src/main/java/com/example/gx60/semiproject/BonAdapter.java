package com.example.gx60.semiproject;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gx60.semiproject.databinding.AdapterBonBinding;

import java.util.ArrayList;

/**
 * Created by GX60 on 16/05/2017.
 */

public class BonAdapter extends RecyclerView.Adapter<BonHolder> {

    private ArrayList<Bon> items;
    private Context context;
    @Override
    public BonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterBonBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_bon, parent, false);
        return new BonHolder(binding);
    }

    @Override
    public void onBindViewHolder(BonHolder holder, final int position) {
        holder.Bind(items.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println(position);
                //Bon selectedBon = items.get(position);
                //Toast.makeText(context, "Hello " + position, Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, BuyBilling.class);
              /*  System.out.println(items.get(position).ID);
                System.out.println(items.get(position).amount);
                System.out.println(items.get(position).price);*/
                if(items.get(position).equals(null)){
                    Toast.makeText(context, "Null object", Toast.LENGTH_LONG).show();
                }
                else{
                    i.putExtra("ID", Integer.toString(items.get(position).ID));
                    i.putExtra("amount", Integer.toString(items.get(position).amount));
                    i.putExtra("price", Integer.toString(items.get(position).price));
                    context.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public BonAdapter(ArrayList<Bon> it, Context c){
        items = it;
        context = c;
    }
}
