package edith.example.CfDatos;

public class Salud {
    int iDaño;
    int iTension;

    public int getDaño() {
        return iDaño;
    }

    public void setDaño(int daño) {
        iDaño = daño;
    }

    public int getTension() {
        return iTension;
    }

    public void setTension(int tension) {
        iTension = tension;
    }

    public Salud(int daño, int tension) {
        iDaño = daño;
        iTension = tension;
    }
}
