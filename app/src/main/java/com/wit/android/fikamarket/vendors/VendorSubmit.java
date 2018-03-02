package com.wit.android.fikamarket.vendors;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sheilambadi on 3/2/18.
 */

public class VendorSubmit extends AsyncTask<String, String, String> {
    HttpURLConnection conn;
    URL url = null;
    Context txt;
    String urlName;

    VendorSubmit(Context txt)
    {
        this.txt = txt;
        this.urlName = urlName;
    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params)
    {
        //set the various methods here

        try {
            //url = new URL("http://10.0.2.2:80/wit/register.php");
            //url = new URL("http://10.21.46.92:80/wit/register.php");
            url = new  URL("http://192.168.43.224:80/wit/farmer_post.php");
            //url = new URL(urlName);

        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        }
        try
        {
            // Setup HttpURLConnection class to send and receive data from php and mysql
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // setDoInput and setDoOutput method depict handling of both send and receive
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // Append parameters to URLadb shell
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("quantity", params[0])
                    .appendQueryParameter("location", params[1])
                    .appendQueryParameter("prefered_price", params[2]);
            String query = builder.build().getEncodedQuery();
            //Open connection for sending data
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            conn.connect();


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            String k = e1.toString();
            return k;
        }

        try {

            int response_code = conn.getResponseCode();

            // Check if successful connection made
            if (response_code == HttpURLConnection.HTTP_OK) {

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

            }
            else
            {

                return ("unsuccessful");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "exception";
        }
        finally
        {
            conn.disconnect();
        }
    }

    @Override
    protected void onPostExecute (String result)
    {


    }
}
