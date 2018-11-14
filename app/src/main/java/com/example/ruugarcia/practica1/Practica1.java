package com.example.ruugarcia.practica1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class Practica1 extends AppCompatActivity implements OnClickListener {

    Spinner spLista;
    Button btnLimpiar;
    Button btnGenerar;
    EditText Nombre;
    EditText Apellidos;
    EditText Edad;
    RadioGroup GGenero;
    RadioButton rbHombre;
    RadioButton rbMujer;
    Switch switchHijos;
    String switch0 = "";
    String Genero = "";
    String edadTotal;


    TextView Salida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1);

        spLista = findViewById(R.id.spLista);
        String[] Estado = {"", "Casado", "Separado", "Viudo", "Otro"};
        spLista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Estado));

        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnGenerar = findViewById(R.id.btnGenerar);
        btnGenerar.setOnClickListener(this);
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Apellidos = (EditText) findViewById(R.id.txtApellidos);
        Edad = (EditText) findViewById(R.id.txtEdad);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);
        switchHijos = (Switch) findViewById(R.id.switchHijos);
        GGenero = (RadioGroup) findViewById(R.id.GGenero);
        Salida = (TextView) findViewById(R.id.txtResultado);


        GGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbHombre) Genero = "Hombre";
                if (checkedId == R.id.rbMujer) Genero = "Mujer";
            }
        });

        switchHijos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchHijos.isChecked() == true) {
                    switch0 = "Si tiene Hijos";
                }
                if (switchHijos.isChecked() == false) {
                    switch0 = "No tiene Hijos";
                }
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nombre.setText("");
                Apellidos.setText("");
                Edad.setText("");
                Salida.setText("");
                rbHombre.setChecked(false);
                rbMujer.setChecked(false);
                switchHijos.setChecked(false);
                spLista.setSelection(0);
            }
        });


    }



    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        if (Nombre.getText().toString().isEmpty()) {
            Salida.setText(getResources().getString(R.string.Nombre0));
            Salida.setTextColor(getColor(R.color.colorRojo));

        } else {
            if (Apellidos.getText().toString().isEmpty()) {
                Salida.setText(getResources().getString(R.string.Apellidos0));
                Salida.setTextColor(getColor(R.color.colorRojo));
            } else {
                if (Edad.getText().toString().isEmpty()) {
                    Salida.setText(getResources().getString(R.string.Edad0));
                    Salida.setTextColor(getColor(R.color.colorRojo));

                } else {

                    if (Integer.parseInt(Edad.getText().toString()) >= 18) {
                        edadTotal = getResources().getString(R.string.Mayor);

                    } else {
                        edadTotal = getResources().getString(R.string.Menor);

                    }

                    Salida.setText(Apellidos.getText().toString() + " ," + (Nombre.getText().toString()) + ", " + edadTotal
                            + " , " + (Genero) +" "+ (spLista.getSelectedItem().toString()) + " y " + (switch0));
                }


            }

        }


    }
}




