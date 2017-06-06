package com.example.gx60.semiproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class CharacterSelection extends Selection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        pager = (ViewPager) findViewById(R.id.view_pager);
        toolbar = (Toolbar) findViewById(R.id.normal_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Character Selection");

        adapter = new SwipeAdapter(this);
        adapter.setResources(new int[] { R.drawable.grant, R.drawable.trevor, R.drawable.lucy });
        pager.setAdapter(adapter);

    }
}
