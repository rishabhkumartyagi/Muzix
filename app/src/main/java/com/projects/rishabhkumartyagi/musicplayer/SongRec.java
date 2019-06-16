package com.projects.rishabhkumartyagi.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SongRec extends AppCompatActivity  {

    TextView tempCon;
    ListView lv;
    float temperaturebms;
    ArrayList<String> sugList;
    ArrayAdapter<String> adapter;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_rec);
        tempCon = (TextView)findViewById(R.id.textView6);
        lv  = (ListView)findViewById(R.id.listView2);
        getCpuTemp();

        if (temperaturebms <= 19.0)
        {
            tempCon.setText("It's Cold");
        }else if(temperaturebms>19.0&&temperaturebms<=29.0)
        {
            tempCon.setText("Temperature is Pleasent");        }else
        {
            tempCon.setText("It's Hot");        }

        db= new DataBaseHelper(this);

        sugList = db.getRec(temperaturebms);

        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_selectable_list_item, sugList);

        lv.setAdapter(adapter);
    }

    public void getCpuTemp() {
        Process p;
        try {
            p = Runtime.getRuntime().exec("cat sys/class/thermal/thermal_zone0/temp");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();
            temperaturebms = Float.parseFloat(line) / 1000.0f-5;

            tempCon.setText("Temperature: "+Float.toString(temperaturebms)+"C");

        } catch (Exception e) {
            e.printStackTrace();
            tempCon.setText("Exception ! ");
        }
    }

}
