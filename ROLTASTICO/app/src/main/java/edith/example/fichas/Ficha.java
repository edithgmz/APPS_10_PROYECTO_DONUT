package edith.example.fichas;
/*
 * Created by Edith on 28-May-19.
 */

public class Ficha {
    private String img;
    private String nom;
    private String sis;

    public Ficha(String img, String nom, String sis) {
        this.img = img;
        this.nom = nom;
        this.sis = sis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSis() {
        return sis;
    }

    public void setSis(String sis) {
        this.sis = sis;
    }
}
