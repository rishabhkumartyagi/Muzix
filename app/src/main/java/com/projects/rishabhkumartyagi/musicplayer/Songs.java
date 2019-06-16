package com.projects.rishabhkumartyagi.musicplayer;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Songs extends AppCompatActivity {


    Context context;



    String[] ListElements = new String[]{};

    ListView listView;

    List<String> ListElementsArrayList;

    ArrayAdapter<String> adapter;

    ContentResolver contentResolver;

    Cursor cursor;

    Uri uri;
    public static final int RUNTIME_PERMISSION_CODE = 7;

    Button button;

    HashMap<String, String> SongD;

    DataBaseHelper db;
    float temperaturebms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        SongD = new HashMap<String, String>();

        listView = (ListView) findViewById(R.id.listView);
        getCpuTemp();

        context = getApplicationContext();

        ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));

        Collections.sort(ListElementsArrayList);

        adapter = new ArrayAdapter<String>
                (Songs.this, android.R.layout.simple_list_item_checked, ListElementsArrayList);

        AndroidRuntimePermission();

        GetAllMediaMp3Files();

        listView.setAdapter(adapter);

        db = new DataBaseHelper(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(Songs.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
                String tempo = db.cEntry(SongD.get(parent.getAdapter().getItem(position).toString()),temperaturebms);
                //Toast.makeText(Songs.this,tempo,Toast.LENGTH_SHORT).show();

                    if(SongD.get(parent.getAdapter().getItem(position).toString()).equals(db.cEntry(SongD.get(parent.getAdapter().getItem(position).toString()),temperaturebms)))
                    {
                        db.EntryUpdate(SongD.get(parent.getAdapter().getItem(position).toString()),temperaturebms);
                    }else
                    {
                        db.SongEntry(SongD.get(parent.getAdapter().getItem(position).toString()),parent.getAdapter().getItem(position).toString(),temperaturebms);
                    }


                String SongMessage = SongD.get(parent.getAdapter().getItem(position).toString());
                Intent intent = new Intent(Songs.this, SongPlay.class);
                intent.putExtra("SongData", SongMessage);
                startActivity(intent);

            }
        });

    }


    public void GetAllMediaMp3Files() {

        contentResolver = context.getContentResolver();

        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String[] STAR={"*"};
        cursor = contentResolver.query(
                uri,
                STAR,
                selection,
                null,
                null
        );

        if (cursor == null) {

            Toast.makeText(Songs.this, "Something Went Wrong.", Toast.LENGTH_SHORT);

        } else if (!cursor.moveToFirst()) {

            Toast.makeText(Songs.this, "No Music Found on5 SD Card.", Toast.LENGTH_SHORT);

        } else {

            int Title = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int Data = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);



            do {

                String SongTitle = cursor.getString(Title);
                String SongData = cursor.getString(Data);

                ListElementsArrayList.add(SongTitle);
                SongD.put(SongTitle , SongData);


            } while (cursor.moveToNext());
        }
    }

    public void AndroidRuntimePermission(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                if(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)){

                    AlertDialog.Builder alert_builder = new AlertDialog.Builder(Songs.this);
                    alert_builder.setMessage("External Storage Permission is Required.");
                    alert_builder.setTitle("Please Grant Permission.");
                    alert_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ActivityCompat.requestPermissions(
                                    Songs.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    RUNTIME_PERMISSION_CODE

                            );
                        }
                    });

                    alert_builder.setNeutralButton("Cancel",null);

                    AlertDialog dialog = alert_builder.create();

                    dialog.show();

                }
                else {

                    ActivityCompat.requestPermissions(
                            Songs.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            RUNTIME_PERMISSION_CODE
                    );
                }
            }else {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case RUNTIME_PERMISSION_CODE: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
            }
        }
    }

    public void getCpuTemp() {
        Process p;
        try {
            p = Runtime.getRuntime().exec("cat sys/class/thermal/thermal_zone0/temp");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();
            temperaturebms = Float.parseFloat(line) / 1000.0f-5;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}













