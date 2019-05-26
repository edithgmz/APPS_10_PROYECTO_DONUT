package edith.example.datos;

public class VODatos {
    private final int iMov = 10; //siempre 10 en ficha
    //general
    private String strImagen;
    private String strNombre;
    private String strClase;
    private String strNivAqd;
    private int iPx;
    private int iNivel;
    private String strTransfondo;
    private String strTalento1;
    private String strTalento2;
    private int isFem; //género
    //rasgos
    //estadistica
    private int iStdFue;
    private int iStdDes;
    private int iStdCon;
    private int iStdInt;
    private int iStdSab;
    private int iStdCar;
    //modificador
    private int iModFue;
    private int iModDes;
    private int iModCon;
    private int iModInt;
    private int iModSab;
    private int iModCar;
    //habilidades
    private int iAlerta;
    private int iComunicacion;
    private int iManipulacion;
    private int iErudicion;
    private int iSubterfugio;
    private int iSupervivencia;
    //otros
    private int iPvTot;//14 - stdFue
    private int iPvAct; // va cambiando máximo pvTot
    private int iDef; //14 - stdDes
    private int iAtq; // 0 a 7
    private int iInst;// 0 a 11
    //Items
    //armas
    private String strNomArm;
    private int iAtqArm;
    private int iDanArm;
    private int iTraArm;

    //inventario
    private String strObj1;
    private String strObj2;
    private String strObj3;

    public VODatos(String strImagen, String strNombre, String strClase, String strNivAqd, int iPx, int iNivel, String strTransfondo, String strTalento1, String strTalento2, int isFem, int iStdFue, int iStdDes, int iStdCon, int iStdInt, int iStdSab, int iStdCar, int iModFue, int iModDes, int iModCon, int iModInt, int iModSab, int iModCar, int iAlerta, int iComunicacion, int iManipulacion, int iErudicion, int iSubterfugio, int iSupervivencia, int iPvTot, int iPvAct, int iDef, int iAtq, int iInst, String strNomArm, int iAtqArm, int iDanArm, int iTraArm, String strObj1, String strObj2, String strObj3) {
        this.strImagen = strImagen;
        this.strNombre = strNombre;
        this.strClase = strClase;
        this.strNivAqd = strNivAqd;
        this.iPx = iPx;
        this.iNivel = iNivel;
        this.strTransfondo = strTransfondo;
        this.strTalento1 = strTalento1;
        this.strTalento2 = strTalento2;
        this.isFem = isFem;
        this.iStdFue = iStdFue;
        this.iStdDes = iStdDes;
        this.iStdCon = iStdCon;
        this.iStdInt = iStdInt;
        this.iStdSab = iStdSab;
        this.iStdCar = iStdCar;
        this.iModFue = iModFue;
        this.iModDes = iModDes;
        this.iModCon = iModCon;
        this.iModInt = iModInt;
        this.iModSab = iModSab;
        this.iModCar = iModCar;
        this.iAlerta = iAlerta;
        this.iComunicacion = iComunicacion;
        this.iManipulacion = iManipulacion;
        this.iErudicion = iErudicion;
        this.iSubterfugio = iSubterfugio;
        this.iSupervivencia = iSupervivencia;
        this.iPvTot = iPvTot;
        this.iPvAct = iPvAct;
        this.iDef = iDef;
        this.iAtq = iAtq;
        this.iInst = iInst;
        this.strNomArm = strNomArm;
        this.iAtqArm = iAtqArm;
        this.iDanArm = iDanArm;
        this.iTraArm = iTraArm;
        this.strObj1 = strObj1;
        this.strObj2 = strObj2;
        this.strObj3 = strObj3;
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

    public String getStrClase() {
        return strClase;
    }

    public void setStrClase(String strClase) {
        this.strClase = strClase;
    }

    public String getStrNivAqd() {
        return strNivAqd;
    }

    public void setStrNivAqd(String strNivAqd) {
        this.strNivAqd = strNivAqd;
    }

    public int getiPx() {
        return iPx;
    }

    public void setiPx(int iPx) {
        this.iPx = iPx;
    }

    public int getiNivel() {
        return iNivel;
    }

    public void setiNivel(int iNivel) {
        this.iNivel = iNivel;
    }

    public String getStrTransfondo() {
        return strTransfondo;
    }

    public void setStrTransfondo(String strTransfondo) {
        this.strTransfondo = strTransfondo;
    }

    public String getStrTalento1() {
        return strTalento1;
    }

    public void setStrTalento1(String strTalento1) {
        this.strTalento1 = strTalento1;
    }

    public String getStrTalento2() {
        return strTalento2;
    }

    public void setStrTalento2(String strTalento2) {
        this.strTalento2 = strTalento2;
    }

    public int getIsFem() {
        return isFem;
    }

    public void setIsFem(int isFem) {
        this.isFem = isFem;
    }

    public int getiStdFue() {
        return iStdFue;
    }

    public void setiStdFue(int iStdFue) {
        this.iStdFue = iStdFue;
    }

    public int getiStdDes() {
        return iStdDes;
    }

    public void setiStdDes(int iStdDes) {
        this.iStdDes = iStdDes;
    }

    public int getiStdCon() {
        return iStdCon;
    }

    public void setiStdCon(int iStdCon) {
        this.iStdCon = iStdCon;
    }

    public int getiStdInt() {
        return iStdInt;
    }

    public void setiStdInt(int iStdInt) {
        this.iStdInt = iStdInt;
    }

    public int getiStdSab() {
        return iStdSab;
    }

    public void setiStdSab(int iStdSab) {
        this.iStdSab = iStdSab;
    }

    public int getiStdCar() {
        return iStdCar;
    }

    public void setiStdCar(int iStdCar) {
        this.iStdCar = iStdCar;
    }

    public int getiModFue() {
        return iModFue;
    }

    public void setiModFue(int iModFue) {
        this.iModFue = iModFue;
    }

    public int getiModDes() {
        return iModDes;
    }

    public void setiModDes(int iModDes) {
        this.iModDes = iModDes;
    }

    public int getiModCon() {
        return iModCon;
    }

    public void setiModCon(int iModCon) {
        this.iModCon = iModCon;
    }

    public int getiModInt() {
        return iModInt;
    }

    public void setiModInt(int iModInt) {
        this.iModInt = iModInt;
    }

    public int getiModSab() {
        return iModSab;
    }

    public void setiModSab(int iModSab) {
        this.iModSab = iModSab;
    }

    public int getiModCar() {
        return iModCar;
    }

    public void setiModCar(int iModCar) {
        this.iModCar = iModCar;
    }

    public int getiAlerta() {
        return iAlerta;
    }

    public void setiAlerta(int iAlerta) {
        this.iAlerta = iAlerta;
    }

    public int getiComunicacion() {
        return iComunicacion;
    }

    public void setiComunicacion(int iComunicacion) {
        this.iComunicacion = iComunicacion;
    }

    public int getiManipulacion() {
        return iManipulacion;
    }

    public void setiManipulacion(int iManipulacion) {
        this.iManipulacion = iManipulacion;
    }

    public int getiErudicion() {
        return iErudicion;
    }

    public void setiErudicion(int iErudicion) {
        this.iErudicion = iErudicion;
    }

    public int getiSubterfugio() {
        return iSubterfugio;
    }

    public void setiSubterfugio(int iSubterfugio) {
        this.iSubterfugio = iSubterfugio;
    }

    public int getiSupervivencia() {
        return iSupervivencia;
    }

    public void setiSupervivencia(int iSupervivencia) {
        this.iSupervivencia = iSupervivencia;
    }

    public int getiPvTot() {
        return iPvTot;
    }

    public void setiPvTot(int iPvTot) {
        this.iPvTot = iPvTot;
    }

    public int getiPvAct() {
        return iPvAct;
    }

    public void setiPvAct(int iPvAct) {
        this.iPvAct = iPvAct;
    }

    public int getiDef() {
        return iDef;
    }

    public void setiDef(int iDef) {
        this.iDef = iDef;
    }

    public int getiAtq() {
        return iAtq;
    }

    public void setiAtq(int iAtq) {
        this.iAtq = iAtq;
    }

    public int getiInst() {
        return iInst;
    }

    public void setiInst(int iInst) {
        this.iInst = iInst;
    }

    public int getiMov() {
        return iMov;
    }

    public String getStrNomArm() {
        return strNomArm;
    }

    public void setStrNomArm(String strNomArm) {
        this.strNomArm = strNomArm;
    }

    public int getiAtqArm() {
        return iAtqArm;
    }

    public void setiAtqArm(int iAtqArm) {
        this.iAtqArm = iAtqArm;
    }

    public int getiDanArm() {
        return iDanArm;
    }

    public void setiDanArm(int iDanArm) {
        this.iDanArm = iDanArm;
    }

    public int getiTraArm() {
        return iTraArm;
    }

    public void setiTraArm(int iTraArm) {
        this.iTraArm = iTraArm;
    }

    public String getStrObj1() {
        return strObj1;
    }

    public void setStrObj1(String strObj1) {
        this.strObj1 = strObj1;
    }

    public String getStrObj2() {
        return strObj2;
    }

    public void setStrObj2(String strObj2) {
        this.strObj2 = strObj2;
    }

    public String getStrObj3() {
        return strObj3;
    }

    public void setStrObj3(String strObj3) {
        this.strObj3 = strObj3;
    }
}
