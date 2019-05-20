package edith.example.VoDatos;

public class Items {

    private class Arma{

        public Arma(int iAtq, String strDñ, String tra) {//se accede directamente a cada propiedad de las armas
            this.iAtq = iAtq;
            this.strDñ = strDñ;
            strTra = tra;
        }

        int iAtq;
        String strDñ;
        String strTra;
    }

    private String strItem1;
    private String strItem2;
    private String strItem3;
    private Arma arma1;
    private Arma arma2;
    private Arma arma3;

    public void setStrItem1(String strItem1) {
        this.strItem1 = strItem1;
    }

    public void setStrItem2(String strItem2) {
        this.strItem2 = strItem2;
    }

    public void setStrItem3(String strItem3) {
        this.strItem3 = strItem3;
    }

    public void setArma1(Arma arma1) {
        this.arma1 = arma1;
    }

    public void setArma2(Arma arma2) {
        this.arma2 = arma2;
    }

    public void setArma3(Arma arma3) {
        this.arma3 = arma3;
    }

    public String getStrItem1() {
        return strItem1;
    }

    public String getStrItem2() {
        return strItem2;
    }

    public String getStrItem3() {
        return strItem3;
    }

    public Arma getArma1() {
        return arma1;
    }

    public Arma getArma2() {
        return arma2;
    }

    public Arma getArma3() {
        return arma3;
    }

    public Items(String strItem1, String strItem2, String strItem3,
                 int Atq1, String Dñ1, String tra1,
                 int Atq2, String Dñ2, String tra2,
                 int Atq3, String Dñ3, String tra3) {
        this.strItem1 = strItem1;
        this.strItem2 = strItem2;
        this.strItem3 = strItem3;
        this.arma1 = new Arma(Atq1,Dñ1,tra1);
        this.arma2 = new Arma(Atq2,Dñ2,tra2);;
        this.arma3 = new Arma(Atq3,Dñ3,tra3);;
    }
}
