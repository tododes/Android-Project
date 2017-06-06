package com.example.gx60.semiproject;

/**
 * Created by GX60 on 09/03/2017.
 */

public class UserScore
{
    public User user;
    public int score;

    public UserScore()
    {
        user = new User("Computer", "Computer", "Computer", "Computer@Computer.com");
    }

    public UserScore(int s)
    {
        user = new User("Computer", "Computer", "Computer", "Computer@Computer.com");
        score = s;
    }


    public UserScore(User u, int s)
    {
        user = u;
        score = s;
    }
}
