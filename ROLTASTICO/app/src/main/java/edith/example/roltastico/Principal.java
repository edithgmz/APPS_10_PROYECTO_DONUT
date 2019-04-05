package edith.example.roltastico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Button[] btnMenu;
    Intent dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//falta el cambio de presionar botón a otro menú
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnMenu= new Button[]{findViewById(R.id.btnRw), findViewById(R.id.btnVO),//falta un sistema
                findViewById(R.id.btnDados)};
        dados = new Intent(this,  Dados.class);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnDice:
                startActivity(dados);
                Toast.makeText(this,"cambiar pantalla",Toast.LENGTH_SHORT).show();
                break;
             default:
                 Toast.makeText(this,"no está listo",Toast.LENGTH_SHORT).show();
        }

    }
}
