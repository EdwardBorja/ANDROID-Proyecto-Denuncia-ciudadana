package com.example.denuncia;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Phonecalls extends ActionBarActivity {

    public Button makeCall,call2,call3,call4,call5;
    public Button endCall;
    public Intent callIntent;
 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phonecalls);
		
		 
		botones();
		
	}
	
	public void botones(){
		
		
		//policia local
		 makeCall = (Button)findViewById(R.id.button1);
	     makeCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 call();
				
			}
		});
	     
	     //cruz roja
	     call2 = (Button)findViewById(R.id.button2);
	     call2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				cruzr();
				
			}
		});
	     
	     //bomberos
	     call3 = (Button)findViewById(R.id.button3);
	     call3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				bomberos();
				
			}
		});
	     
	    //proteccion civil
	     call4 = (Button)findViewById(R.id.button4);
	     call4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Pcivil();
			}
		});
		
	   //Extorsion telefonica
	     call5 = (Button)findViewById(R.id.button5);
	     call5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Extorsion();
			}
		});
	     
	     
	}
	
	
	private void call() {
		
		
		try {
			callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse("tel:060"));
	        startActivity(callIntent);
	    }catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}
	
	
	private void cruzr() {
		
		
		try {
			callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse("tel:065"));
	        startActivity(callIntent);
	    }catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}
	
	
	private void bomberos() {
		
		
		try {
			callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse("tel:068"));
	        startActivity(callIntent);
	    }catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}
	

private void Pcivil() {
		
		
		try {
			callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse("tel:+52(55)5683-2222"));
	        startActivity(callIntent);
	    }catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}

private void Extorsion() {
	
	
	try {
		callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:088"));
        startActivity(callIntent);
    }catch (ActivityNotFoundException activityException) {
        Log.e("dialing-example", "Call failed", activityException);
    }
}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phonecalls, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
