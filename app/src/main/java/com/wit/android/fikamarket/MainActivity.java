package com.wit.android.fikamarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wit.android.fikamarket.vendors.VendorsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        /*Intent i = new Intent(this, FarmerActivity.class);
        startActivity(i);*/

        Intent i = new Intent(this, VendorsActivity.class);
        startActivity(i);


    }
}
