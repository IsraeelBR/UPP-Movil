package upp.ahrsoft.soft.upp_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * {@link BaseAdapter} para poblar coches en un grid view
 */

public class AdaptadorDeCoches extends BaseAdapter {
    private Context context;

    public AdaptadorDeCoches(Context context) {
        this.context = context;
    }

    public AdaptadorDeCoches() {

    }


    @Override
    public int getCount() {
        return Escudo.ITEMS.length;
    }

    @Override
    public Escudo getItem(int position) {        return Escudo.ITEMS[position];    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.imagen_coche);
        TextView nombreCoche = (TextView) view.findViewById(R.id.nombre_coche);

        final Escudo item = getItem(position);
        Glide.with(imagenCoche.getContext())
                .load(item.getIdDrawable())
                .into(imagenCoche);

        nombreCoche.setText(item.getNombre());

        return view;
    }

}