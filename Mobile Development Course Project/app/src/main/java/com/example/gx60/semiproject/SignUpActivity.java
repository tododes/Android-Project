package com.example.gx60.semiproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private User user;
    private Database db;
    private PictureDatabase pDB;

    private EditText Name, Password, Email;
    private RadioGroup GenderGroup;

    private Button submitButton;
    private CheckBox getNotifBox;
    private CheckBox notRobotBox;

    private Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText) findViewById(R.id.your_name);
        Password = (EditText) findViewById(R.id.your_password);
        Email = (EditText) findViewById(R.id.your_email);

        submitButton = (Button) findViewById(R.id.sign_up);
        GenderGroup = (RadioGroup) findViewById(R.id.Gender_Group);

        getNotifBox = (CheckBox) findViewById(R.id.get_notif);
        notRobotBox = (CheckBox) findViewById(R.id.not_robot);
        loginIntent = new Intent(this, Menu.class);

        db = Database.getDB(this);
        pDB = new PictureDatabase(this, "PictureDB", new String[] {"URI"}, new String[] {"TEXT"});
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                RadioButton rb = (RadioButton) findViewById(GenderGroup.getCheckedRadioButtonId());
                Toast.makeText(SignUpActivity.this, rb.getText(), Toast.LENGTH_LONG).show();
                //db.Clear();
                user = new User(Name.getText().toString(), Password.getText().toString(), rb.getText().toString(), Email.getText().toString(), getNotifBox.isChecked(), notRobotBox.isChecked());
                int x = db.Insert(user);
                String ss = "";
                Cursor cursor = db.getAllData();
                while(cursor.moveToNext())
                {
                    for(int i=0;i<user.attributeNames.length;i++)
                    {
                        ss += user.attributeNames[i] + " : " + cursor.getString(i) + "\n";
                    }
                    ss += "\n===============\n";
                }
                showMessage("Datas", ss);
                startActivity(loginIntent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign up");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
    }

    public void rbclick(View view)
    {
        int rbID = GenderGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(rbID);
        Toast.makeText(this, rb.getText(), Toast.LENGTH_LONG);
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void ViewAllData(Cursor c)
    {
        String datas = "";

        while(c.moveToNext())
        {
            for(int i=0;i<user.attributeNames.length;i++)
            {
                datas += user.attributeNames[i] + " : " + c.getString(i) + "\n";
            }
            datas += "===================\n";
        }
        showMessage("Data", datas);
    }
}
