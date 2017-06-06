package com.example.gx60.semiproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by GX60 on 09/03/2017.
 */

public class HighScoreTopFragment extends Fragment
{
    public ListView listView;
    private HighScoreBottomFragment bottomFragment;
    private UserScore[] scoreDatas;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup v, Bundle savedInstanceState)
    {
        View view = i.inflate(R.layout.high_score_top, v, false);
        listView = (ListView) view.findViewById(R.id.Score_List_View);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String s = adapterView.getItemAtPosition(i).toString();
                bottomFragment.SetDisplay(scoreDatas[i]);
            }
        });
        return view;
    }

    public void setScoreDatas(UserScore[] us) { scoreDatas = us; }
    public void SetBottomFragmentReference(HighScoreBottomFragment h)
    {
        bottomFragment = h;
    }

    /*public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/
}
