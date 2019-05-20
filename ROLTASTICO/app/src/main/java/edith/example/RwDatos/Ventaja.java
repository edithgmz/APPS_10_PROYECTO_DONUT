package edith.example.RwDatos;

public class Ventaja {
    private String strSem;
    private String[] arrStrMod;

    public Ventaja(String strSem, String strMod1,String strMod2,String strMod3,String strMod4,String strMod5) {
        this.strSem = strSem;
        this.arrStrMod = new String[]{strMod1, strMod2, strMod3, strMod4, strMod5};
    }

    public String getStrSem() {
        return strSem;
    }

    public void setStrSem(String strSem) {
        this.strSem = strSem;
    }

    public String getArrStrMod(int i) {
        return arrStrMod[i];
    }

    public void setArrStrMod(String arrStrMod,int i) {
        this.arrStrMod[i] = arrStrMod;
    }
}
