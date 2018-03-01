package com.wit.android.fikamarket.vendors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wit.android.fikamarket.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by sheilambadi on 3/1/18.
 */

public class StockAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    Stock stock;
    List<Stock> data = Collections.emptyList();

    public StockAdapter(Context context, List<Stock> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyHolder myHolder = (MyHolder) holder;
        final Stock stock = data.get(position);
        myHolder.quantity.setText(stock.quantity);
        myHolder.location.setText(stock.location);
        myHolder.preferredPrice.setText(stock.preferredPrice);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView quantity;
        TextView location;
        TextView preferredPrice;

        //constructor to get widget reference
        public MyHolder(View itemView){
            super(itemView);

            quantity = (TextView) itemView.findViewById(R.id.tvQuantity);
            location = (TextView) itemView.findViewById(R.id.tvLocation);
            preferredPrice = (TextView) itemView.findViewById(R.id.tvPreferredPrice);
        }

    }
}
