package upp.ahrsoft.soft.upp_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alfre on 26/09/2015.
 */
public class FragmentoCalendarios extends Fragment {

    public FragmentoCalendarios() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_calendario, container, false);
    }
}

