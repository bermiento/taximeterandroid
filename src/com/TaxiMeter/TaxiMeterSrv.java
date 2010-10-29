package com.TaxiMeter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TaxiMeterSrv extends Service {

	private Context mContext;

	private DistanceMeter myDistanceMeter;

	private static final String MAIN_ACTIVITY = null;
	private static final int UPDATE_FREQUENCY = 1000;
	private long time1;
	private LocationManager myLocatationMgr;
	private  LocationUpdateHandler myLocationUpdateHandler;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("TAXI_METER_SERVICE", "OONCREATE");
		myLocationUpdateHandler= new LocationUpdateHandler();
		
		// init the service here
		_startService();

		// if (MAIN_ACTIVITY == null)
		// Toast.makeText(this,"MyService started",Toast.LENGTH_SHORT).show();
	}

	private void _startService() {
		myDistanceMeter = new DistanceMeter(new DistanceUnit(40, 6, 321));
		myLocatationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		myLocatationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				UPDATE_FREQUENCY, 0, myLocationUpdateHandler);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// _shutdownService();
		myLocatationMgr.removeUpdates(myLocationUpdateHandler);
		if (MAIN_ACTIVITY != null)
			Toast.makeText(mContext, "MyService Stoped", Toast.LENGTH_SHORT)
					.show();
	}

	private class LocationUpdateHandler implements LocationListener {
		long lat;
		long lng;
		Location myInitalLocation;
		Location myTempLocation;
		float distanceTraveled;
		long initialTime;
		long tempTime;
		private float myspeed;

		public LocationUpdateHandler() {
			initialTime = System.nanoTime();
			tempTime = initialTime;
		}

		@Override
		/**
		 * NOTE: we may be missing the first frame distance traveled
		 */
		public void onLocationChanged(Location loc) {
			if (myInitalLocation == null) {
				myInitalLocation = loc;
				myTempLocation = loc;
			}
			lat = (long) (loc.getLatitude() * 1E6);
			lng = (long) (loc.getLongitude() * 1E6);
			distanceTraveled =  (myTempLocation.distanceTo(loc) );
			Log.i("METERS_TRAVELED",distanceTraveled+"");
			long time2 = System.nanoTime();
			myspeed =  (float) (distanceTraveled / (time2 - time1)*1E9);
			myTempLocation = loc;
			tempTime = time2;
			if (myspeed > 6) ;
			//	myDistanceMeter.incrementMeter(distanceTraveled);
			// if (speed>6 updateDistanceMeter(speed))
			// if (if speed <12 updateTimeMeter(UPDATE_FREQUENCY)//incriment the
			// actuall time
			Log.i("SERVICE_ON_LOCATION_CHANGE", this.toString());
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		public String toString() {
			return "My Initial Latitude Location is"
					+ (myInitalLocation.getLatitude() * 1E6)
					+ "\nMy Initial Logintude Location is"
					+ (myInitalLocation.getLongitude() * 1E6)
					+ "\nMy initial Time is at" + initialTime
					+ "\nMy Current Latitude: " + lat
					+ "\nMy Current Longitude: " + lng
					+ "\nMy Curent Time is: " + tempTime
					+ "\nMy Current Speed is: " + myspeed + " KMH"
					+ "\nMy Last Distance Traveled was: " + distanceTraveled
					+ " KM" + "\nMy Distance Meter: " + myDistanceMeter;
		}

	}

}
