package com.example.a41587805.tp3.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.example.a41587805.tp3.R;

import java.util.Random;

/**
 * Created by 41587805 on 21/6/2016.
 */
public class BotonJuego extends ImageButton {


    boolean estado;
    Random random;

    public BotonJuego(Context context, AttributeSet attrs) {
        super(context, attrs);
        random = new Random();
        estado= random.nextBoolean();
        pintar();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void pintar()
    {
        if (estado)
        {
            this.setImageResource(R.drawable.ficha1);
        }
        else
        {
            this.setImageResource(R.drawable.ficha2);
        }

    }
    public void flip()//obtiene y cambia el estado
    {
        estado = !estado;
        pintar();
    }

    public void reset()
    {
        estado= random.nextBoolean();
        pintar();
    }

}
