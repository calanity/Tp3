package com.example.a41587805.tp3;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        inicializarToolbar(); // Setear Toolbar como action bar
        inicializarTabs(); // Crear los tabs


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


}
