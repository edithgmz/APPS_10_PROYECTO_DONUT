package edith.example.roltastico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Dados extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
    }

    public void rollDice(View view) {
        String num = null;
        switch (view.getId()) {
            case R.id.btn1d4:
                num = "" + (int) (Math.random() * 4 + 1);//1 a 4
                break;
            case R.id.btn1d6:
                num = "" + (int) (Math.random() * 6 + 1);//1 a 6
                break;
            case R.id.btn1d8:
                num = "" + (int) (Math.random() * 8 + 1); //1 a 8
                break;
            case R.id.btn1d20:
                num = "" + (int) (Math.random() * 20 + 1);//1 a 20
                break;
            case R.id.btn1d100:
                num = "" + (int) (Math.random() * 99);//0 a 99
                break;
        }
        Toast.makeText(this, num, Toast.LENGTH_SHORT).show();
    }
}
