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
import android.widget.Toast;

import com.example.a41587805.tp3.model.BotonJuego;
import com.example.a41587805.tp3.model.Resultado;

import java.util.ArrayList;

/**
 * Created by 41587805 on 21/6/2016.
 */
public class JuegoFragment extends Fragment implements View.OnClickListener {

    BotonJuego btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9;
    String usuario;
    String movimientos="";
    int cantidad=0;
    MainActivity ma;
    Resultado resul;
    ArrayList<Resultado> resultados;

    public JuegoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.juego_fragment, container, false);

        btn1 = (BotonJuego)(view.findViewById(R.id.btn1));
        btn2 = (BotonJuego)(view.findViewById(R.id.btn2));
        btn3 = (BotonJuego)(view.findViewById(R.id.btn3));
        btn4 = (BotonJuego)(view.findViewById(R.id.btn4));
        btn5 = (BotonJuego)(view.findViewById(R.id.btn5));
        btn6 = (BotonJuego)(view.findViewById(R.id.btn6));
        btn7 = (BotonJuego)(view.findViewById(R.id.btn7));
        btn8 = (BotonJuego)(view.findViewById(R.id.btn8));
        btn9 = (BotonJuego)(view.findViewById(R.id.btn9));
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        ma = (MainActivity) getActivity();
        usuario = ma.getUserName();
        resultados = new ArrayList<>();
        ma.setResultados(resultados);

        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                movimientos+= "1 ";
                cantidad++;
                btn2.flip();
                btn4.flip();
                break;

            case R.id.btn2:
                movimientos+= "2 ";
                cantidad++;
                btn1.flip();
                btn3.flip();
                btn5.flip();
                break;

            case R.id.btn3:
                movimientos+= "3 ";
                cantidad++;
                btn2.flip();
                btn6.flip();
                break;

            case R.id.btn4:
                movimientos+= "4 ";
                cantidad++;
                btn1.flip();
                btn5.flip();
                btn7.flip();
                break;

            case R.id.btn5:
                movimientos+= "5 ";
                cantidad++;
                btn2.flip();
                btn6.flip();
                btn4.flip();
                btn8.flip();
                break;

            case R.id.btn6:
                movimientos+= "6 ";
                cantidad++;
                btn3.flip();
                btn5.flip();
                btn9.flip();
                break;

            case R.id.btn7:
                movimientos+= "7 ";
                cantidad++;
                btn4.flip();
                btn8.flip();
                break;

            case R.id.btn8:
                movimientos+= "8 ";
                cantidad++;
                btn9.flip();
                btn5.flip();
                btn7.flip();
                break;

            case R.id.btn9:
                movimientos+= "9 ";
                cantidad++;
                btn8.flip();
                btn6.flip();
                break;
        }

        if ((btn1.isEstado() == true && btn2.isEstado() == true && btn3.isEstado() == true && btn4.isEstado() == true && btn5.isEstado() == true && btn6.isEstado() == true && btn7.isEstado() == true && btn8.isEstado() == true && btn9.isEstado() == true)
                ||  (btn1.isEstado() == false && btn2.isEstado() == false && btn3.isEstado() == false && btn4.isEstado() == false && btn5.isEstado() == false && btn6.isEstado() == false && btn7.isEstado() == false && btn8.isEstado() == false && btn9.isEstado() == false))
        {
            resul = new Resultado(usuario, movimientos, cantidad);
            resultados.add(resul);

            Toast mensaje = Toast.makeText(view.getContext(),"Ganaste",Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.juego,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_refresh:
                Log.d("refresh", "ison");
                resul = new Resultado(usuario, movimientos, cantidad);
                resultados.add(resul);
                btn1.reset();
                btn2.reset();
                btn3.reset();
                btn4.reset();
                btn5.reset();
                btn6.reset();
                btn7.reset();
                btn8.reset();
                btn9.reset();
                //hacer que haya minimo uno diferente para que no venga ganado
                cantidad=0;
                movimientos="";
                break;
        }
        return true;
}
}
