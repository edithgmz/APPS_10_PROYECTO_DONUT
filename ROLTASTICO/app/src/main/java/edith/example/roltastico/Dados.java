package edith.example.roltastico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class Dados extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
    }
    @Override
    public void rollDice(View view) {
        Random random = new Random();
        String sal;
        Toast.makeText(this, "soy un evento, buenas tardes",Toast.LENGTH_LONG).show();
        switch (view.getId()){//el nextInt solo genera números enteros entre 0 y n, n es el parámetro
            case R.id.btn1d4://con return, viviendo al límite
                sal =""+ random.nextInt(4)+1;//entre 0 y 4 sin llegar a 4 (osea del 0 al 3) +1 es del 1 al 4
//número aleatorio del 1 al 4
                break;
            case R.id.btn1d6://max)+1
                sal= ""+ random.nextInt(6)+1;//del 0 al 6 sin llegar a 6(0-5)+ 1 es 1-6
                //número aleatorio del 1 al 6
                break;
            case R.id.btn1d8
                sal=""+ random.nextInt(8)+1; //lo mismo de antes
                break;
            case R.id.btn1d20
                sal=""+ random.nextInt(20)+1;//pero con 20
            case R.id.btn1d100
                sal = ""+random.nextInt(100)+1;//y 100
        }
        //el Toast es temporal
        Toast.makeText(this,sal,Toast.LENGTH_LONG).show();
    }
}
