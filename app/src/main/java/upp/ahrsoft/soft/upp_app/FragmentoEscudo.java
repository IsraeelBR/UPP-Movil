package upp.ahrsoft.soft.upp_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * Created by alfre on 26/09/2015.
 */
public class FragmentoEscudo extends Fragment {

    public FragmentoEscudo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.actividad_detalle, container, false);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Escudo item = (Escudo) parent.getItemAtPosition(position);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


        }

    }
}

