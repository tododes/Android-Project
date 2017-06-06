package com.example.gx60.semiproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private MainMenuBottomFragment bottomFragment;
    private String[] menuStrings;
    private Intent[] intents;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        menuStrings = new String[] { "Log In", "Sign Up", "Quit" };
        intents = new Intent[] { new Intent(this, LoginActivity.class), new Intent(this, SignUpActivity.class), new Intent(this, HighScore.class) };
        bottomFragment = (MainMenuBottomFragment) getSupportFragmentManager().findFragmentById(R.id.mainmenu_bottom);
        bottomFragment.setMainMenu(this);
        db = Database.getDB(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.mainmenu_string);
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void SetMainMenuButtonListener(Button button, final int index)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < 3)
                    startActivity(intents[index]);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}


