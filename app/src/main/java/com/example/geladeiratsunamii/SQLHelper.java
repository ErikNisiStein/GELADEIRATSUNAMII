package com.example.geladeiratsunamii;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    static final String NOME_BANCO = "tsunami";
    static final String TABELA = "produtos";
    static final String ID = "id";
    static final String DATA = "data";
    static final String DESCRICAO = "descricao";
    static final int VERSAO = 1;

    public SQLHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + TABELA + "(" +
            ID + " PRIMARY KEY AUTOINCREMENT," +
            DATA + "DATE," +
            DESCRICAO + "TEXT"+
            ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
