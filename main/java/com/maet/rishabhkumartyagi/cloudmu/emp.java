package com.maet.rishabhkumartyagi.cloudmu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class emp extends AppCompatActivity {

    EditText e1,e2;
    Button b;
    globalVar g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);

        e1 = (EditText) findViewById(R.id.editText4);
        e2 = (EditText) findViewById(R.id.editText5);
        b = (Button) findViewById(R.id.button2);
        g = new globalVar();

        a();
    }

    public void a() {
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            g.putSec(Integer.parseInt(e1.getText().toString()), Integer.parseInt(e2.getText().toString()));
                        }catch(Exception e){}
                    }
                }
        );
    }
}
