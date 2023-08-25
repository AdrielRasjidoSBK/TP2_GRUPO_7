package com.example.tp2_grupo_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFormContact1 extends AppCompatActivity {

    private View view;

    private EditText et_nombre, et_apellido, et_telefono, et_email, et_direccion,et_fechaNacimiento;
    private Spinner sp_telefono, sp_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_nombre = (EditText)findViewById(R.id.txt_Nombre);
        et_apellido = (EditText)findViewById(R.id.txt_Apellido);
        et_telefono = (EditText)findViewById(R.id.txt_Telefono);
        et_email = (EditText)findViewById(R.id.txt_Email);
        et_direccion = (EditText)findViewById(R.id.txt_Direccion);
        et_fechaNacimiento = (EditText)findViewById(R.id.txt_FechaNacimiento);

        sp_telefono = (Spinner)findViewById(R.id.itemTelefono);
        sp_email = (Spinner)findViewById(R.id.itemEmail);

        String [] opcionesItems = {"Casa","Trabajo","Móvil"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesItems);
        sp_telefono.setAdapter(adapter);
        sp_email.setAdapter(adapter);
    }

    public void Continuar(View view){
        String valor_nombre = et_nombre.getText().toString();
        String valor_apellido = et_apellido.getText().toString();
        String valor_telefono = et_telefono.getText().toString();
        String valor_email = et_email.getText().toString();
        String valor_direccion = et_email.getText().toString();
        String valor_fechaNacimiento = et_fechaNacimiento.getText().toString();
        String valor_telefono_Item = sp_telefono.getSelectedItem().toString();
        String valor_email_Item = sp_telefono.getSelectedItem().toString();

        Intent siguienteFormulario = new Intent(this, ActivityFormContact2.class);
        siguienteFormulario.putExtra("datonombre",valor_nombre);
        siguienteFormulario.putExtra("datoapellido",valor_apellido);
        siguienteFormulario.putExtra("datotelefono",valor_telefono);
        siguienteFormulario.putExtra("datoemail",valor_email);
        siguienteFormulario.putExtra("datodireccion",valor_direccion);
        siguienteFormulario.putExtra("datofechaNacimiento",valor_fechaNacimiento);
        siguienteFormulario.putExtra("datotelefonoitem",valor_telefono_Item);
        siguienteFormulario.putExtra("datoemailitem",valor_email_Item);

        startActivity(siguienteFormulario);
    }

    @Override public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.ActivityFormContact1){
            Intent intent = new Intent(this, ActivityFormContact1.class);
            startActivity(intent);
        }
        if(id==R.id.ActivityFormList){
            Intent intent = new Intent(this, ActivityFormList.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}