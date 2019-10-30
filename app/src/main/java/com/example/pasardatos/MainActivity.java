package com.example.pasardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pasardatos.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText textoNombre,textoApellidos,  textoTelefono;
    CheckBox checkBoxPermitir;
    Button btnPasar;
    final static String TAGnombre = "k1", TAGnumero = "k2", TAG_1="k3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnPasar.setOnClickListener(this);
    }

    private void instancias() {
        checkBoxPermitir = findViewById(R.id.checkPermitir);
        textoNombre = findViewById(R.id.txtNombre);
        textoApellidos = findViewById(R.id.txtApellidos);
        textoTelefono = findViewById(R.id.txtTelefono);
        btnPasar = findViewById(R.id.btnPasar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPasar:
                String nombre = (textoNombre.getText()).toString();
                String apellidos = (textoApellidos.getText()).toString();
                int telefono = Integer.valueOf(textoTelefono.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                if(!textoNombre.getText().toString().isEmpty() &&
                        !textoApellidos.getText().toString().isEmpty() &&
                        textoTelefono.getText().toString().length() == 9 &&
                        checkBoxPermitir.isChecked()){
                    Persona persona = new Persona(nombre, apellidos, telefono);

                    intent.putExtra(TAG_1, persona);
                    /*intent.putExtra(TAGnombre, nombre);
                    intent.putExtra(TAGnumero, telefono);*/
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Debe introducir los datos correctamente", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
