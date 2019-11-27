package com.example.geladeiratsunamii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Adaptador adap;
    ListView listaProdutos;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adap.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Banco banco = new Banco(getApplicationContext());

        Dados.lista = banco.carregar();
        adap = new Adaptador(this, Dados.lista);

        listaProdutos = findViewById(R.id.GELADEIRA);
        listaProdutos.setAdapter(adap);
        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.add)
        {
            Intent intent = new Intent(this, Cadastro.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.creditos)
        {
            Intent intent = new Intent(this, CREBITOS.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
