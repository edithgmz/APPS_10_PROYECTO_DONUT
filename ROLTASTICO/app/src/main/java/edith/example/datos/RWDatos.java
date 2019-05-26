package edith.example.datos;

public class RWDatos {
    //general
    private String sImagen;
    private String strNombre;
    private int isFem; //género
    private int isHum; //humano o fauno
    private String strCabello;
    private String strOjos;
    private String strArma;

    //rasgos
    //Base
    private int iFue;
    private int iVol;
    private int iAgi;
    private int iPer;
    private int iRes;
    private int iDis;
    //derivado, se inicializan en el constructor
    private int iSalud;
    private int iAura;
    private int iCapa;

    //meele(cuerpo a cuerpo) y distacia
    private int iMelee;
    private int iDista;

    //dust
    private String strDust1;
    private String strDust2;

    //ventaja
    private String strSem;
    private String[] arrStrMod;

    public RWDatos(String sImagen, String strNombre, int isFem, int isHum, String strCabello, String strOjos, String strArma, int iFue, int iVol, int iAgi, int iPer, int iRes, int iDis, int iSalud, int iAura, int iCapa, int iMelee, int iDista, String strDust1, String strDust2, String strSem, String[] arrStrMod) {
        this.sImagen = sImagen;
        this.strNombre = strNombre;
        this.isFem = isFem;
        this.isHum = isHum;
        this.strCabello = strCabello;
        this.strOjos = strOjos;
        this.strArma = strArma;
        this.iFue = iFue;
        this.iVol = iVol;
        this.iAgi = iAgi;
        this.iPer = iPer;
        this.iRes = iRes;
        this.iDis = iDis;
        this.iSalud = iSalud;
        this.iAura = iAura;
        this.iCapa = iCapa;
        this.iMelee = iMelee;
        this.iDista = iDista;
        this.strDust1 = strDust1;
        this.strDust2 = strDust2;
        this.strSem = strSem;
        this.arrStrMod = arrStrMod;
    }

    public String getsImagen() {
        return sImagen;
    }

    public void setsImagen(String sImagen) {
        this.sImagen = sImagen;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public int isFem() {
        return isFem;
    }

    public int isHum() {
        return isHum;
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

    public String getStrArma() {
        return strArma;
    }

    public void setStrArma(String strArma) {
        this.strArma = strArma;
    }

    public int getiFue() {
        return iFue;
    }

    public void setiFue(int iFue) {
        this.iFue = iFue;
    }

    public int getiVol() {
        return iVol;
    }

    public void setiVol(int iVol) {
        this.iVol = iVol;
    }

    public int getiAgi() {
        return iAgi;
    }

    public void setiAgi(int iAgi) {
        this.iAgi = iAgi;
    }

    public int getiPer() {
        return iPer;
    }

    public void setiPer(int iPer) {
        this.iPer = iPer;
    }

    public int getiRes() {
        return iRes;
    }

    public void setiRes(int iRes) {
        this.iRes = iRes;
    }

    public int getiDis() {
        return iDis;
    }

    public void setiDis(int iDis) {
        this.iDis = iDis;
    }

    public int getiSalud() {
        return iSalud;
    }

    public void setiSalud(int iSalud) {
        this.iSalud = iSalud;
    }

    public int getiAura() {
        return iAura;
    }

    public void setiAura(int iAura) {
        this.iAura = iAura;
    }

    public int getiCapa() {
        return iCapa;
    }

    public void setiCapa(int iCapa) {
        this.iCapa = iCapa;
    }

    public int getiMelee() {
        return iMelee;
    }

    public void setiMelee(int iMelee) {
        this.iMelee = iMelee;
    }

    public int getiDista() {
        return iDista;
    }

    public void setiDista(int iDista) {
        this.iDista = iDista;
    }

    public String getStrDust1() {
        return strDust1;
    }

    public void setStrDust1(String strDust1) {
        this.strDust1 = strDust1;
    }

    public String getStrDust2() {
        return strDust2;
    }

    public void setStrDust2(String strDust2) {
        this.strDust2 = strDust2;
    }

    public String getStrSem() {
        return strSem;
    }

    public void setStrSem(String strSem) {
        this.strSem = strSem;
    }

    public String[] getArrStrMod() {
        return arrStrMod;
    }

    public void setArrStrMod(String[] arrStrMod) {
        this.arrStrMod = arrStrMod;
    }

    public void setFem(int isFem) {
        this.isFem = isFem;
    }

    public void setHum(int isHum) {
        this.isHum = isHum;
    }
}
