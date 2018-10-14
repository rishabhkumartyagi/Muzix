package com.maet.rishabhkumartyagi.cloudmu;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class loginpage extends ActionBarActivity {

    Intent intent;
    Intent intent2;
    Intent intent3,intent4;
    DatabaseHelper myDb;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        image1 = (ImageView) findViewById(R.id.imageView3);
        image2 = (ImageView) findViewById(R.id.imageView7);
        image3 = (ImageView) findViewById(R.id.imageView4);
        image4 = (ImageView) findViewById(R.id.imageView17);
        myDb = new DatabaseHelper(this);
        intent2 = new Intent(loginpage.this, logindetail.class);
        intent = new Intent(loginpage.this, UserlogActivity.class);
        intent3 = new Intent(loginpage.this, recom.class);
        intent4 = new Intent(loginpage.this, datapage.class);


        a();
        b();
        c();
        e();

    }

    public void a(){
        image1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            startActivity(intent);
                        }catch(Exception e){}
                    }
                }

        );
    }


  public void b(){
        image2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent4);
                    }
                }

        );

    }

    public void e(){

        image4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            startActivity(intent3);
                        }catch(Exception e){}
                    }
                }

        );
    }



    public void c(){

        image3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            startActivity(intent2);
                        }catch(Exception e){}
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