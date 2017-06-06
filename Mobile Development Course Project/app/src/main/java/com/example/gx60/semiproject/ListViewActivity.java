package com.example.gx60.semiproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private ListView view;
    private String[] lists;
    private CustomAdapter allLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        view = (ListView) findViewById(R.id.my_listview);
        lists = new String[]{"AA", "BB", "CC", "DD", "EE"};
        allLists = new CustomAdapter(this, lists);
        view.setAdapter(allLists);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String display = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(ListViewActivity.this, display, Toast.LENGTH_LONG).show();
            }
        });
    }
}
