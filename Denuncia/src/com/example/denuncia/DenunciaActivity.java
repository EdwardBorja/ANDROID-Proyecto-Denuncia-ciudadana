package com.example.denuncia;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;





import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class DenunciaActivity extends ActionBarActivity {

	private TextView lblMensaje;
	private Spinner cmbOpciones;

	
	
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;	
	private static int SELECT_VIDEO = 3;	
	
	private String name = "";
	
	private Button btnActualizar;
	//private Button btnDesactivar;
	private TextView lblLatitud; 
	private TextView lblLongitud;
	private TextView lblPrecision;
	private TextView lblEstado;
	
	private LocationManager locManager;
	private LocationListener locListener;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		setContentView(R.layout.activity_denuncia);
		
		Menuoption();
		botonescam();
		botongps();
    }
	
	public void Menuoption(){
		
		lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
        
        //Aqui van los elementos 
        final String[] datos =
            new String[]{"Corrupcion","Robo","Violencia","Vialidad","Ambiental"};
     
        //Alternativa 1: Array java
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        
       
         adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
         
        cmbOpciones.setAdapter(adaptador);

        //aqui detecta el elemento seleccionado
        cmbOpciones.setOnItemSelectedListener(
        	new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                    android.view.View v, int position, long id) {
                        lblMensaje.setText("Tipo de denuncia : " + datos[position]);
                }
         
                public void onNothingSelected(AdapterView<?> parent) {
                    lblMensaje.setText("");
                }
        });
	}
	
	public void botongps(){
		
		
		btnActualizar = (Button)findViewById(R.id.BtnActualizar);
	       // btnDesactivar = (Button)findViewById(R.id.BtnDesactivar);
	        lblLatitud = (TextView)findViewById(R.id.LblPosLatitud);
	        lblLongitud = (TextView)findViewById(R.id.LblPosLongitud);
	        lblPrecision = (TextView)findViewById(R.id.LblPosPrecision);
	        lblEstado = (TextView)findViewById(R.id.LblEstado);
	        
	        btnActualizar.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					comenzarLocalizacion();
				}
			});
	      
	        /*
	        btnDesactivar.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
			    	locManager.removeUpdates(locListener);
				}
			});
	        
	        */

	}
	
	private void comenzarLocalizacion()
    {
    	//Obtenemos una referencia al LocationManager
    	locManager = 
    		(LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	
    	//Obtenemos la última posición conocida
    	Location loc = 
    		locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	
    	//Mostramos la última posición conocida
    	mostrarPosicion(loc);
    	
    	//Nos registramos para recibir actualizaciones de la posición
    	locListener = new LocationListener() {
	    	public void onLocationChanged(Location location) {
	    		mostrarPosicion(location);
	    	}
	    	public void onProviderDisabled(String provider){
	    		lblEstado.setText("Apagado    (active el gps)");
	    		
	    		
	    	}
	    	public void onProviderEnabled(String provider){
	    		lblEstado.setText("Encendido");
	    	}
	    	public void onStatusChanged(String provider, int status, Bundle extras){
	    		Log.i("", "Provider Status: " + status);
	    		lblEstado.setText("Provider Status: " + status);
	    	}
    	};
    	
    	locManager.requestLocationUpdates(
    			LocationManager.GPS_PROVIDER, 10000, 0, locListener);
    }
     
    private void mostrarPosicion(Location loc) {
    	if(loc != null)
    	{
    		lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
    		lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
    		lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
    		Log.i("", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
    	}
    	else
    	{
    		lblLatitud.setText("Latitud: (?)");
    		lblLongitud.setText("Longitud: (?)");
    		lblPrecision.setText("Precision: (?)");
    	}
    }
    
    

	
	public void botonescam(){
		
		  name = Environment.getExternalStorageDirectory() + "/imagen.jpg";
		
		ImageButton imgb1 = (ImageButton)findViewById(R.id.imageButton1);
		imgb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
				int code = TAKE_PICTURE;
				
				Uri output = Uri.fromFile(new File(name));
		    	intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
		    	
		    	startActivityForResult(intent, code);
				
			}
		});
		
		
		ImageButton imgb2 = (ImageButton)findViewById(R.id.imageButton2);
		imgb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//imagen
				Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
				
				intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				int code = SELECT_PICTURE;
				startActivityForResult(intent, code);
				
				
			
				
			}
		});
		
		
	
		
		
	}

	
	
	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		if (requestCode == TAKE_PICTURE) {
			
			
				
				ImageView iv = (ImageView)findViewById(R.id.imgView);
    			iv.setImageBitmap(BitmapFactory.decodeFile(name));
			
    			new MediaScannerConnectionClient() {
    				private MediaScannerConnection msc = null; {
    					msc = new MediaScannerConnection(getApplicationContext(), this); msc.connect();
    				}
    				public void onMediaScannerConnected() { 
    					msc.scanFile(name, null);
    				}
    				public void onScanCompleted(String path, Uri uri) { 
    					msc.disconnect();
    				} 
    			};				
    		} 
		
			else  if(requestCode == SELECT_PICTURE){
    		Uri selectedImage = data.getData();
    		InputStream is;
    		try {
    			is = getContentResolver().openInputStream(selectedImage);
    	    	BufferedInputStream bis = new BufferedInputStream(is);
    	    	Bitmap bitmap = BitmapFactory.decodeStream(bis);            
    	    	ImageView iv = (ImageView)findViewById(R.id.imgView);
    	    	iv.setImageBitmap(bitmap);						
    		} catch (FileNotFoundException e) {}
    		
    	}
		
		
		
    }
			
			
			
			
		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.denuncia, menu);
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
