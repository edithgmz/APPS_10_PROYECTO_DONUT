package edith.example.rwby;

public class RWDatos {
   //general
    private String strNombre;
    private boolean isFem; //género
    private boolean isHum; //humano o fauno
    private String strColor;
    private String strCabello;
    private String strOjos;
    private String strArmNom;
    private String strArmDesc;

   //rasgos
    //Base
    private byte byFue;
    private byte byVol;
    private byte byAgi;
    private byte byPer;
    private byte byRes;
    private byte byDis;
    //derivado, se inicializan en el constructor
    private byte bySalud;
    private byte byAura;
    private byte byCapa;

    //meele(cuerpo a cuerpo) y distacia
    String strMelee;
    String strDista;

   //dust
    private int iDust1;
    private int iDust2;

   //ventaja
    private String strSem;
    private String[] arrStrMod;

}
