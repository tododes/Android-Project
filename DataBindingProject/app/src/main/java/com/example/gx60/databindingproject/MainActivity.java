package com.example.gx60.databindingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rView);
        ArrayList<SimpleObject> objects = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            SimpleObject so = new SimpleObject();
            so.name = "Person #"+(i+1);
            so.setAge(i * 2);
            objects.add(so);
        }

        SimpleObjectAdapter adapter = new SimpleObjectAdapter(objects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
