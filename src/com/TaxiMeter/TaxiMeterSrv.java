package com.TaxiMeter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TaxiMeterSrv extends Service{

	private static final String MAIN_ACTIVITY = null;
	private static final int UPDATE_FREQUENCY=1;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		  super.onCreate();

		  
		  //if (speed>6 updateDistanceMeter())
		  //if (if speed <12 updateTimeMeter(UPDATE_FREQUENCY)//incriment the actuall time
		  // init the service here
		//  _startService();

	//	  if (MAIN_ACTIVITY != null) AppUtils.showToastShort(MAIN_ACTIVITY, "MyService started");
		}

		@Override
		public void onDestroy() {
		  super.onDestroy();

	//	  _shutdownService();

	//	  if (MAIN_ACTIVITY != null) AppUtils.showToastShort(MAIN_ACTIVITY, "MyService stopped");
		}

}
