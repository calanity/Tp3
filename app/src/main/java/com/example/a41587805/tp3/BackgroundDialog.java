package com.example.a41587805.tp3;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by 41587805 on 5/7/2016.
 */
public class BackgroundDialog extends DialogFragment {

    MainActivity ma;
    ArrayList<String> datosSpinner;
    ArrayAdapter<String> adaptador;
    Spinner spinner;

    public BackgroundDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.background_dialog, container);

        datosSpinner = new ArrayList<>();
        datosSpinner.add("Rosa");
        datosSpinner.add("Azul");
        datosSpinner.add("Rojo");

        adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, datosSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);

        ma = (MainActivity) getActivity();

        Button b = (Button) view.findViewById(R.id.aceptar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","OK");
                //CAMBIAR EL COLOR
                int color = spinner.getSelectedItemPosition();
                ma.setColor(color);
                dismiss();
            }
        });
        getDialog().setTitle("Elija color de fondo");

        return view;
    }

}


