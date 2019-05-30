package edith.example.fichas;
/*
 * Created by Edith on 28-May-19.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import edith.example.roltastico.R;

public class FichaAdapter extends ArrayAdapter<Ficha> {
    Bitmap bImagen;
    private Context cApp;
    private int iLayFicha;
    //Lista de fichas
    private ArrayList<Ficha> alFichas;

    public FichaAdapter(Context context, int resource, ArrayList<Ficha> objects) {
        super(context, resource, objects);
        cApp = context;
        iLayFicha = resource;
        alFichas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwPer;
        TextView txtVwNom, txtVwSis, txtVwAtr;
        View vwLayFicha = convertView;

        //Si el layout no existe lo crea
        if (vwLayFicha == null) {
            LayoutInflater liCrearLayout = ((Activity) cApp).getLayoutInflater();
            vwLayFicha = liCrearLayout.inflate(iLayFicha, parent, false);
        }

        //Se vinculan los elementos de la actividad
        imgVwPer = vwLayFicha.findViewById(R.id.imgVwPer);
        txtVwNom = vwLayFicha.findViewById(R.id.txtVwNom);
        txtVwSis = vwLayFicha.findViewById(R.id.txtVwSis);
        txtVwAtr = vwLayFicha.findViewById(R.id.txtVwAtr);

        //Crea una lista de fichas con la lista obtenida del constructor
        ArrayList<Ficha> alFicha = alFichas;
        if (alFicha != null) {
            try {
                bImagen = ImageLoader.init().from(alFicha.get(position).getImg()).getBitmap();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Se colocan los datos de la lista en los elementos de la actividad
            if (bImagen != null)
                imgVwPer.setImageBitmap(bImagen);
            else
                imgVwPer.setImageResource(R.drawable.cam);
            txtVwNom.setText(alFicha.get(position).getNom());
            txtVwSis.setText(alFicha.get(position).getSis());
            txtVwAtr.setText(alFicha.get(position).getAtr());
        }

        return vwLayFicha;
    }
}
