package edith.example.fichas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edith.example.datos.BaseDatos;
import edith.example.roltastico.R;

public class Fichas extends AppCompatActivity {
    private ListView lstVwFichas;
    //Controlador de la base de datos
    private BaseDatos baseDatos;
    //Lista de fichas
    private ArrayList<Ficha> alFichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas);
        //Iniciar controlador de la base de datos
        baseDatos = new BaseDatos(this);
        //Iniciar la lista de fichas de CF
        alFichas = baseDatos.fichas();
        if (alFichas.isEmpty())
            Toast.makeText(this, "Aún no has guardado fichas.", Toast.LENGTH_LONG).show();
        //Se vincula la lista, agrega el adaptador y el listener
        lstVwFichas = findViewById(R.id.lstVwFichas);
        lstVwFichas.setAdapter(new FichaAdapter(this, R.layout.layout_ficha, alFichas));
    }
}
