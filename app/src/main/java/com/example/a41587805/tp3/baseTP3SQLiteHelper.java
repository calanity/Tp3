package com.example.a41587805.tp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 41587805 on 5/7/2016.
 */
public class baseTP3SQLiteHelper extends SQLiteOpenHelper {

    public baseTP3SQLiteHelper(Context contexto , String Nombre, SQLiteDatabase.CursorFactory fabrica,int version)
    {
        super(contexto, Nombre, fabrica, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {
        String sqlCrearTablaResultados;
        sqlCrearTablaResultados= "create table resultados(nombre text, cantidad integer , movimientos text, gano integer)";
        baseDatos.execSQL(sqlCrearTablaResultados);

    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDatos, int versionAnterior, int versionNueva) {

    }


}
