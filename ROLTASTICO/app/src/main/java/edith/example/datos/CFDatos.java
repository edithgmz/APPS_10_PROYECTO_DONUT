package edith.example.datos;

public class CFDatos {
    //general
    private String strImagen;
    private String strNombre;
    private String strRasFis;
    private int isFem; //género

    //cuerpo
    private String sCabeza;
    private String sBrazoDer;
    private String SBrazoIzq;
    private String sTorso;
    private String sPiernas;

    //rasgos
    private int iBaseD;
    private int iPelD;
    private int iPelAr; //XD
    private int iRes;
    //------------
    private int iConducir;
    private int iPunteria;
    private int iSigilo;
    //------------
    private int iMani;
    private int iArr;
    private int iOcEn;
    private int iPra;
    //------------
    private int iInti;
    private int iConv;
    private int iAten;
    private int iOrie;

    //salud
    private int iDanio;
    private int iTension;

    public CFDatos(String strImagen, String strNombre, String strRasFis, int isFem, String sCabeza, String sBrazoDer, String SBrazoIzq, String sTorso, String sPiernas, int iBaseD, int iPelD, int iPelAr, int iRes, int iConducir, int iPunteria, int iSigilo, int iMani, int iArr, int iOcEn, int iPra, int iInti, int iConv, int iAten, int iOrie, int iDanio, int iTension) {
        this.strImagen = strImagen;
        this.strNombre = strNombre;
        this.strRasFis = strRasFis;
        this.isFem = isFem;
        this.sCabeza = sCabeza;
        this.sBrazoDer = sBrazoDer;
        this.SBrazoIzq = SBrazoIzq;
        this.sTorso = sTorso;
        this.sPiernas = sPiernas;
        this.iBaseD = iBaseD;
        this.iPelD = iPelD;
        this.iPelAr = iPelAr;
        this.iRes = iRes;
        this.iConducir = iConducir;
        this.iPunteria = iPunteria;
        this.iSigilo = iSigilo;
        this.iMani = iMani;
        this.iArr = iArr;
        this.iOcEn = iOcEn;
        this.iPra = iPra;
        this.iInti = iInti;
        this.iConv = iConv;
        this.iAten = iAten;
        this.iOrie = iOrie;
        this.iDanio = iDanio;
        this.iTension = iTension;
    }

    public String getStrImagen() {
        return strImagen;
    }

    public void setStrImagen(String strImagen) {
        this.strImagen = strImagen;
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

    public int isFem() {
        return isFem;
    }

    public String getsCabeza() {
        return sCabeza;
    }

    public void setsCabeza(String sCabeza) {
        this.sCabeza = sCabeza;
    }

    public String getsBrazoDer() {
        return sBrazoDer;
    }

    public void setsBrazoDer(String sBrazoDer) {
        this.sBrazoDer = sBrazoDer;
    }

    public String getSBrazoIzq() {
        return SBrazoIzq;
    }

    public void setSBrazoIzq(String SBrazoIzq) {
        this.SBrazoIzq = SBrazoIzq;
    }

    public String getsTorso() {
        return sTorso;
    }

    public void setsTorso(String sTorso) {
        this.sTorso = sTorso;
    }

    public String getsPiernas() {
        return sPiernas;
    }

    public void setsPiernas(String sPiernas) {
        this.sPiernas = sPiernas;
    }

    public int getiBaseD() {
        return iBaseD;
    }

    public void setiBaseD(int iBaseD) {
        this.iBaseD = iBaseD;
    }

    public int getiPelD() {
        return iPelD;
    }

    public void setiPelD(int iPelD) {
        this.iPelD = iPelD;
    }

    public int getiPelAr() {
        return iPelAr;
    }

    public void setiPelAr(int iPelAr) {
        this.iPelAr = iPelAr;
    }

    public int getiRes() {
        return iRes;
    }

    public void setiRes(int iRes) {
        this.iRes = iRes;
    }

    public int getiConducir() {
        return iConducir;
    }

    public void setiConducir(int iConducir) {
        this.iConducir = iConducir;
    }

    public int getiPunteria() {
        return iPunteria;
    }

    public void setiPunteria(int iPunteria) {
        this.iPunteria = iPunteria;
    }

    public int getiSigilo() {
        return iSigilo;
    }

    public void setiSigilo(int iSigilo) {
        this.iSigilo = iSigilo;
    }

    public int getiMani() {
        return iMani;
    }

    public void setiMani(int iMani) {
        this.iMani = iMani;
    }

    public int getiArr() {
        return iArr;
    }

    public void setiArr(int iArr) {
        this.iArr = iArr;
    }

    public int getiOcEn() {
        return iOcEn;
    }

    public void setiOcEn(int iOcEn) {
        this.iOcEn = iOcEn;
    }

    public int getiPra() {
        return iPra;
    }

    public void setiPra(int iPra) {
        this.iPra = iPra;
    }

    public int getiInti() {
        return iInti;
    }

    public void setiInti(int iInti) {
        this.iInti = iInti;
    }

    public int getiConv() {
        return iConv;
    }

    public void setiConv(int iConv) {
        this.iConv = iConv;
    }

    public int getiAten() {
        return iAten;
    }

    public void setiAten(int iAten) {
        this.iAten = iAten;
    }

    public int getiOrie() {
        return iOrie;
    }

    public void setiOrie(int iOrie) {
        this.iOrie = iOrie;
    }

    public int getiDanio() {
        return iDanio;
    }

    public void setiDanio(int iDanio) {
        this.iDanio = iDanio;
    }

    public int getiTension() {
        return iTension;
    }

    public void setiTension(int iTension) {
        this.iTension = iTension;
    }

    public void setFem(int fem) {
        isFem = fem;
    }
}
