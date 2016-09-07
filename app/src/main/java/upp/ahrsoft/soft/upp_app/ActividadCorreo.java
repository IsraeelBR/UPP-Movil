package upp.ahrsoft.soft.upp_app;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alfre on 03/10/2015.
 */
public class ActividadCorreo extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_correo);

        final Button btnSendMail = (Button) findViewById(R.id.btnEnviarMail);
        btnSendMail.setOnClickListener(this);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contenedor_correo, new FragmentoConfiguracion());
        ft.commit();
        agregarToolbar();
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


    public void onClick(View v){
        //final EditText etDe = (EditText) getView().findViewById(R.id.et_EmailDe);
        final EditText etAsunto = (EditText) findViewById(R.id.et_EmailAsunto);
        final EditText etMensaje = (EditText) findViewById(R.id.et_EmailMensaje);

        //String to = etDe.getText().toString();
        String subject = etAsunto.getText().toString();
        String message = etMensaje.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL  , new String[]{"alfred.black1209@outlook.es"});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        // need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));
    }

}
