package edith.example.CfDatos;

public class Cuerpo {
    int iCabeza;
    int iBrazos;
    int iTorso;
    int iPiernas;

    public Cuerpo(int iCabeza, int iBrazos, int iTorso, int iPiernas) {
        this.iCabeza = iCabeza;
        this.iBrazos = iBrazos;
        this.iTorso = iTorso;
        this.iPiernas = iPiernas;
    }

    public int getiCabeza() {
        return iCabeza;
    }

    public void setiCabeza(int iCabeza) {
        this.iCabeza = iCabeza;
    }

    public int getiBrazos() {
        return iBrazos;
    }

    public void setiBrazos(int iBrazos) {
        this.iBrazos = iBrazos;
    }

    public int getiTorso() {
        return iTorso;
    }

    public void setiTorso(int iTorso) {
        this.iTorso = iTorso;
    }

    public int getiPiernas() {
        return iPiernas;
    }

    public void setiPiernas(int iPiernas) {
        this.iPiernas = iPiernas;
    }
}
