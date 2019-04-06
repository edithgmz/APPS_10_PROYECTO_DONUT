package edith.example.roltastico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    Button[] btnMenu;
    Intent inDados, inSistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//falta el cambio de presionar botón a otro menú
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnMenu = new Button[]{
                findViewById(R.id.btnRW),
                findViewById(R.id.btnVO),
                findViewById(R.id.btnCF),
                findViewById(R.id.btnDados)
        };

        inDados = new Intent(this, Dados.class);
        inSistema = new Intent(this, Sistema.class);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnDados:
                startActivity(inDados);
                Toast.makeText(this,"cambiar pantalla",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRW:
                startActivity(inSistema);
                Toast.makeText(this, "cambiar pantalla", Toast.LENGTH_SHORT).show();
                break;
             default:
                 Toast.makeText(this,"no está listo",Toast.LENGTH_SHORT).show();
        }
    }
}
