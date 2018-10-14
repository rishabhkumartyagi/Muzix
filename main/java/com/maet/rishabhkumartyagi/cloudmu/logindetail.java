package com.maet.rishabhkumartyagi.cloudmu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class logindetail extends AppCompatActivity {

    EditText usrnm,pasw,name,age,gender;
    ImageView go,im;
    DatabaseHelper myDb;
    Intent intent23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindetail);

        usrnm=(EditText) findViewById(R.id.editText8);
        pasw=(EditText) findViewById(R.id.editText9);
        name=(EditText) findViewById(R.id.editText10);
        age=(EditText) findViewById(R.id.editText11);
        gender=(EditText) findViewById(R.id.editText12);
        go=(ImageView) findViewById(R.id.imageView6);
        im = (ImageView) findViewById(R.id.imageView5);
        intent23 = new Intent(logindetail.this, emp.class);

        myDb = new DatabaseHelper(this);

        logino();
        b();

    }
    protected  void logino(){


        go.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int num;
                        try{
                            num=Integer.parseInt(age.getText().toString());
                        }catch(NumberFormatException e){num=0;}
                       // Toast.makeText(logindetail.this,usrnm.getText().toString()+pasw.getText().toString()+name.getText().toString()+num+gender.getText().toString(),Toast.LENGTH_LONG).show();
                       int[] lr= (myDb.newUser(usrnm.getText().toString(),pasw.getText().toString(),name.getText().toString(),num,gender.getText().toString()));

                        int sum =lr[0]+lr[1]+lr[2]+lr[3];

                        if(sum==0)
                        {
                            Toast.makeText(logindetail.this,"New User added",Toast.LENGTH_LONG).show();
                        }
                        else {
                            String war="User could not be added !!!";
                            if(lr[0]==1){
                                war= war+"\n\tUsername already exist";
                            }
                            if(lr[1]==1){
                                war= war+"\n\tInvalid integer";
                            }
                            if(lr[2]==1){
                                war=war+"\n\tEmpty username";
                            }
                            if(lr[3]==1){
                                war= war+"\n\tEmpty password";
                            }
                            Toast.makeText(logindetail.this,war,Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


    }


    public void b() {
        im.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(intent23);
                    }
                }
        );
    }
}
