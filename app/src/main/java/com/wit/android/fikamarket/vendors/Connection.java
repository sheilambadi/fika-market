package com.wit.android.fikamarket.vendors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by sheilambadi on 3/1/18.
 */

public class Connection{
    HttpURLConnection conn;
    URL url;
    Context context;
    RecyclerView recyclerView;
    StockAdapter stockAdapter;

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    public  String genertateList(){
        try{
            url = new URL("http://192.168.43.224:80/wit/farmer_stock.php");
        }catch(MalformedURLException e){
            e.printStackTrace();
            return  e.toString();
        }

        //read the data
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
        } catch (ProtocolException e) {
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return  e.toString();
        }

        //check the response
        try {
            int responseCode = conn.getResponseCode();

            //check if connection is successful
            if(responseCode == HttpURLConnection.HTTP_OK){
                //read data sent from server
                // Read data sent from server
                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                // Pass data to onPostExecute method
                return (result.toString());
            } else {
                return ("unsuccessful");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        } finally {
            conn.disconnect();
        }
    }
}
