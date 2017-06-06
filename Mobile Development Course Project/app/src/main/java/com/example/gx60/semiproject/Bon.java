package com.example.gx60.semiproject;

/**
 * Created by GX60 on 23/03/2017.
 */
import java.util.Random;

public class Bon
{
    public int ID;
    public int amount;
    public int price;

    public String amountStr;
    public String priceStr;

    public Bon()
    {

    }

    public Bon(int a, int p)
    {
        Random rand = new Random();
        ID = rand.nextInt(10000) + 1;
        amount = a;
        price = p;

        amountStr = String.valueOf(a) + " credits";
        priceStr = "for $"+String.valueOf(p);
    }
}
