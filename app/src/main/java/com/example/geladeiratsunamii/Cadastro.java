package com.example.geladeiratsunamii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Cadastro extends AppCompatActivity
{

    private EditText descricao;
    private EditText date;
    private Button cad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        descricao = (EditText)findViewById(R.id.desc2);
        date = (EditText)findViewById(R.id.date);
        cad = (Button)findViewById(R.id.pronto);
        if (getIntent().hasExtra("position"))
        {
            int position = getIntent().getExtras().getInt("position");
            Dados alteracao = Dados.lista.get(position);
            descricao.setText(alteracao.desc);
            date.setText(alteracao.data);
            cad.setText("ALTERAR");
        }
    }

    public void voltar(View view)
    {
        finish();
    }

    public void cadastrar(View view)
    {
        Banco banco = new Banco(getApplicationContext());
        if (getIntent().hasExtra("position"))
        {
            int position = getIntent().getExtras().getInt("position");
            Dados alteracao = Dados.lista.get(position);
            alteracao.desc = descricao.getText().toString();
            alteracao.data = date.getText().toString();
            banco.alterarItem(alteracao.id, alteracao.desc, alteracao.data);
        }
        else
        {
            int id = (int)banco.inserirItem(descricao.getText().toString(), date.getText().toString());
            Dados novoDado = new Dados(id, descricao.getText().toString(), date.getText().toString());
            Dados.lista.add(novoDado);
        }
        finish();
    }
}
