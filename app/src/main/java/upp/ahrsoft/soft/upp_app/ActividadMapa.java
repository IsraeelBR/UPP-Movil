package upp.ahrsoft.soft.upp_app;

/**
 * Created by alfre on 26/09/2015.
 */
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class ActividadMapa extends AppCompatActivity {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mapa);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contenedor_mapa, new ActividadCorreo.FragmentoConfiguracion());
        ft.commit();
        agregarToolbar();



        int codigoGooglePlay = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (codigoGooglePlay != ConnectionResult.SUCCESS) {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(codigoGooglePlay, this, 6);
            if (dialog != null) {
                dialog.show();
            } else {
                Toast.makeText(ActividadMapa.this, "Error al verificar Google Play Services",
                        Toast.LENGTH_LONG);
                finish();
            }
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mySupportMapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
      /*  googleMap = mySupportMapFragment.//getMap();

        if (googleMap != null) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(19.9791609, -98.6837557))
                    .title("UPPachuca")
                    .snippet("Texto Demo"));
        }*/
    }
    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
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
}
