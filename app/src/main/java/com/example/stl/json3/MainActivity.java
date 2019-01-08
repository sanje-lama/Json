package com.example.stl.json3;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String  TAG = "Json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("consumer_activity", new JSONArray()
                    .put(new JSONObject()
                            .put("summary", 2016-05-15)
                            .put("make", "Honda")
                            .put("model", "Accord")
                            .put("year", 2015)
                            .put("zipCode", 19482)
                            .put("SRPCount", 1576)
                            .put("VDPCount", 0))
                    .put(new JSONObject()
                            .put("summary", 2016-05-16 )
                            .put("make", "Honda")
                            .put("model", "Accord")
                            .put("year",2015)
                            .put("zipCode", 19428)
                            .put("SRPCount", 1575)
                            .put("VDPCount", 0))
                    .put(new JSONObject()
                            .put("summary", 2016-05-17)
                            .put("make", "Honda")
                            .put("model", "Accord")
                            .put("zipCode", 19428)
                            .put("SRPCount", 2111)
                            .put("VDPCount", 4)));
            } catch (JSONException e) {
            e.printStackTrace();


            String jsonString = jsonObject.toString();


        }

        Log.d(TAG, "onCreate: " + toString());

        try {
            JSONObject oldJsonWeAreParsing = new JSONObject(String.valueOf(jsonObject));

            JSONArray consumerActivityJsonArray = oldJsonWeAreParsing.getJSONArray("consumer_activity");

            List<ConsumerActivity> consumerActivityList = new ArrayList<>();

            for (int i = 0; i < consumerActivityJsonArray.length(); i++) {
                ConsumerActivity consumer = new ConsumerActivity();
                consumer.setSummary((Integer) consumerActivityJsonArray.getJSONObject(i).get("summary"));
                consumer.setMake((String) consumerActivityJsonArray.getJSONObject(i).get("make"));
                consumer.setModel((String) consumerActivityJsonArray.getJSONObject(i).get("model"));
                consumer.setZipcode((Integer)consumerActivityJsonArray.getJSONObject(i).get("zipCode"));
                consumer.setSRPCount((Integer) consumerActivityJsonArray.getJSONObject(i).get("SRPCount"));
                consumer.setVDPCount((Integer) consumerActivityJsonArray.getJSONObject(i).get("VDPCount"));
                consumerActivityList.add(consumer);

                for (ConsumerActivity ca : consumerActivityList) {
                    Log.d(TAG, "onCreate: " + "\nSummary - " + ca.getSummary() +
                                                    "\nMake - " + ca.getMake() +
                                                    "\nModel - " + ca.getModel() +
                                                    "\nZipcode - " + ca.getZipcode() +
                                                    "\nSRPCount - " + ca.getSRPCount() +
                                                    "\nVDPCount - " + ca.getVDPCount());

                }
            }


        } catch (JSONException e) {
            e.printStackTrace();

        }


    }
}
