package edith.example.CfDatos;

import android.widget.ImageView;

public class General {
    ImageView imagen;
    String strNombre;
    String strRasFis;

    public General(ImageView imagen, String strNombre, String strRasFis) {
        this.imagen = imagen;
        this.strNombre = strNombre;
        this.strRasFis = strRasFis;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrRasFis() {
        return strRasFis;
    }

    public void setStrRasFis(String strRasFis) {
        this.strRasFis = strRasFis;
    }
}
