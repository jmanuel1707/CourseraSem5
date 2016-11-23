package com.sanchez.jose.aplicacionmascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public static ArrayList<Mascota> mascotasFavoritasArray;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        /*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
        */




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavorito:
                Intent intentFavorito = new Intent(MainActivity.this, MascotasFavoritas.class);
                MainActivity.this.startActivity(intentFavorito);
                break;

            case R.id.mAcercaDe:
                Toast.makeText(this, "Acerca De",Toast.LENGTH_SHORT).show();
                Intent intentAcercaDe = new Intent(MainActivity.this, AcercaDe.class);
                MainActivity.this.startActivity(intentAcercaDe);

                break;

            case R.id.mContacto:
                Intent intentContacto = new Intent(MainActivity.this, Contacto.class);
                MainActivity.this.startActivity(intentContacto);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        if (Mascota.mascotas.size() == 0){
            Mascota.mascotas.add(new Mascota("Sparky",false, 3, R.drawable.perro1));
            Mascota.mascotas.add(new Mascota("Munchy",false, 2, R.drawable.perro2));
            Mascota.mascotas.add(new Mascota("Pirulin",false, 4, R.drawable.perro3));
            Mascota.mascotas.add(new Mascota("Neron",false, 1, R.drawable.perro4));
            Mascota.mascotas.add(new Mascota("Milo",false, 3, R.drawable.perro5));
        }

        mascotas = Mascota.mascotas;

    }



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaMascotasFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }



    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile);
    }



}
