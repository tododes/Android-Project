package com.example.gx60.semiproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Buy extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Bon> objects = new ArrayList<>();
    private BonAdapter bonAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_buy_view);
        for(int i=1;i<=10;i++)
        {
            objects.add(new Bon(i * 10, (i * 10) + (2 * i)));
        }

        bonAdapter = new BonAdapter(objects, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bonAdapter);

        toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        toolbar.setTitle("Buy Credits");
        setSupportActionBar(toolbar);

        //Intent i = new Intent(this, MyService.class);
   /*     bons = new Bon[] { new Bon(10, 12),  new Bon(20, 23), new Bon(30, 34), new Bon(40, 44), new Bon(50, 55), new Bon(60, 65) };
        buyAmounts = new String[bons.length];
        for(int i=0;i<bons.length;i++)
        {
            buyAmounts[i] = "$" + String.valueOf(bons[i].amount);
        }
        //radioGroup = (RadioGroup) findViewById(R.id.geld_group);
        listView = (ListView) findViewById(R.id.moneyListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buyAmounts);
        listView.setAdapter(adapter);

        *//*Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose the amount of money");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*//*

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Buy.this, BuyBilling.class);
                intent.putExtra("ID", String.valueOf(bons[i].ID));
                intent.putExtra("amount", String.valueOf(bons[i].amount));
                intent.putExtra("price", String.valueOf(bons[i].price));
                startActivity(intent);
            }
        });*/
    }
}
