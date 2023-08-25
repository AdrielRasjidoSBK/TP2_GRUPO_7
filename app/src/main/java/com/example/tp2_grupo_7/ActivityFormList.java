package com.example.tp2_grupo_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;
import java.util.ArrayList;

public class ActivityFormList extends AppCompatActivity {

    private ListView lv1;
    private TextView tvdatos;
    private String contactosItems [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv1 = (ListView)findViewById(R.id.lv_contactos);
        tvdatos = (TextView)findViewById(R.id.tvDatos);

        ArrayList <String> lineasContactos = new ArrayList<>();
        String contactos [] = fileList();
        if(ExistenContactos(contactos,"contactos.txt")){
            try {
                InputStreamReader contacto = new InputStreamReader(openFileInput("contactos.txt"));
                BufferedReader br = new BufferedReader(contacto);
                //Lee la primera linea para saber si existe algun contenido
                String linea = br.readLine();
                while (linea != null){
                    lineasContactos.add(linea);
                    linea = br.readLine();
                }
                br.close();
                contacto.close();
            }catch (IOException e){

            }

            contactosItems = lineasContactos.toArray(new String[0]);
            ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_contacto);
            lv1.setAdapter(adapter);

            //AL SELECCIONAR UN ITEM
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    tvdatos.setText("Datos: " + lv1.getItemIdAtPosition(i));
                }
            });
        }
    }

    private boolean ExistenContactos(String contactos[],String NombreArchivo){
        for(int i = 0; i < contactos.length; i++)
            if(NombreArchivo.equals(contactos[i]))
                return true;
        return false;
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