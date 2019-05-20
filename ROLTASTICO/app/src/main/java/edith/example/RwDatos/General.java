package edith.example.RwDatos;

public class General {
    private String strNombre;
    private boolean isFem; //género
    private boolean isHum; //humano o fauno
    private String strColor;
    private String strCabello;
    private String strOjos;
    private String strArmNom;
    private String strArmDesc;

    public General(String strNombre, boolean isFem, boolean isHum, String strColor, String strCabello, String strOjos, String strArmNom, String strArmDesc) {
        this.strNombre = strNombre;
        this.isFem = isFem;
        this.isHum = isHum;
        this.strColor = strColor;
        this.strCabello = strCabello;
        this.strOjos = strOjos;
        this.strArmNom = strArmNom;
        this.strArmDesc = strArmDesc;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public boolean isFem() {
        return isFem;
    }

    public void setFem(boolean fem) {
        isFem = fem;
    }

    public boolean isHum() {
        return isHum;
    }

    public void setHum(boolean hum) {
        isHum = hum;
    }

    public String getStrColor() {
        return strColor;
    }

    public void setStrColor(String strColor) {
        this.strColor = strColor;
    }

    public String getStrCabello() {
        return strCabello;
    }

    public void setStrCabello(String strCabello) {
        this.strCabello = strCabello;
    }

    public String getStrOjos() {
        return strOjos;
    }

    public void setStrOjos(String strOjos) {
        this.strOjos = strOjos;
    }

    public String getStrArmNom() {
        return strArmNom;
    }

    public void setStrArmNom(String strArmNom) {
        this.strArmNom = strArmNom;
    }

    public String getStrArmDesc() {
        return strArmDesc;
    }

    public void setStrArmDesc(String strArmDesc) {
        this.strArmDesc = strArmDesc;
    }
}
