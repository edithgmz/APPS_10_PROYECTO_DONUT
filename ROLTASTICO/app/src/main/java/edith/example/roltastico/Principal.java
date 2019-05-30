package edith.example.roltastico;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edith.example.carnefresca.CarneFresca;
import edith.example.fichas.Fichas;
import edith.example.rwby.Rwby;
import edith.example.viejooeste.ViejoOeste;

public class Principal extends AppCompatActivity {
    private final int PERMISO_READ_EXTERNAL_STORAGE = 1111;
    private Button[] btnMenu;
    private Intent inFichas, inRW, inVO, inCF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnMenu = new Button[]{
                findViewById(R.id.btnRW),
                findViewById(R.id.btnVO),
                findViewById(R.id.btnCF),
                findViewById(R.id.btnFichas)
        };

        inFichas = new Intent(this, Fichas.class);
        inRW = new Intent(this, Rwby.class);
        inVO = new Intent(this, ViejoOeste.class);
        inCF = new Intent(this, CarneFresca.class);

        //Verificar permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISO_READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISO_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "Permiso otorgado.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permiso denegado.", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnRW:
                startActivity(inRW);
                break;
            case R.id.btnVO:
                startActivity(inVO);
                break;
            case R.id.btnCF:
                startActivity(inCF);
                break;
            case R.id.btnFichas:
                startActivity(inFichas);
                break;
        }
    }
}
