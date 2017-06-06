package com.example.gx60.semiproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by GX60 on 09/03/2017.
 */

public class HighScoreBottomFragment extends Fragment
{
    private TextView[] textViews;
    private int[] textViewID;
    //private UserScore displayedUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.high_score_bottom, container, false);

        textViewID = new int[] {R.id.HighScore_Name, R.id.HighScore_Score, R.id.HighScore_Email};
        textViews = new TextView[textViewID.length];
        for(int i=0;i<textViewID.length;i++)
        {
            textViews[i] = (TextView) view.findViewById(textViewID[i]);
            textViews[i].setText("");
        }

        return view;
    }

    public void SetDisplay(UserScore u)
    {
        //displayedUser = u;
        textViews[0].setText("NAME : " + u.user.name);
        textViews[1].setText("SCORE : " + u.score);
        textViews[2].setText("EMAIL : " + u.user.email);
    }
}
