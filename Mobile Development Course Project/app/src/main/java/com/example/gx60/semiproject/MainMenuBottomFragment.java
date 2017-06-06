package com.example.gx60.semiproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by GX60 on 09/03/2017.
 */

public class MainMenuBottomFragment extends Fragment
{
    private Button loginButton, signupButton, highScoreButton;
    private MainMenu mainMenu;
    private Intent[] intents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.mainmenu_bottom, container, false);
        loginButton = (Button) v.findViewById(R.id.button_login);
        signupButton = (Button) v.findViewById(R.id.button_signup);
        highScoreButton = (Button) v.findViewById(R.id.button_highscore);

        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents[0]);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents[1]);
            }
        });
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents[2]);
            }
        });*/
        return v;
    }

    public void setMainMenu(MainMenu mm)
    {
        mainMenu = mm;
        mainMenu.SetMainMenuButtonListener(loginButton, 0);
        mainMenu.SetMainMenuButtonListener(signupButton, 1);
        mainMenu.SetMainMenuButtonListener(highScoreButton, 2);
    }
}
