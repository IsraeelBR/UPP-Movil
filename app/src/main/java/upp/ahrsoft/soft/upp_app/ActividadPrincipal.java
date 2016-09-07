package upp.ahrsoft.soft.upp_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;



import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ActividadPrincipal extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        agregarToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            prepararDrawer(navigationView);
            // Seleccionar item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }






    }

    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }


    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        seleccionarItem(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });


    }

    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
                case R.id.item_inicio:
                    fragmentoGenerico = new FragmentoInicio();
                    break;
                case R.id.item_cuenta:
                    fragmentoGenerico = new FragmentoOferta();
                    break;
                case R.id.item_categorias:
                    startActivity(new Intent(this, ActividadInmenio.class));
                    break;
                case R.id.item_configuracion:
                    startActivity(new Intent(this, ActividadSimci.class));
                    break;
                case R.id.item_correo:
                    startActivity(new Intent(this, ActividadCorreoUPP.class));
                    break;


            case R.id.item_deportivo:
                Toast.makeText(ActividadPrincipal.this, "Parte de Deportivo la plata", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_galeria:
                Toast.makeText(ActividadPrincipal.this,"Parte de Galeria",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_facebook:
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.facebook.com/UPPachuca"));
                startActivity(browserIntent);
                break;
            case R.id.nav_twitter:
                Intent browserIntent2 =
                        new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://twitter.com/#!/UPPachuca"));
                startActivity(browserIntent2);
                break;
            case R.id.nav_youtube:
                Intent browserIntent3 =
                        new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.youtube.com/user/uppachuca/"));
                startActivity(browserIntent3);
                break;

            case R.id.nav_tuopinion:
                startActivity(new Intent(this, ActividadCorreo.class));
                break;
        }




        if (fragmentoGenerico != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();




        }



        // Setear título actual
        setTitle(itemDrawer.getTitle());





    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}