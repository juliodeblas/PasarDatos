package com.example.pasardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pasardatos.utils.Persona;

public class SecondActivity extends AppCompatActivity {

    TextView textoRecuperado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null) {
            //String nombreRecuperado = (getIntent().getExtras().get(MainActivity.TAGnombre)).toString();
            //String telefonoRecuperado = (getIntent().getExtras().get(MainActivity.TAGnumero)).toString();
            Persona pRecuperada = null;
            try{
                pRecuperada= (Persona)getIntent().getExtras().get(MainActivity.TAG_1);
            }catch (ClassCastException e){
                //FALLO
            }
            String saludo = String.format("Perfecto %s %s, tu teléfono es %d", pRecuperada.getNombre(), pRecuperada.getApellidos(), pRecuperada.getTelefono());
            textoRecuperado.setText(saludo);
        }
    }

    public void instancias() {
        textoRecuperado = findViewById(R.id.textoRecuperado);
    }
}
