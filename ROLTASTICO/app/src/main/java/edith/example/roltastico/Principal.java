package edith.example.roltastico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    int[] btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//falta el cambio de presionar botón a otro menú
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnMenu= new int[]{R.id.btnRw, R.id.btnVO,//falta un sistema
                R.id.btnDados};


    }
}
