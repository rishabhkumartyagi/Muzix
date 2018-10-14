package com.maet.rishabhkumartyagi.cloudmu;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class datapage extends AppCompatActivity {

    DatabaseHelper myDb;
    ImageView im1,im2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapage);

        myDb = new DatabaseHelper(this);
        im1 = (ImageView) findViewById(R.id.imageView16);
        im2 = (ImageView) findViewById(R.id.imageView15);

        a();
        b();
    }

    public void a(){
        im2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllDatau();
                        if (res.getCount() == 0) {

                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("USER NAME : " + res.getString(0) + "\n");
                            buffer.append("PASSWORD : " + res.getString(1) + "\n");
                            buffer.append("NAME : " + res.getString(2) + "\n");
                            buffer.append("AGE : " + res.getString(4) + "\n");
                            buffer.append("GENDER : " + res.getString(5) + "\n\n");

                          /*  buffer.append("GENDER : " + res.getString(6) + "\n");
                            buffer.append("TEMPERATURE : " + res.getString(7) + "\n");
                            buffer.append("HUMIDITY : " + res.getString(8) + "\n");
                            buffer.append("WEATHER DESC. : " + res.getString(9) + "\n");
                            buffer.append("SONG NAME : " + res.getString(10) + "\n\n");*/
                        }
                        File root = new File(getFilesDir().getAbsolutePath());
                        File gpxfile = new File(root, "rishabhsamples.txt");
                        try {
                            FileWriter writer = new FileWriter(gpxfile);
                            writer.append(buffer);
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                        }

                        showMessage("Data", buffer.toString());
                    }
                }

        );

    }

    public void b() {
        im1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("USER NAME : "+ res.getString(0)+"\n");
                            buffer.append("TIME : "+ res.getString(1)+"\n");
                            buffer.append("CITY : "+ res.getString(2)+"\n");
                            buffer.append("SONG TYPE : "+ res.getString(3)+"\n");
                            buffer.append("SONG EMOTION : "+ res.getString(4)+"\n");
                            buffer.append("AGE : "+ res.getString(5)+"\n");
                            buffer.append("GENDER : "+ res.getString(6)+"\n");
                            buffer.append("TEMPERATURE : "+ res.getString(7)+"\n");
                            buffer.append("HUMIDITY : "+ res.getString(8)+"\n");
                            buffer.append("SINGER . : "+ res.getString(9)+"\n");
                            buffer.append("SONG NAME : "+ res.getString(10)+"\n\n");
                        }
                        File root = new File(getFilesDir().getAbsolutePath());
                        File gpxfile = new File(root, "rishabhsamples.txt");
                        try {
                            FileWriter writer = new FileWriter(gpxfile);
                            writer.append(buffer);
                            writer.flush();
                            writer.close();
                        }catch(IOException e){}

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );



    }


    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
