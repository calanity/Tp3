package com.example.a41587805.tp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.a41587805.tp3.model.Resultado;

import java.util.ArrayList;

/**
 * Created by 41587805 on 21/6/2016.
 */
public class ResultadoFragment extends Fragment {

    MainActivity ma;
    ArrayList<Resultado> resultados;
    ResultadosAdapter adapter;
    ListView lista;

    public ResultadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.resultado_fragment, container, false);

        lista = (ListView) view.findViewById(R.id.listview);

        resultados = new ArrayList<>();
        ma = (MainActivity) getActivity();
        resultados = ma.getResultados();

        adapter = new ResultadosAdapter(getActivity().getApplicationContext(), resultados);
        lista.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.resultado,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_delete:
                Log.d("borrar", "ison");
                resultados.clear();
                adapter.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
