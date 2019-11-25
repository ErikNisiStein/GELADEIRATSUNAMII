package com.example.geladeiratsunamii;

import java.util.ArrayList;

public class Dados
{
    String desc;
    String data;

    public Dados(String desc, String data) {
        this.desc = desc;
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public String getData() {
        return data;
    }

    public static ArrayList<Dados> lista = new ArrayList<>();

}
