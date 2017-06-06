package com.example.gx60.semiproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    private ImageView imageView;
    private Button playButton, buyButton, highscoreButton, findFriendButton, signoutButton;
    private Toolbar toolbar;

    private Intent ProfileIntent;
    private String CurrentProfileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageView = (ImageView) findViewById(R.id.PPView);

        toolbar = (Toolbar) findViewById(R.id.normal_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu");

        ProfileIntent = new Intent(this, Profile.class);
        String ss = ProfileIntent.getStringExtra("ProfileURI");

        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Menu.this, Selection.class);
                startActivity(intent);
            }
        });

        buyButton = (Button) findViewById(R.id.buycredits_button);
        buyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Menu.this, Buy.class);
                startActivity(intent);
            }
        });

        highscoreButton = (Button) findViewById(R.id.highscore_button);
        highscoreButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Menu.this, HighScore.class);
                startActivity(intent);
            }
        });

        findFriendButton = (Button) findViewById(R.id.findfriend_button);
        findFriendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Menu.this, SearchFriend.class);
                startActivity(intent);
            }
        });

        signoutButton = (Button) findViewById(R.id.signout_button);
        signoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent service = new Intent(Menu.this, MyService.class);
                stopService(service);

                Intent intent = new Intent(Menu.this, MainMenu.class);
                startActivity(intent);
            }
        });

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
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
            ProfileIntent.putExtra("CurrentProfileURI", CurrentProfileUri);
            startActivityForResult(ProfileIntent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            CurrentProfileUri = data.getStringExtra("ProfileURI");
           // System.out.println("STR : " + s);
            imageView.setImageURI(Uri.parse(CurrentProfileUri));
        }

    }
}
