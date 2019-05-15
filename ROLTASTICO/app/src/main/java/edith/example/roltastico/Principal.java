package edith.example.roltastico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import edith.example.carnefresca.CarneFresca;
import edith.example.rwby.Rwby;
import edith.example.viejooeste.ViejoOeste;

public class Principal extends AppCompatActivity {
    Button[] btnMenu;
    Intent inDados, inRW, inVO, inCF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnMenu = new Button[]{
                findViewById(R.id.btnRW),
                findViewById(R.id.btnVO),
                findViewById(R.id.btnCF),
                findViewById(R.id.btnDados)
        };

        inDados = new Intent(this, Dados.class);
        inRW = new Intent(this, Rwby.class);
        inVO = new Intent(this, ViejoOeste.class);
        inCF = new Intent(this, CarneFresca.class);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnDados:
                startActivity(inDados);
                break;
            case R.id.btnRW:
                startActivity(inRW);
                break;
            case R.id.btnVO:
                startActivity(inVO);
                break;
            case R.id.btnCF:
                startActivity(inCF);
                break;
        }
    }
}
