package com.upm.fi.jmn.interfazevento;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textViewMensaje;
	RadioButton radioButtonMujer;
	Spinner spinnerEdad;
	Button buttonEnviar, buttonBorrar;
	CheckBox checkBoxEstudiante;
	EditText editTextNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textViewMensaje = (TextView) findViewById(R.id.textViewMensaje);
        radioButtonMujer = (RadioButton) findViewById(R.id.radioButtonMujer);
        spinnerEdad = (Spinner) findViewById(R.id.spinnerEdad);
        buttonBorrar = (Button) findViewById(R.id.buttonBorrar);
        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);
        checkBoxEstudiante = (CheckBox) findViewById(R.id.checkBoxEstudiante);
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        
        //Rellenar el spinner con las edades
        List<String> list = new ArrayList<String>();
    	for (int i = 18; i < 50; i++) {
    		list.add(i+"");
		}
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    			android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinnerEdad.setAdapter(dataAdapter);
    	
        buttonBorrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textViewMensaje.setText(R.string.mensaje);
				spinnerEdad.setSelection(0);
				editTextNombre.setText("");
				checkBoxEstudiante.setChecked(false);
				radioButtonMujer.setChecked(true);
			}
		});
        
        buttonEnviar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String nombre = editTextNombre.getText().toString();
				String genero = (radioButtonMujer.isChecked()) ? "mujer" : "hombre" ;
				String edad = String.valueOf(spinnerEdad.getSelectedItem());
				String estudiante = (checkBoxEstudiante.isChecked()) ? " " : " no ";
				
				textViewMensaje.setText(nombre+" es "+genero+", tiene "+edad+" años y"+estudiante+"es estudiante");
			}
		});
    }
}
