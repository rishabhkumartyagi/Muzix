package com.maet.rishabhkumartyagi.cloudmu;


import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    DatabaseHelper myDb;
    ImageView s1,s2,s3,s4,s5,s6,s7,s8;

    globalVar g = new globalVar();
    MediaPlayer mdp1,mdp2,mdp3,mdp4,mdp5,mdp6;

    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        s1 = (ImageView) findViewById(R.id.imageView9);
        s2 = (ImageView) findViewById(R.id.imageView10);
        s3 = (ImageView) findViewById(R.id.imageView11);
        s4 = (ImageView) findViewById(R.id.imageView12);
        s5 = (ImageView) findViewById(R.id.imageView13);
        s6 = (ImageView) findViewById(R.id.imageView14);
        s7 = (ImageView) findViewById(R.id.imageView8);
        //s8 = (ImageView) findViewById(R.id.imageView18);
        mdp1 = MediaPlayer.create(getApplicationContext(), R.raw.despacito);
        mdp2 = MediaPlayer.create(getApplicationContext(), R.raw.shape);
        mdp3 = MediaPlayer.create(getApplicationContext(), R.raw.cheapt);
        mdp4 = MediaPlayer.create(getApplicationContext(), R.raw.seeyouagain);
        mdp5 = MediaPlayer.create(getApplicationContext(), R.raw.blanks);
        mdp6 = MediaPlayer.create(getApplicationContext(), R.raw.mi);


        sm1();
        sm2();
        sm3();
        sm4();
        sm5();
        sm6();
        sm7();

       // stopmu();
      //  viewAll();

    }


    protected void playme(String sname, String desc, String type,String emotion) {
        Date currentTime = Calendar.getInstance().getTime();
String sh = g.getCusr();
       // Toast.makeText(MainActivity.this,sh,Toast.LENGTH_LONG).show();
myDb.insertUSData(sh,currentTime.toString(),"Coimbatore",myDb.getUserAge(sh),myDb.getUserGend(sh),g.getTemp(),g.getHumid(),desc,type,emotion,sname);

    }

    protected void sm1()
    {
        s1.setOnClickListener(
                new View.OnClickListener() {

                    String sname = "Shape of You";
                    String DESC ="Ed Sheeran";
                    String TYPE ="JAZZ";
                    String EMOTION = "Happy" ;
                    @Override
                    public void onClick(View v) {
                        int tp = g.getp2();
                        if(tp == 0) {

                            try {
                                playme(sname, DESC, TYPE, EMOTION);
                                mdp2.start();
                                g.putp2(1);
                            } catch (Exception e) {
                            }

                        } else
                        {
                            mdp2.pause();
                            g.putp2(0);
                        }

                    }
                }

        );
    }

    protected void sm2()
    {
        s2.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "Cheap Thrills";
                    String DESC ="Sai Furler";
                    String TYPE ="POP";
                    String EMOTION = "Happy" ;
                    @Override
                    public void onClick(View v) {
                        int tp = g.getP3();
                        if(tp == 0) {
                    try     {
                         playme(sname, DESC, TYPE, EMOTION);
                            mdp3.start();
                        g.putp3(1);
                    }catch(Exception e){}
                    }


                 else
        {
            mdp3.pause();

            g.putp3(0);
        }

    }}

        );
    }

    protected void sm3()
    {

        s3.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "See you Again";
                    String DESC ="Wiz Khalifa";
                    String TYPE ="JAZZ";
                    String EMOTION = "SAD" ;
                    @Override
                    public void onClick(View v) {
                        int tp = g.getp4();
                        if (tp == 0) {

                        try {
                            playme(sname, DESC, TYPE, EMOTION);
                            mdp4.start();
                            g.putp4(1);
                        } catch (Exception e) {
                        }
                    } else
        {
            mdp4.pause();

            g.putp4(0);
        }

    }}

        );

    }

    protected void sm4()
    {


        s4.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "Blank Space";
                    String DESC ="Taylor Swift";
                    String TYPE ="POP";
                    String EMOTION = "Happy" ;
                    @Override
                    public void onClick(View v) {
                        int tp = g.getp5();
                        if(tp == 0) {

                        try {
                            playme(sname,DESC,TYPE,EMOTION);
                            mdp5.start();
                            g.putp5(1);
                        }catch(Exception e){}
                    }  else
                    {
                        mdp5.pause();

                        g.putp5(0);
                    }

                }}

        );
    }

    protected void sm5()
    {
        s5.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "Mi Gente";
                    String DESC ="J Balvin";
                    String TYPE ="POP";
                    String EMOTION = "Happy" ;
                    @Override
                    public void onClick(View v) {
                        int tp = g.getp6();
                        if(tp == 0) {

                            try {
                                playme(sname, DESC, TYPE, EMOTION);
                                mdp6.start();
                                g.putp6(1);
                            } catch (Exception e) {
                            }
                        } else
                        {
                            mdp6.pause();

                            g.putp6(0);
                        }

                    }
                }

        );
    }

    protected void sm6()
    {
        s6.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "Locas";
                    String DESC = "PitBull";
                    String TYPE = "RAP";
                    String EMOTION = "Happy";

                    @Override
                    public void onClick(View v) {


                        try {
                            playme(sname, DESC, TYPE, EMOTION);
                        } catch (Exception e) {
                        }


                    }
                }

        );

    }

    protected void sm7()
    {
        s7.setOnClickListener(
                new View.OnClickListener() {
                    String sname = "Despacito";
                    String DESC ="Luis Fonsi";
                    String TYPE ="POP";
                    String EMOTION = "Happy" ;

                    @Override
                    public void onClick(View v) {
                        int tp = g.getp1();
                        if(tp == 0) {

                            try {

                                playme(sname, DESC, TYPE, EMOTION);
                                mdp1.start();
                                g.putp1(1);
                            } catch (Exception e) {
                            }
                        }
                     else
                    {
                        mdp1.pause();
                        g.putp1(0);
                    }

                }
                }

        );



    }

    public void stopmu() {
        s8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mdp1.stop();
                        mdp1.release();
                        mdp2.stop();
                        mdp2.release();
                        mdp3.stop();
                        mdp3.release();
                        mdp4.stop();
                        mdp4.release();
                        mdp5.stop();
                        mdp5.release();
                        mdp6.stop();
                        mdp6.release();
                    }
                }
        );
    }


    public void viewAll() {
        s7.setOnClickListener(
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
                            buffer.append("WEATHER DESC. : "+ res.getString(9)+"\n");
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

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}




 /*
    public  void AddData() {
        im1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertUSData(editName.getText().toString(), Calendar.getInstance().getTime().toString(),
                                editcity.getText().toString(),
                                Integer.parseInt(editage.getText().toString()),editgender.getText().toString(),27,92,"Clear",
                                editstype.getText().toString(),editsemotion.getText().toString(),editsname.getText().toString()
                                 );
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        im2.setOnClickListener(
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
                            buffer.append("WEATHER DESC. : "+ res.getString(9)+"\n");
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

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    public void doAll() {
        im3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, pagen.class);
                        startActivity(intent);
                    }
                }
        );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/