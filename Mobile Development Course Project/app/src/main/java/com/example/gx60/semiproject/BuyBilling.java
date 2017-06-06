package com.example.gx60.semiproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class BuyBilling extends AppCompatActivity {

    private TextView IDView;
    private TextView AmountView;
    private TextView PriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_billing);

        IDView = (TextView) findViewById(R.id.IDView);
        AmountView = (TextView) findViewById(R.id.AmountView);
        PriceView = (TextView) findViewById(R.id.PriceView);

        Bundle extras = getIntent().getExtras();
        IDView.setText("ID : " + extras.getString("ID"));
        AmountView.setText("Amount : " + extras.getString("amount"));
        PriceView.setText("Price : " + extras.getString("price"));

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.mCustomToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Billing");
        getSupportActionBar().setIcon(getDrawable(R.mipmap.ic_launcher));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/
    }
}
