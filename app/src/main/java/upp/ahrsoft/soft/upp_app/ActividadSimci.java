package upp.ahrsoft.soft.upp_app;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by alfre on 26/09/2015.
 */
public class ActividadSimci extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_simciinicio);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contenedor_simci, new FragmentoConfiguracion());
        ft.commit();

        agregarToolbar();

        FloatingActionButton botonflotante = (FloatingActionButton) findViewById(R.id.fab);
        botonflotante.setOnClickListener(new View.OnClickListener(){

            @Override
        public void onClick(View v){
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.upp.edu.mx/simci/"));
                startActivity(browserIntent);
            }

        });

    }

    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class FragmentoConfiguracion extends PreferenceFragment {

        public FragmentoConfiguracion() {
            // Constructor Por Defecto
        }


    }
}
