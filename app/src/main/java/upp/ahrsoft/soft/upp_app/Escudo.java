package upp.ahrsoft.soft.upp_app;

/**
 * Created by Destroy on 04/08/2016.
 */
public class Escudo {
    private String nombre;
    private int idDrawable;

    public Escudo(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Escudo[] ITEMS = {
            new  Escudo("Jaguar F-Type 2015", R.drawable.jaguar_f_type_2015),
            new  Escudo("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt),
            new  Escudo("Mazda MX-5", R.drawable.mazda_mx5_2015),
            new  Escudo("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new  Escudo("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new  Escudo("Ford Mondeo", R.drawable.ford_mondeo),
            new  Escudo("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new  Escudo("Jaguar XE", R.drawable.jaguar_xe),
            new  Escudo("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new  Escudo("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador

     */
    public static  Escudo getItem(int id) {
        for ( Escudo item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}


