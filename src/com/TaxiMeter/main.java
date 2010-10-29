package com.TaxiMeter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("TESTMain","My First Log");
        Context myContext=this.getApplicationContext();
        TaxiMeterSrv myMeterSrv=new TaxiMeterSrv();
       // Intent serviceIntent = new Intent();
       // serviceIntent.setAction(TaxiMeterSrv.class);
        startService(new Intent (this,TaxiMeterSrv.class));
        System.out.println(myMeterSrv);
        Log.i("test", myMeterSrv.toString());
    }
}