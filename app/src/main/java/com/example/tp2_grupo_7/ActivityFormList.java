package com.example.tp2_grupo_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityFormList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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