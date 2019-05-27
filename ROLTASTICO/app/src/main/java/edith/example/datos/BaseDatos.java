package edith.example.datos;
/*
 * Created by Edith on 19-May-19.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String CREAR_TABLA_CF = "CREATE TABLE cf(_id INTEGER PRIMARY KEY AUTOINCREMENT, img TEXT, nom TEXT, rasfis TEXT, isfem INTEGER, cabeza INTEGER, brader TEXT, braizq TEXT, torso TEXT, piernas TEXT, based INTEGER, peld INTEGER, pelar INTEGER, res INTEGER, cond INTEGER, punt INTEGER, sigi INTEGER, mani INTEGER, arr INTEGER, ocen INTEGER, pra INTEGER, inti INTEGER, conv INTEGER, aten INTEGER, orie INTEGER, danio INTEGER, tens INTEGER)";
    private static final String CREAR_TABLA_RW = "CREATE TABLE rw(_id INTEGER PRIMARY KEY AUTOINCREMENT, img TEXT, nom TEXT, isfem INTEGER, ishum INTEGER, cabel TEXT, ojos TEXT, arma TEXT, fue INTEGER, vol INTEGER, agi INTEGER, per INTEGER, res INTEGER, dis INTEGER, salud INTEGER, aura INTEGER, capa INTEGER, melee INTEGER, dist TEXT, dust1 TEXT, dust2 TEXT, semb TEXT, mod TEXT)";
    private static final String CREAR_TABLA_VO = "CREATE TABLE vo(_id INTEGER PRIMARY KEY AUTOINCREMENT, img TEXT, nom TEXT, clase TEXT, nivadq TEXT, px INTEGER, nivel INTEGER, trans TEXT, tal1 TEXT, tal2 TEXT, isfem INTEGER, stdfue INTEGER, stddes INTEGER, stdcon INTEGER, stdint INTEGER, stdsab INTEGER, stdcar INTEGER, modfue INTEGER, moddes INTEGER, modcon INTEGER, modint INTEGER, modsab INTEGER, modcar INTEGER, alerta INTEGER, comun INTEGER, manip INTEGER, erudi INTEGER, subter INTEGER, superv INTEGER, pvtot INTEGER, pvact INTEGER, def INTEGER, atq INTEGER, inst INTEGER, mov INTEGER, atqarm INTEGER, danarm INTEGER, traarm INTEGER, nomarm TEXT, obj1 TEXT, obj2 TEXT, obj3 TEXT)";
    private static final String LEER_TABLA_CF = "SELECT _id, img, nom, rasfis, isfem, cabeza, brader, braizq, torso, piernas, based, peld, pelar, res, cond, punt, sigi, mani, arr, ocen, pra, inti, conv, aten, orie, danio, tens FROM cf";
    private static final String LEER_TABLA_RW = "SELECT _id, img, nom, isfem, ishum, cabel, ojos, arma, fue, vol, agi, per, res, dis, salud, aura, capa, melee, dist, dust1, dust2, semb, mod FROM rw";
    private static final String LEER_TABLA_VO = "SELECT _id, img, nom, clase, nivadq, px, nivel, trans, tal1, tal2, isfem, stdfue, stddes, stdcon, stdint, stdsab, stdcar, modfue, moddes, modcon, modint, modsab, modcar, alerta, comun, manip, erudi, subter, superv, pvtot, pvact, def, atq, inst, mov, atqarm, danarm, traarm, nomarm, obj1, obj2, obj3 FROM vo";
    private static final String NOMBRE_BD = "roltastico.sqlite";
    private static final int VERSION_BD = 1;
    private SQLiteDatabase bd;

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        bd = this.getWritableDatabase(); //Es un método interno
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CF);
        db.execSQL(CREAR_TABLA_RW);
        db.execSQL(CREAR_TABLA_VO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Insertar registro en CF
    public void insertarCF(String img, String nom, String rasfis, int isfem, String cabeza, String brader, String braizq,
                           String torso, String piernas, int based, int peld, int pelar, int res, int cond, int punt, int sigi,
                           int mani, int arr, int ocen, int pra, int inti, int conv, int aten, int orie, int danio, int tens) {
        ContentValues cv = new ContentValues();
        cv.put("img", img);
        cv.put("nom", nom);
        cv.put("rasfis", rasfis);
        cv.put("isfem", isfem);
        cv.put("cabeza", cabeza);
        cv.put("brader", brader);
        cv.put("braizq", braizq);
        cv.put("torso", torso);
        cv.put("piernas", piernas);
        cv.put("based", based);
        cv.put("peld", peld);
        cv.put("pelar", pelar);
        cv.put("res", res);
        cv.put("cond", cond);
        cv.put("punt", punt);
        cv.put("sigi", sigi);
        cv.put("mani", mani);
        cv.put("arr", arr);
        cv.put("ocen", ocen);
        cv.put("pra", pra);
        cv.put("inti", inti);
        cv.put("conv", conv);
        cv.put("aten", aten);
        cv.put("orie", orie);
        cv.put("danio", danio);
        cv.put("tens", tens);
        bd.insert("cf", null, cv);
    }

    //Insertar registro en RW
    public void insertarRW(String img, String nom, int isfem, int ishum, String cabel, String ojos, String arma, int fue, int vol,
                           int agi, int per, int res, int dis, int salud, int aura, int capa, int melee, int dist, String dust1,
                           String dust2, String semb, String mod) {
        ContentValues cv = new ContentValues();
        cv.put("img", img);
        cv.put("nom", nom);
        cv.put("isfem", isfem);
        cv.put("ishum", ishum);
        cv.put("cabel", cabel);
        cv.put("ojos", ojos);
        cv.put("arma", arma);
        cv.put("fue", fue);
        cv.put("vol", vol);
        cv.put("agi", agi);
        cv.put("per", per);
        cv.put("res", res);
        cv.put("dis", dis);
        cv.put("salud", salud);
        cv.put("aura", aura);
        cv.put("capa", capa);
        cv.put("melee", melee);
        cv.put("dist", dist);
        cv.put("dust1", dust1);
        cv.put("dust2", dust2);
        cv.put("semb", semb);
        cv.put("mod", mod);
        bd.insert("rw", null, cv);
    }

    //Insertar registro en VO
    public void insertarVO(String img, String nom, String clase, String nivadq, int px, int nivel, String trans, String tal1,
                           String tal2, int isfem, int stdfue, int stddes, int stdcon, int stdint, int stdsab, int stdcar,
                           int modfue, int moddes, int modcon, int modint, int modsab, int modcar, int alerta, int comun, int manip,
                           int erudi, int subter, int superv, int pvtot, int pvact, int def, int atq, int inst, int mov, int atqarm,
                           int danarm, int traarm, String nomarm, String obj1, String obj2, String obj3) {
        ContentValues cv = new ContentValues();
        cv.put("img", img);
        cv.put("nom", nom);
        cv.put("clase", clase);
        cv.put("nivadq", nivadq);
        cv.put("px", px);
        cv.put("nivel", nivel);
        cv.put("trans", trans);
        cv.put("tal1", tal1);
        cv.put("tal2", tal2);
        cv.put("isfem", isfem);
        cv.put("stdfue", stdfue);
        cv.put("stddes", stddes);
        cv.put("stdcon", stdcon);
        cv.put("stdint", stdint);
        cv.put("stdsab", stdsab);
        cv.put("stdcar", stdcar);
        cv.put("modfue", modfue);
        cv.put("moddes", moddes);
        cv.put("modcon", modcon);
        cv.put("modint", modint);
        cv.put("modsab", modsab);
        cv.put("modcar", modcar);
        cv.put("alerta", alerta);
        cv.put("comun", comun);
        cv.put("manip", manip);
        cv.put("erudi", erudi);
        cv.put("subter", subter);
        cv.put("superv", superv);
        cv.put("pvtot", pvtot);
        cv.put("pvact", pvact);
        cv.put("def", def);
        cv.put("atq", atq);
        cv.put("inst", inst);
        cv.put("mov", mov);
        cv.put("atqarm", atqarm);
        cv.put("danarm", danarm);
        cv.put("traarm", traarm);
        cv.put("nomarm", nomarm);
        cv.put("obj1", obj1);
        cv.put("obj2", obj2);
        cv.put("obj3", obj3);
        bd.insert("vo", null, cv);
    }

    //Obtener lista de CF


    //Obtener lista de RW


    //Obtener lista de VO

}
