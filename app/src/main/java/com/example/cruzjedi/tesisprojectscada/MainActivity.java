package com.example.cruzjedi.tesisprojectscada;

// SQl Clases Example taked from

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cruzjedi.tesisprojectscada.ui.fragments.HypedArtistsFragment;
import com.example.cruzjedi.tesisprojectscada.ui.fragments.ControlAsistenciaFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    //ImageView imageview1 = (ImageView) findViewById(R.id.ESIMEimageView);
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//For toolbar

        /*btnSubmit.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {

	            Toast.makeText(MyAndroidAppActivity.this,
		        "OnClickListener : " +
                    "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                    "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
			    Toast.LENGTH_SHORT).show();
	            }

	        });
        }
    }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Retrieve spinner information
        //handleSpiners();
        //SQL
        //sqlThread.start();
    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_control_asistencia) {
            Toast.makeText(this, "Control de Asistencia", Toast.LENGTH_SHORT).show();
            replaceFragment(new ControlAsistenciaFragment());
        } else if (id == R.id.nav_materias_del_dia)   {
            replaceFragment(new HypedArtistsFragment());
        }else if(id == R.id.nav_manage){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
/*
//getSupportFragmentManager().beginTransaction()
.add(R.id.content_main, new ControlAsistenciaFragment())
        .add(R.id.content_main, new HypedArtistsFragment())
        .commit();//nos permite añadir otros fragmentos de un jalon
//.add(R.id.id_otro_contenedorActivity , new ArtistoooFragment());*/
