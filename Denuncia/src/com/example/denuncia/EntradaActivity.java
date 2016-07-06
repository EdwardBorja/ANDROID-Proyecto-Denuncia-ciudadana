package com.example.denuncia;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class EntradaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
      
        setContentView(R.layout.activity_entrada);
        
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        botones();
    }

    public void botones(){
		
		 //boton login
		 Button bLog = (Button) findViewById(R.id.buttonLogin);
		 bLog.setOnClickListener(new OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			
   		
   				startActivity(new Intent(EntradaActivity.this,MenuActivity.class));
   				
   	
   		}
   	});
		
		 ImageButton fb = (ImageButton) findViewById(R.id.face);
		 fb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 
				//abrir pagina web desde boton
					//se pone la direccion web para abrirla
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("https://www.facebook.com/DenunciasCiudadanaGuadalajara"));
					startActivity(intent);
			}
		});
		 
		
       
		 ImageButton wix = (ImageButton) findViewById(R.id.pag);
		 wix.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 
				//abrir pagina web desde boton
					//se pone la direccion web para abrirla
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("http://christianarias2.wix.com/denunciaciudadana"));
					startActivity(intent);
			}
		});
		
       
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.entrada, menu);
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
