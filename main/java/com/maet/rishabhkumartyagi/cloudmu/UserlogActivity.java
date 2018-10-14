package com.maet.rishabhkumartyagi.cloudmu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UserlogActivity extends ActionBarActivity {

    Intent intent;
    DatabaseHelper myDb;
    ImageView loginlogo;
    EditText usrnm;
    EditText paswr;
    globalVar g = new globalVar();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlog);

        myDb = new DatabaseHelper(this);
        usrnm=(EditText) findViewById(R.id.editText);
        paswr=(EditText) findViewById(R.id.editText2);
        loginlogo=(ImageView) findViewById(R.id.imageView);
        intent = new Intent(UserlogActivity.this,MainActivity.class);


        logsub();

    }

    protected void logsub() {
            loginlogo.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                loginfn(usrnm.getText().toString(),paswr.getText().toString());
                            }catch(Exception e){}
                        }
                    }

            );
        }


    protected void loginfn(String un,String pw){
        if(myDb.pass(un,pw))
        {
             g.putCusr(un);
            Toast.makeText(UserlogActivity.this,g.getCusr(),Toast.LENGTH_LONG).show();
          /*  if(insrtst==false)
                Toast.makeText(UserlogActivity.this,"User can't be updated",Toast.LENGTH_LONG).show();*/
            startActivity(intent);
        }
        else
        {
            Toast.makeText(UserlogActivity.this,"Invalid Credentials!!!",Toast.LENGTH_LONG).show();
        }
    }
}
