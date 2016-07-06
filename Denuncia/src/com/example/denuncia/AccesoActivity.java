package com.example.denuncia;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AccesoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
	
				
		setContentView(R.layout.activity_acceso);
		 
		
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		botones();
	}

	public void botones(){
		
		
		
		
		 
		 //boton entrar
		 Button benter = (Button) findViewById(R.id.buttonEntrar);
        benter.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			
    			
    			//variables
    			 EditText txtLogin=(EditText)findViewById(R.id.txtuser);
    			 EditText txtClave=(EditText)findViewById(R.id.txtpass);
    			 
    			 //validacion
    			 //if(txtLogin.getText().toString().equals("eduardo") && txtClave.getText().toString().equals("12") ){
    				 
    				 //se llama a la ventana cuarta
    				startActivity(new Intent(AccesoActivity.this,MenuActivity.class));
    				
    				 
    				   //se muestra el mensaje al fallar validacion
    			// }else{Toast.makeText(getBaseContext(), "Intente de nuevo",Toast.LENGTH_SHORT).show();}
    			 
    			 
    			 
    		}
    	});
		
        
        TextView txt1 = (TextView) findViewById(R.id.txvreg);
       //aqui se subraya el textview
        txt1.setPaintFlags(txt1.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        txt1.setOnClickListener(new OnClickListener() {
			
			@Override 
			public void onClick(View v) {

				startActivity(new Intent(AccesoActivity.this, EntradaActivity.class));
			}
		});
        
        
        
      
        
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acceso, menu);
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
