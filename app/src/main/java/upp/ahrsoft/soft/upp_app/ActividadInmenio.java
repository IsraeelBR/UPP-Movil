package upp.ahrsoft.soft.upp_app;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by alfre on 26/09/2015.
 */
public class ActividadInmenio extends AppCompatActivity {

    // INI AGREGADO
    private WebView mWebView;
    // FIN AGREGADO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_inmenio);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contenedor_inmenio, new FragmentoConfiguracion());
        ft.commit();

        agregarToolbar();


// INI AGREGADO
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        // Activamos Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Url que carga la app (webview)
        mWebView.loadUrl("http://issuu.com/inmenio");
        // Forzamos el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
        // Forzamos el webview para que abra los enlaces externos en el navegador
        mWebView.setWebViewClient(new WebSimci());
        // FIN AGREGADO
    }


    // INI AGREGADO
    @Override
    // Detectar cuando se presiona el botón de retroceso
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    // FIN AGREGADO


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
