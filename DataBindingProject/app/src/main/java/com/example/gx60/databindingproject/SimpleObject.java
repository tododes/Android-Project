package com.example.gx60.databindingproject;

/**
 * Created by GX60 on 12/05/2017.
 */

public class SimpleObject
{
    public String name;
    private int age;

    public String getAge(){ return String.valueOf(age); }
    public void setAge(int age) { this.age = age; }
}
