package com.example.tp2_grupo_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ActivityFormContact2 extends AppCompatActivity {

    private RadioButton rb_estudio_pi,rb_estudio_pc, rb_estudio_si, rb_estudio_sc, rb_estudio_ot;
    private CheckBox cb_deporte, cb_arte, cb_musica, cb_tecnologia;

    private String valor_nombre, valor_apellido, valor_telefono,valor_email,valor_direccion,valor_fechaNacimiento,valor_telefono_Item,valor_email_Item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SEGUNDO FORMULARIO

         valor_nombre = getIntent().getStringExtra("datonombre");
         valor_apellido = getIntent().getStringExtra("datoapellido");
         valor_telefono = getIntent().getStringExtra("datotelefono");
         valor_email = getIntent().getStringExtra("datoemail");
         valor_direccion = getIntent().getStringExtra("datodireccion");
         valor_fechaNacimiento = getIntent().getStringExtra("datofechaNacimiento");
         valor_telefono_Item = getIntent().getStringExtra("datotelefonoitem");
         valor_email_Item = getIntent().getStringExtra("datoemailitem");




        rb_estudio_pi = (RadioButton)findViewById(R.id.rb_estudioPI);
        rb_estudio_pc = (RadioButton)findViewById(R.id.rb_estudioPC);
        rb_estudio_si = (RadioButton)findViewById(R.id.rb_estudioSI);
        rb_estudio_sc = (RadioButton)findViewById(R.id.rb_estudioSC);
        rb_estudio_ot = (RadioButton)findViewById(R.id.rb_estudioOt);

        cb_deporte = (CheckBox)findViewById(R.id.cb_deporte);
        cb_arte = (CheckBox)findViewById(R.id.cb_arte);
        cb_musica = (CheckBox)findViewById(R.id.cb_musica);
        cb_tecnologia = (CheckBox)findViewById(R.id.cb_tecnologia);
    }

    public void Guardar(View view){
        String NivelEstudio = "";
        if(rb_estudio_pi.isChecked() == true){
            //ESTUDIO PRIMARIO INCOMPLETA
            NivelEstudio = "PRIMARIO INCOMPLETO";
        }
        if(rb_estudio_pc.isChecked() == true){
            //ESTUDIO PRIMARIO COMPLETO
            NivelEstudio = "PRIMARIO COMPLETO";
        }
        if(rb_estudio_si.isChecked() == true){
            //ESTUDIO SECUNDARIO INCOMPLETO
            NivelEstudio = "SECUNDARIO INCOMPLETO";
        }
        if(rb_estudio_sc.isChecked() == true){
            //ESTUDIO SECUNDARIO COMPLETO
            NivelEstudio = "PRIMARIO COMPLETO";
        }
        if(rb_estudio_ot.isChecked() == true){
            //OTROS ESTUDIOS
            NivelEstudio = "OTROS ESTUDIOS";
        }

        String Intereses = "Intereses:";
        if(cb_arte.isChecked() == true){
            //INTERES - ARTE
            Intereses += " ARTE ";
        }
        if(cb_musica.isChecked() == true){
            //INTERES - MUSICA
            Intereses += " MUSICA ";
        }
        if(cb_deporte.isChecked() == true){
            //INTERES - DEPORTE
            Intereses += " DEPORTE ";
        }
        if(cb_tecnologia.isChecked() == true){
            //INTERES - TECNOLOGIA
            Intereses += " TECNOLOGIA ";
        }
        //SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        //SharedPreferences.Editor obj_editor = preferencias.edit();

        //Nombre identificador, variable a guardar
        //obj_editor.putString("1",NivelEstudio);
        //obj_editor.commit();

        String cadenaContacto = "";

        cadenaContacto += valor_nombre + " - ";
        cadenaContacto += valor_apellido + " - ";
        cadenaContacto += valor_direccion + " - ";
        cadenaContacto += valor_telefono + " (" + valor_telefono_Item + ") - ";
        cadenaContacto += valor_email + " (" + valor_telefono_Item + ") - ";
        cadenaContacto += valor_fechaNacimiento + " - ";
        cadenaContacto += "Estudios: " + NivelEstudio + " - " + Intereses + ".";


        try {
            FileInputStream fileInputStream = openFileInput("contactos.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder existingContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                existingContent.append(line).append("\n");
            }

            bufferedReader.close();

            String updatedContent;
            if (!existingContent.toString().isEmpty()) {
                updatedContent = existingContent.toString() + "\n" + cadenaContacto;
            } else {
                updatedContent = cadenaContacto;
            }

            OutputStreamWriter contacto = new OutputStreamWriter(openFileOutput("contactos.txt", Activity.MODE_PRIVATE));
            contacto.write(updatedContent);

            contacto.flush();
            contacto.close();

        } catch (IOException e) {
            // Manejo de excepciones
        }
        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_SHORT).show();

        //Intent FormularioOriginal = new Intent(this, ActivityFormContact1.class);
        //startActivity(FormularioOriginal);
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