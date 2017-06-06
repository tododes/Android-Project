package com.example.gx60.semiproject;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HighScore extends AppCompatActivity {

    private HighScoreDatabase highScoreDB;
    private UserScore[] userScores;
    private String[] scoreNames;
    private ArrayAdapter<String> highScoreAdapter;
    private HighScoreTopFragment topFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        highScoreDB = new HighScoreDatabase(this, "HighScoreDB", new String[] {"NAME", "SCORE", "EMAIL"}, new String[] {"TEXT", "INTEGER", "TEXT"});
        userScores = new UserScore[5];
        scoreNames = new String[5];
        Cursor res = highScoreDB.getAllData();
        if(res.getCount() == 0)
        {
            for(int i=0;i<5;i++)
            {
                highScoreDB.Insert(new UserScore(new User("Computer #" + (i+1), "", "", "Computer"+(i+1)+"@Computer.com"), 100 - 20 * i));
            }
        }
        res = highScoreDB.getAllData();
        String ss = "";
        int i = 0;
        while(res.moveToNext())
        {
            userScores[i] = new UserScore(new User(res.getString(0), "" , "", res.getString(2)), Integer.parseInt(res.getString(1)));
            i++;
        }
        for(int j=0;j<5;j++)
        {
            ss += userScores[j].user.name + "\n";
            ss += userScores[j].score + "\n";
            ss += userScores[j].user.email + "\n";
            ss += "\n=================\n";

            scoreNames[j] = (j+1) + ". " + userScores[j].user.name;
        }
        highScoreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scoreNames);
        topFragment = (HighScoreTopFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_top);
        topFragment.listView.setAdapter(highScoreAdapter);
        topFragment.setScoreDatas(userScores);
        topFragment.SetBottomFragmentReference((HighScoreBottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_bottom));

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("High Score");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
