package com.example.gx60.semiproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText nameText, passwordText;
    private Button loginButton;
    private Database db;
    private User user;
    private Intent loginIntent;

    public Button getLoginButton(){
        return loginButton;
    }

    public Database getDB(){ return db; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        nameText = (EditText) findViewById(R.id.Name);
        passwordText = (EditText) findViewById(R.id.Password);

        loginButton = (Button) findViewById(R.id.login);
        loginIntent = new Intent(this, Menu.class);
/*

        Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("login");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

*/

        user = new User("", "", "", "");

        String ss = "";
        db = Database.getDB(this);
       /* Cursor c = db.getAllData();
        while(c.moveToNext())
        {
            for(int i=0;i<user.attributeNames.length;i++)
            {
                ss += user.attributeNames[i] + " : " + c.getString(i) + "\n";
            }
            ss += "\n===============\n";
        }
        showMessage("Datas", ss);*/


        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Cursor cursor = db.getQuery("SELECT * FROM UserDB WHERE NAME = " + "'" + nameText.getText().toString() + "'" + " AND PASSWORD = " + "'" + passwordText.getText().toString()+ "'");
                if(cursor.getCount() == 0)
                {
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                    return;
                }

                else
                {
                    String ss = "";
                    while(cursor.moveToNext())
                    {
                        for(int i=0;i<user.attributeNames.length;i++)
                        {
                            ss += user.attributeNames[i] + " : " + cursor.getString(i) + "\n";
                        }
                        ss += "\n===============\n";
                    }
                    showMessage("Datas", ss);
                }
                Intent service = new Intent(LoginActivity.this, MyService.class);
                startService(service);
                startActivity(loginIntent);
            }
        });
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
