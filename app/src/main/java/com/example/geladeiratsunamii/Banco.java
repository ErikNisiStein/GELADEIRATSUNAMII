package com.example.geladeiratsunamii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class Banco {
    private SQLiteDatabase db;
    private SQLHelper banco;

    public Banco(Context context){
        banco = new SQLHelper(context);
    }

    public long inserirItem(String descricao, String data){
        ContentValues values = new ContentValues();
        long id;

        db = banco.getWritableDatabase();
        values.put("descricao", descricao);
        values.put("data", data);
        id = db.insert(SQLHelper.TABELA, null, values);
        db.close();
        return id;
    }

    public void alterarItem(Integer id, String descricao, String data){
        ContentValues values = new ContentValues();

        db = banco.getWritableDatabase();
        values.put("descricao", descricao);
        values.put("data", data);
        db.update(SQLHelper.TABELA, values, SQLHelper.ID + " = " + id, null);
        db.close();
    }

    public void removerItem(Integer id){
        db = banco.getWritableDatabase();
        db.delete(SQLHelper.TABELA, SQLHelper.ID + " = " + id, null);
        db.close();
    }

    public ArrayList<Dados> carregar(){
        ArrayList<Dados> itens = new ArrayList<>();
        db = banco.getWritableDatabase();
        String colunas[] = {"id", "data", "descricao"};
        Cursor cursor = db.query(SQLHelper.TABELA, colunas, null, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            while(!cursor.isLast()){
                Dados dado = new Dados(cursor.getInt(0), cursor.getString(2), cursor.getString(1));
                itens.add(dado);
            }
        }
        cursor.close();
        db.close();
        return itens;
    }
}
