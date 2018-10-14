package com.maet.rishabhkumartyagi.cloudmu;

import android.app.Application;

/**
 * Created by RISHABH KUMAR TYAGI on 12-10-2018.
 */
public class globalVar extends Application{
    private static String currentUser;
    private static int ctem;
    private static int chumid;
    public static int p1,p2,p3,p4,p5,p6;

    globalVar(){
        p1=p2=p3=p4=p5=p6=0;
    }

    public void putp1(int val){

        p1 = val;

    }
    public void putp2(int val){

        p2 = val;

    }
    public void putp3(int val){

        p3 = val;

    }
    public void putp4(int val){

        p4 = val;

    }
    public void putp5(int val){

        p5 = val;

    }
    public void putp6(int val){

        p6 = val;

    }


    public int getp1(){
        return p1;
    }
    public int getp2() { return p2; }
    public int getP3() { return p3; }
    public int getp4(){
        return p4;
    }
    public int getp5(){
        return p5;
    }
    public int getp6(){
        return p6;
    }


    public void putCusr(String name){

            currentUser = name;

    }

    public void putSec(int temp,int humid){

        ctem = temp;
        chumid = humid;

    }

    public int getTemp(){
        return ctem;
    }
    public int getHumid(){
        return chumid;
    }

    public String getCusr(){
        return currentUser;
    }
}