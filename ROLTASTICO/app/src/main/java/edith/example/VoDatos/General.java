package edith.example.VoDatos;

public class General {
   private String strClase;
   private String strNivAdq;
   private int iPx;
   private String strNombre;
   private int intNiv;
   private String strTranf;
   private String strTal1;
   private String strTal2;

    public void setStrClase(String strClase) {
        this.strClase = strClase;
    }

    public void setStrNivAdq(String strNivAdq) {
        this.strNivAdq = strNivAdq;
    }

    public void setiPx(int iPx) {
        this.iPx = iPx;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public void setIntNiv(int intNiv) {
        this.intNiv = intNiv;
    }

    public void setStrTranf(String strTranf) {
        this.strTranf = strTranf;
    }

    public void setStrTal1(String strTal1) {
        this.strTal1 = strTal1;
    }

    public void setStrTal2(String strTal2) {
        this.strTal2 = strTal2;
    }

    public String getStrClase() {
        return strClase;
    }

    public String getStrNivAdq() {
        return strNivAdq;
    }

    public int getiPx() {
        return iPx;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public int getIntNiv() {
        return intNiv;
    }

    public String getStrTranf() {
        return strTranf;
    }

    public String getStrTal1() {
        return strTal1;
    }

    public String getStrTal2() {
        return strTal2;
    }

    public General(String strClase, String strNivAdq, int iPx, String strNombre, int intNiv, String strTranf, String strTal1, String strTal2) {
        this.strClase = strClase;
        this.strNivAdq = strNivAdq;
        this.iPx = iPx;
        this.strNombre = strNombre;
        this.intNiv = intNiv;
        this.strTranf = strTranf;
        this.strTal1 = strTal1;
        this.strTal2 = strTal2;
    }
}
