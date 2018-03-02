package com.wit.android.fikamarket.vendors;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wit.android.fikamarket.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AvailableStockActivity extends AppCompatActivity
{
    List<Stock> stockList = new ArrayList<>();
    RecyclerView recyclerView;
    StockAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_stock);
        new AsyncFetch().execute();
    }

    public class AsyncFetch extends AsyncTask<String, String, String>{

        ProgressDialog pdLoading = new ProgressDialog(AvailableStockActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //will run on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            Connection connection = new Connection();
            return connection.genertateList();
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);

            //this method will be running on UI thread
            pdLoading.dismiss();

            List<Stock> data = new ArrayList<>();
            pdLoading.dismiss();

            try {
                JSONArray jArray = new JSONArray(result);

                //extract data from json and store into array list as class object
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    Stock stock = new Stock();


                    stock.quantity = json_data.getString("quantity");
                    stock.location = json_data.getString("location");
                    stock.preferredPrice = json_data.getString("preferred_price");
                    data.add(stock);

                    //AvailableStockActivity availableStockActivity = new AvailableStockActivity();
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    mAdapter = new StockAdapter(getApplicationContext(), data);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AvailableStockActivity.this));
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(AvailableStockActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
