package com.example.tp2_grupo_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.List;
import java.util.Map;

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

        //intento Alan
        lv1 = (ListView)findViewById(R.id.lv_contactos);

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = preferences.getAll(); // Obtener todos los datos guardados
        List<String> contactosList = new ArrayList<>();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String identificador = entry.getKey();
            if (identificador.startsWith("agenda_contacto")) {
                String cadenaContacto = entry.getValue().toString();
                contactosList.add(cadenaContacto);
            }
        }

        if (contactosList.isEmpty()) {
            contactosList.add("No se han encontrado contactos guardados.");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactosList);
        lv1.setAdapter(adapter);

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