package edith.example.carnefresca;

import android.widget.ImageView;

public class CFDatos {
    //general
    ImageView imagen;
    String strNombre;
    String strRasFis;

    //cuerpo
    int iCabeza;
    int iBrazos;
    int iTorso;
    int iPiernas;

    //rasgos
    private int iFisico;
    private int iBaseD;
    private int iPelD;
    private int iPelAr; //XD
    private int iRes;
    //------------
    private int iAgilidad;
    private int iConducir;
    private int iPunteria;
    private int iSigilo;
    //------------
    private int iInteligencia;
    private int iMani;
    private int iArr;
    private int iOcEn;
    private int iPra;
    //------------
    private int iEspiritu;
    private int iInti;
    private int iConv;
    private int iAten;
    private int iOrie;

    //salud
    int iDaño;
    int iTension;

    public CFDatos(ImageView imagen, String strNombre, String strRasFis, int iCabeza, int iBrazos, int iTorso, int iPiernas, int iFisico, int iBaseD, int iPelD, int iPelAr, int iRes, int iAgilidad, int iConducir, int iPunteria, int iSigilo, int iInteligencia, int iMani, int iArr, int iOcEn, int iPra, int iEspiritu, int iInti, int iConv, int iAten, int iOrie, int iDaño, int iTension) {
        this.imagen = imagen;
        this.strNombre = strNombre;
        this.strRasFis = strRasFis;
        this.iCabeza = iCabeza;
        this.iBrazos = iBrazos;
        this.iTorso = iTorso;
        this.iPiernas = iPiernas;
        this.iFisico = iFisico;
        this.iBaseD = iBaseD;
        this.iPelD = iPelD;
        this.iPelAr = iPelAr;
        this.iRes = iRes;
        this.iAgilidad = iAgilidad;
        this.iConducir = iConducir;
        this.iPunteria = iPunteria;
        this.iSigilo = iSigilo;
        this.iInteligencia = iInteligencia;
        this.iMani = iMani;
        this.iArr = iArr;
        this.iOcEn = iOcEn;
        this.iPra = iPra;
        this.iEspiritu = iEspiritu;
        this.iInti = iInti;
        this.iConv = iConv;
        this.iAten = iAten;
        this.iOrie = iOrie;
        this.iDaño = iDaño;
        this.iTension = iTension;
    }
}
