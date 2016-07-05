package com.example.a41587805.tp3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a41587805.tp3.model.BotonJuego;
import com.example.a41587805.tp3.model.Resultado;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private FragmentTabHost tabHost;
    private String userName="";
    private TextView navUserName;
    ArrayList<Resultado> Resultados;
    baseTP3SQLiteHelper accesoBaseTP3;
    SQLiteDatabase baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        inicializarToolbar(); // Setear Toolbar como action bar
        inicializarTabs(); // Crear los tabs

        Resultados = new ArrayList<>();

        accesoBaseTP3= new baseTP3SQLiteHelper(this, "baseTP3",null, 1);
        baseDatos= accesoBaseTP3.getWritableDatabase();

        if (basedeDatosAbierta()== true) {
            Cursor conjuntodRegistros;
            conjuntodRegistros= baseDatos.rawQuery("select nombre, movimientos, cantidad from resultados",null);

            if (conjuntodRegistros.moveToFirst() == true){
                int cantidadRegistros=0;
                do {
                    cantidadRegistros++;
                    String nombre = conjuntodRegistros.getString(0);
                    String movimientos = conjuntodRegistros.getString(1);
                    int cant = conjuntodRegistros.getInt(2);
                    Resultado r = new Resultado(nombre, movimientos, cant);
                    Resultados.add(r);
                } while (conjuntodRegistros.moveToNext() == true);
            }
        }

    }

    private void inicializarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setearListener(navigationView);
        navUserName = (TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_username);
    }

    private void inicializarTabs() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                JuegoFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                ResultadoFragment.class, null);
    }


    // Listener de los clicks en el drawer
    private void setearListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                switch(item.getItemId()) {
                    case R.id.nav_user:
                        Log.d("Choose:","Send");
                        FragmentManager fm = getSupportFragmentManager();
                        UserNameDialog userNameDialog = new UserNameDialog();
                        userNameDialog.show(fm, "fragment_edit_name");
                        break;
                    case R.id.nav_background:
                        //cambiar el color
                        FragmentManager fm2 = getSupportFragmentManager();
                        BackgroundDialog backgroundDialog = new BackgroundDialog();
                        backgroundDialog.show(fm2, "fragment_edit_background");

                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

    }


    // Abre el drawer al clickear el burger
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUserName (String userName) {
        this.userName = userName;  // Setear variable de clase
        navUserName.setText(userName); // Setear el texto en la cabecera del drawer
    }

    public String getUserName() {
        return userName;
    }

    public void setResultados (ArrayList<Resultado> resultados) { Resultados = resultados; }

    public ArrayList<Resultado> getResultados() { return Resultados; }

    public SQLiteDatabase getBaseDatos() {
        return baseDatos;
    }

    Boolean basedeDatosAbierta()
    {
        Boolean responder;
        accesoBaseTP3 = new baseTP3SQLiteHelper(this, "baseTP3", null, 1);
        baseDatos= accesoBaseTP3.getWritableDatabase();
        if (baseDatos!= null)
        {
            responder= true;
        }
        else
        {
            responder= false;
        }
        return responder;
    }

    public void setColor(int color){
        switch (color){
            case 0:
            tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Rosa));
                break;

            case 1:
            tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Azul));
                break;

            case 2:
            tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Rojo));
                break;

        }
    }


}
