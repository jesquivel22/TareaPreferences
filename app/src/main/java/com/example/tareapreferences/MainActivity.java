package com.example.tareapreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText campoCodigo,campoNombre,campoEscuela,campoTel;
    TextView txtCodigo, txtNombre, txtEscuela, txtTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoCodigo= (EditText) findViewById(R.id.editTextCodigo);
        campoNombre= (EditText) findViewById(R.id.editTextNombres);
        campoEscuela= (EditText) findViewById(R.id.editTextEscuela);
        campoTel= (EditText) findViewById(R.id.editTextTel);
        txtCodigo= (TextView) findViewById(R.id.campCodigo);
        txtNombre= (TextView) findViewById(R.id.campNombre);
        txtEscuela= (TextView) findViewById(R.id.campEscuela);
        txtTel= (TextView) findViewById(R.id.campTel);

        cargarPreferencia();
    }

    public void onclick(View view){

        switch (view.getId()){
            case R.id.btnGuardar:
                guardarPreferencia();
                break;
            //case R.id.btnCargar:
              //  Intent intent=new Intent(this,ConsultaPreferencias.class);
                //startActivity(intent);
                //break;
        }
    }

    private void cargarPreferencia() {
        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String codigo=preferences.getString("codigo","No existe la informacion");
        String nombre=preferences.getString("nombre","No existe la informacion");
        String escuela=preferences.getString("escuela","No existe la informacion");
        String tel=preferences.getString("tel","No existe la informacion");

        txtCodigo.setText("Codigo : "+codigo);
        txtNombre.setText("Nombre : "+nombre);
        txtEscuela.setText("Escuela : "+escuela);
        txtTel.setText("Telefono : "+tel);

    }

    private void guardarPreferencia() {
        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String codigo = campoCodigo.getText().toString();
        String nombre = campoNombre.getText().toString();
        String escuela = campoEscuela.getText().toString();
        String tel = campoTel.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("codigo",codigo);
        editor.putString("nombre",nombre);
        editor.putString("escuela",escuela);
        editor.putString("tel",tel);

        txtCodigo.setText("Codigo : "+codigo);
        txtNombre.setText("Nombre : "+nombre);
        txtEscuela.setText("Escuela : "+escuela);
        txtTel.setText("Telefono : "+tel);

        editor.commit();

    }
}













