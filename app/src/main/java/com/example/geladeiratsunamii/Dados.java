package com.example.geladeiratsunamii;

import java.util.ArrayList;

public class Dados
{
    Integer id;
    String desc;
    String data;

    public Dados(Integer id, String desc, String data) {
        this.desc = desc;
        this.data = data;
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public String getData() {
        return data;
    }

    public static ArrayList<Dados> lista = new ArrayList<>();

}
