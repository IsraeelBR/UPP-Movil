package upp.ahrsoft.soft.upp_app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;


/**
 * Created by alfre on 26/09/2015.
 */
public class FragmentoHistoria extends Fragment {

    public FragmentoHistoria() {
    }

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_historia, container, false);

       // FloatingActionButton botonflotante = (FloatingActionButton)getView().findViewById(R.id.botonflotantemap);
      //  botonflotante.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
            // startActivity(ActividadMapa.class);
       //     }
        //});
    }

}
