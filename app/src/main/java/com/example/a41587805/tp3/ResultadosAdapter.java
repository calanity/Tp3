package com.example.a41587805.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a41587805.tp3.model.Resultado;

import java.util.ArrayList;

/**
 * Created by 41587805 on 28/6/2016.
 */
public class ResultadosAdapter extends BaseAdapter {

    ArrayList<Resultado> resultados;
    Context context;

    public ResultadosAdapter(Context context, ArrayList<Resultado> resultados) {
        this.context = context;
        this.resultados=resultados;
    }

    @Override
    public int getCount() {
        return resultados.size();
    }

    @Override
    public Object getItem(int i) {
        return resultados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.obj_resultado, viewGroup, false);
        }

        TextView nombre = (TextView)view.findViewById(R.id.nombre);
        TextView movimientos = (TextView)view.findViewById(R.id.movimientos);
        TextView cantidad = (TextView)view.findViewById(R.id.cantidad);
        TextView gano= (TextView)view.findViewById(R.id.gano);

        Resultado r = resultados.get(position);
        nombre.setText("Nombre: " + r.getNombre());
        movimientos.setText("Movimientos: " + r.getMovimientos());
        cantidad.setText("Cantidad: " + r.getCantidad());
        if(r.getGanaste()==1)
        {
            gano.setText("No ganó");
        }

        if(r.getGanaste()==2)
        {
            gano.setText("Ganó :)");
        }
        return view;
    }
}
