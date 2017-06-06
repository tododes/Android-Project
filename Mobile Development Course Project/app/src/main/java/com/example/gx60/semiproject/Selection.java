package com.example.gx60.semiproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {

    protected ViewPager pager;
    protected SwipeAdapter adapter;
    protected Toolbar toolbar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        button = (Button) findViewById(R.id.tocharacterselection);
        pager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new SwipeAdapter(this);
        pager.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.normal_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dungeon Selection");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selection.this, CharacterSelection.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.standard_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            Intent i = new Intent(this, Profile.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
