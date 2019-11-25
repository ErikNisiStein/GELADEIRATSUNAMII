package com.example.geladeiratsunamii;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Adaptador extends ArrayAdapter<Dados>
{
    Context desc;
    ArrayList<Dados> produtos;

    public Adaptador (Context desc, ArrayList<Dados> produtos)
    {
        super(desc, R.layout.modelo);
        this.desc = desc;
        this.produtos = produtos;
        Log.d("adaptador", String.valueOf(this.produtos.size()));
    }

    @Override
    public int getCount() {
        return this.produtos.size();
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(desc);
        View view = inflater.inflate(R.layout.modelo, null, true);

        Button ButtonDelete = view.findViewById(R.id.botaoDelete);
        TextView textViewDesc = view.findViewById(R.id.descricao);
        TextView textViewData = view.findViewById(R.id.dataDeValidade);
        textViewDesc.setText(this.produtos.get(position).desc);
        textViewData.setText(this.produtos.get(position).data);
        ButtonDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                produtos.remove(position);
                notifyDataSetChanged();
            }
        });
        String val = this.produtos.get(position).data;
        try
        {
            Date valData = new SimpleDateFormat("dd/MM/yyyy").parse(val);
            long teste = valData.getTime() - new Date().getTime();
            if (teste <= 0)
            {
                view.setBackgroundColor(Color.rgb(255,179,179));
            }
        }
        catch (ParseException erro)
        {
            Log.e("ERRODATA", erro.getMessage());
        }


        return view;
    }
}
