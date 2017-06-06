package com.example.gx60.semiproject;

/**
 * Created by GX60 on 07/03/2017.
 */

public class User
{
    public String name;
    public String password;
    public String gender;
    public String email;
    public boolean getNotif;
    public boolean notRobot;

    public String[] attributeNames, attributeTypes;


    public User(String n, String pw, String g, String e, boolean gn, boolean nr)
    {
        name = n;
        password = pw;
        gender = g;
        email = e;
        getNotif = gn;
        notRobot = nr;
        attributeNames = new String[]{
            "NAME", "PASSWORD", "GENDER", "EMAIL", "GETNOTIF", "NOTROBOT"
        };

        attributeTypes = new String[]{
                "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"
        };
    }

    public User(String n, String pw, String g, String e)
    {
        name = n;
        password = pw;
        gender = g;
        email = e;
        getNotif = false;
        notRobot = false;
        attributeNames = new String[]{
                "NAME", "PASSWORD", "GENDER", "EMAIL", "GETNOTIF", "NOTROBOT"
        };

        attributeTypes = new String[]{
                "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"
        };
    }

}
