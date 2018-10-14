package com.maet.rishabhkumartyagi.cloudmu;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class recom extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    Cursor rc,hc,cc;
    EditText t3;
    Button bt;
    TextView tv;


    String[] paths = {"Sunny", "Cloudy", "Rainy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recom);



         bt = (Button) findViewById(R.id.button);
         tv = (TextView) findViewById(R.id.textView2);
         t3 = (EditText) findViewById(R.id.editText3);


        tv.setText("");

        a();

    }

    public void a(){
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String tem = "h" ;
                        try {

                            tem = (t3.getText().toString());
                        }catch(NumberFormatException e){}

                        if(tem.matches("h")) {
                            int i = 0;
                            hc = db.getHOTSongCount();
                            StringBuffer buffer = new StringBuffer();
                            while (hc.moveToNext()) {
                                i = i + 1;
                                buffer.append(i + ") " +" count : "+hc.getString(0) +"      "+ hc.getString(1)+ "\n");
                            }
                            tv.setText(buffer);
                        }else  if(tem.matches("c")) {
                            int i = 0;
                            cc = db.getCOLDSongCount();
                            StringBuffer buffer = new StringBuffer();
                            while (cc.moveToNext()) {
                                i = i + 1;
                                buffer.append(i + ") " +" count : "+cc.getString(0) +"      "+ cc.getString(1)+ "\n");
                                tv.setText(buffer);
                            }
                        }
                    }
                }

        );
    }


}
