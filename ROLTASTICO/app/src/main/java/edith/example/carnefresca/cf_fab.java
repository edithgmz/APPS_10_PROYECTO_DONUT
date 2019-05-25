package edith.example.carnefresca;

import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import edith.example.roltastico.Dado;
import edith.example.roltastico.R;

public class cf_fab extends AppCompatActivity {

    FloatingActionButton dificil;
    FloatingActionMenu fMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cf_fab);
      /*  fMenu = findViewById(R.id.menu);
        fMenu.setClosedOnTouchOutside(true);
        dificil= findViewById(R.id.dificil);
      */
        }


        public void calcula ( int tiradas, int necesarias){
            int j = 0;
            String salida = "[", r = "fracaso";
            int tit1, tit2;
            for (int i = 0; i <= tiradas; i++) {
                if (i != 0)
                    salida += ",";
                tit1 = (int) (Math.random() * 6 + 1);
                tit2 = (int) (Math.random() * 6 + 1);
                if (tit1 > 3)
                    if (tit2 > 3)
                        r = "éxito";
            }
            salida += "]," + r;
            //Toast.makeText(this, "salida",Toast.LENGTH_SHORT).show();
        }


       /*
        switch (view.getId()) {
            case (R.id.facil):
                //calcula(2,1);
                break;
            case (R.id.medio):
                calcula(1,1);
                break;
            case (R.id.dificil):
                calcula(2,2);
                break;
            case (R.id.muyDificil):
                calcula(3,3);
                break;

        } */


        public void onclickDif (View view){
            System.out.println("fala");
        }

}
