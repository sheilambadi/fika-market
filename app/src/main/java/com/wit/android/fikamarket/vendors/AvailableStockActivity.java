package com.wit.android.fikamarket.vendors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wit.android.fikamarket.R;

import java.util.ArrayList;
import java.util.List;

public class AvailableStockActivity extends AppCompatActivity {
    List<Stock> stockList = new ArrayList<>();
    RecyclerView recyclerView;
    StockAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_stock);
        Stock one = new Stock();
        one.quantity = "180kg";
        one.location="Nairobi";
        one.preferredPrice="Kshs. 20000";
        Stock two = new Stock();
        two.quantity = "500kg";
        two.location="Migori";
        two.preferredPrice="Kshs. 40000";
        stockList.add(one);
        stockList.add(two);
        stockList.add(one);
        stockList.add(two);
        stockList.add(one);
        stockList.add(two);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new StockAdapter(getApplicationContext(), stockList);
        recyclerView.setAdapter(mAdapter);
    }
}
