package com.wit.android.fikamarket.vendors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wit.android.fikamarket.R;

import java.util.concurrent.ExecutionException;

public class VendorOrderAvtivity extends AppCompatActivity {
    EditText quantity, location, price;
    VendorSubmit taskSubmit = new VendorSubmit(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_made);
    }

    public void submit(View view) {
        quantity = (EditText)findViewById(R.id.etQuantity);
        location = (EditText)findViewById(R.id.etLocation);
        price = (EditText)findViewById(R.id.etPrice);

        final String sQuantity = quantity.getText().toString();
        final String sLocation = location.getText().toString();
        final String sPrice = price.getText().toString();

        taskSubmit.execute(sQuantity,sLocation,sPrice);
        String rslt="";
        try {
            rslt=taskSubmit.get().toString();
            Toast.makeText(this, rslt, Toast.LENGTH_LONG).show();

        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
