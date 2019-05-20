package edith.example.RwDatos;

public class Rasgos {
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

    public Rasgos(byte byFue, byte byVol, byte byAgi, byte byPer, byte byRes, byte byDis,byte mel,byte dista) {
        this.byFue = byFue;
        this.byVol = byVol;
        this.byAgi = byAgi;
        this.byPer = byPer;
        this.byRes = byRes;
        this.byDis = byDis;
        bySalud= (byte) (this.byRes +1);
        byAura = (byte) (byPer+10);
        byCapa = (byte) (byDis+1);


    }

    public byte getByFue() {
        return byFue;
    }

    public void setByFue(byte byFue) {
        this.byFue = byFue;
    }

    public byte getByVol() {
        return byVol;
    }

    public void setByVol(byte byVol) {
        this.byVol = byVol;
    }

    public byte getByAgi() {
        return byAgi;
    }

    public void setByAgi(byte byAgi) {
        this.byAgi = byAgi;
    }

    public byte getByPer() {
        return byPer;
    }

    public void setByPer(byte byPer) {
        this.byPer = byPer;
    }

    public byte getByRes() {
        return byRes;
    }

    public void setByRes(byte byRes) {
        this.byRes = byRes;
    }

    public byte getByDis() {
        return byDis;
    }

    public void setByDis(byte byDis) {
        this.byDis = byDis;
    }

    public byte getBySalud() {
        return bySalud;
    }

    public byte getByAura() {
        return byAura;
    }

    public byte getByCapa() {
        return byCapa;
    }
}
