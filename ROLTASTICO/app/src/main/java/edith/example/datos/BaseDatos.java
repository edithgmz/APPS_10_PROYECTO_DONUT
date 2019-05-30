package edith.example.datos;
/*
 * Created by Edith on 19-May-19.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import edith.example.fichas.Ficha;

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

    //Obtener datos CF
    public ArrayList<CFDatos> datosCF() {
        ArrayList<CFDatos> alCF = new ArrayList<>();
        //Se crea el cursor ejecutando el query para leer los datos de la tabla
        Cursor CF = bd.rawQuery(LEER_TABLA_CF, null);
        if (CF != null && CF.getCount() > 0) {
            CF.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto CF
                String img = CF.getString(CF.getColumnIndex("img"));
                String nom = CF.getString(CF.getColumnIndex("nom"));
                String rasfis = CF.getString(CF.getColumnIndex("rasfis"));
                int isfem = CF.getInt(CF.getColumnIndex("isfem"));
                String cabeza = CF.getString(CF.getColumnIndex("cabeza"));
                String brader = CF.getString(CF.getColumnIndex("brader"));
                String braizq = CF.getString(CF.getColumnIndex("braizq"));
                String torso = CF.getString(CF.getColumnIndex("torso"));
                String piernas = CF.getString(CF.getColumnIndex("piernas"));
                int based = CF.getInt(CF.getColumnIndex("based"));
                int peld = CF.getInt(CF.getColumnIndex("peld"));
                int pelar = CF.getInt(CF.getColumnIndex("pelar"));
                int res = CF.getInt(CF.getColumnIndex("res"));
                int cond = CF.getInt(CF.getColumnIndex("cond"));
                int punt = CF.getInt(CF.getColumnIndex("punt"));
                int sigi = CF.getInt(CF.getColumnIndex("sigi"));
                int mani = CF.getInt(CF.getColumnIndex("mani"));
                int arr = CF.getInt(CF.getColumnIndex("arr"));
                int ocen = CF.getInt(CF.getColumnIndex("ocen"));
                int pra = CF.getInt(CF.getColumnIndex("pra"));
                int inti = CF.getInt(CF.getColumnIndex("inti"));
                int conv = CF.getInt(CF.getColumnIndex("conv"));
                int aten = CF.getInt(CF.getColumnIndex("aten"));
                int orie = CF.getInt(CF.getColumnIndex("orie"));
                int danio = CF.getInt(CF.getColumnIndex("danio"));
                int tens = CF.getInt(CF.getColumnIndex("tens"));
                //Se añaden los atributos al objeto
                alCF.add(new CFDatos(img, nom, rasfis, isfem, cabeza, brader,
                        braizq, torso, piernas, based, peld, pelar, res,
                        cond, punt, sigi, mani, arr, ocen, pra, inti, conv,
                        aten, orie, danio, tens));
            } while (CF.moveToNext());
        }
        //Cerrar cursor
        if (CF != null) {
            CF.close();
        }
        //Devuelve el objeto
        return alCF;
    }

    //Obtener datos RW
    public ArrayList<RWDatos> datosRW() {
        ArrayList<RWDatos> alRW = new ArrayList<>();
        //Se crea el cursor ejecutando el query para leer los datos de la tabla
        Cursor RW = bd.rawQuery(LEER_TABLA_RW, null);
        if (RW != null && RW.getCount() > 0) {
            RW.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto RW
                String img = RW.getString(RW.getColumnIndex("img"));
                String nom = RW.getString(RW.getColumnIndex("nom"));
                int isfem = RW.getInt(RW.getColumnIndex("isfem"));
                int ishum = RW.getInt(RW.getColumnIndex("ishum"));
                String cabel = RW.getString(RW.getColumnIndex("cabel"));
                String ojos = RW.getString(RW.getColumnIndex("ojos"));
                String arma = RW.getString(RW.getColumnIndex("arma"));
                int fue = RW.getInt(RW.getColumnIndex("fue"));
                int vol = RW.getInt(RW.getColumnIndex("vol"));
                int agi = RW.getInt(RW.getColumnIndex("agi"));
                int per = RW.getInt(RW.getColumnIndex("per"));
                int res = RW.getInt(RW.getColumnIndex("res"));
                int dis = RW.getInt(RW.getColumnIndex("dis"));
                int salud = RW.getInt(RW.getColumnIndex("salud"));
                int aura = RW.getInt(RW.getColumnIndex("aura"));
                int capa = RW.getInt(RW.getColumnIndex("capa"));
                int melee = RW.getInt(RW.getColumnIndex("melee"));
                int dist = RW.getInt(RW.getColumnIndex("dist"));
                String dust1 = RW.getString(RW.getColumnIndex("dust1"));
                String dust2 = RW.getString(RW.getColumnIndex("dust2"));
                String semb = RW.getString(RW.getColumnIndex("semb"));
                String mod = RW.getString(RW.getColumnIndex("mod"));
                //Se añaden los atributos al objeto
                alRW.add(new RWDatos(img, nom, isfem, ishum, cabel, ojos,
                        arma, fue, vol, agi, per, res, dis, salud, aura,
                        capa, melee, dist, dust1, dust2, semb, mod));
            } while (RW.moveToNext());
        }
        //Cerrar cursor
        if (RW != null) {
            RW.close();
        }
        //Devuelve el objeto
        return alRW;
    }

    //Obtener datos VO
    public ArrayList<VODatos> datosVO() {
        ArrayList<VODatos> alVO = new ArrayList<>();
        //Se crea el cursor ejecutando el query para leer los datos de la tabla
        Cursor VO = bd.rawQuery(LEER_TABLA_VO, null);
        if (VO != null && VO.getCount() > 0) {
            VO.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto VO
                String img = VO.getString(VO.getColumnIndex("img"));
                String nom = VO.getString(VO.getColumnIndex("nom"));
                String clase = VO.getString(VO.getColumnIndex("clase"));
                String nivadq = VO.getString(VO.getColumnIndex("nivadq"));
                int px = VO.getInt(VO.getColumnIndex("px"));
                int nivel = VO.getInt(VO.getColumnIndex("nivel"));
                String trans = VO.getString(VO.getColumnIndex("trans"));
                String tal1 = VO.getString(VO.getColumnIndex("tal1"));
                String tal2 = VO.getString(VO.getColumnIndex("tal2"));
                int isfem = VO.getInt(VO.getColumnIndex("isfem"));
                int stdfue = VO.getInt(VO.getColumnIndex("stdfue"));
                int stddes = VO.getInt(VO.getColumnIndex("stddes"));
                int stdcon = VO.getInt(VO.getColumnIndex("stdcon"));
                int stdint = VO.getInt(VO.getColumnIndex("stdint"));
                int stdsab = VO.getInt(VO.getColumnIndex("stdsab"));
                int stdcar = VO.getInt(VO.getColumnIndex("stdcar"));
                int modfue = VO.getInt(VO.getColumnIndex("modfue"));
                int moddes = VO.getInt(VO.getColumnIndex("moddes"));
                int modcon = VO.getInt(VO.getColumnIndex("modcon"));
                int modint = VO.getInt(VO.getColumnIndex("modint"));
                int modsab = VO.getInt(VO.getColumnIndex("modsab"));
                int modcar = VO.getInt(VO.getColumnIndex("modcar"));
                int alerta = VO.getInt(VO.getColumnIndex("alerta"));
                int comun = VO.getInt(VO.getColumnIndex("comun"));
                int manip = VO.getInt(VO.getColumnIndex("manip"));
                int erudi = VO.getInt(VO.getColumnIndex("erudi"));
                int subter = VO.getInt(VO.getColumnIndex("subter"));
                int superv = VO.getInt(VO.getColumnIndex("superv"));
                int pvtot = VO.getInt(VO.getColumnIndex("pvtot"));
                int pvact = VO.getInt(VO.getColumnIndex("pvact"));
                int def = VO.getInt(VO.getColumnIndex("def"));
                int atq = VO.getInt(VO.getColumnIndex("atq"));
                int inst = VO.getInt(VO.getColumnIndex("inst"));
                int atqarm = VO.getInt(VO.getColumnIndex("atqarm"));
                int danarm = VO.getInt(VO.getColumnIndex("danarm"));
                int traarm = VO.getInt(VO.getColumnIndex("traarm"));
                String nomarm = VO.getString(VO.getColumnIndex("nomarm"));
                String obj1 = VO.getString(VO.getColumnIndex("obj1"));
                String obj2 = VO.getString(VO.getColumnIndex("obj2"));
                String obj3 = VO.getString(VO.getColumnIndex("obj3"));
                //Se añaden los atributos al objeto
                alVO.add(new VODatos(img, nom, clase, nivadq, px, nivel,
                        trans, tal1, tal2, isfem, stdfue, stddes, stdcon,
                        stdint, stdsab, stdcar, modfue, moddes, modcon, modint,
                        modsab, modcar, alerta, comun, manip, erudi,
                        subter, superv, pvtot, pvact, def, atq, inst, nomarm,
                        atqarm, danarm, traarm, obj1, obj2, obj3));
            } while (VO.moveToNext());
        }
        //Cerrar cursor
        if (VO != null) {
            VO.close();
        }
        //Devuelve el objeto
        return alVO;
    }

    //Obtener fichas
    public ArrayList<Ficha> fichas() {
        ArrayList<Ficha> alFicha = new ArrayList<>();
        //Se crean los cursores ejecutando los queries para leer los datos de las tablas
        Cursor CF = bd.rawQuery(LEER_TABLA_CF, null);
        Cursor RW = bd.rawQuery(LEER_TABLA_RW, null);
        Cursor VO = bd.rawQuery(LEER_TABLA_VO, null);
        if (CF != null && CF.getCount() > 0) {
            CF.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto Ficha
                String imgCF = CF.getString(CF.getColumnIndex("img"));
                String nomCF = CF.getString(CF.getColumnIndex("nom"));
                String sisCF = "Carne Fresca";
                //Se añaden los atributos al objeto
                alFicha.add(new Ficha(imgCF, nomCF, sisCF));
            } while (CF.moveToNext());
        }
        if (RW != null && RW.getCount() > 0) {
            RW.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto Ficha
                String imgRW = RW.getString(RW.getColumnIndex("img"));
                String nomRW = RW.getString(RW.getColumnIndex("nom"));
                String sisRW = "Rwby";
                //Se añaden los atributos al objeto
                alFicha.add(new Ficha(imgRW, nomRW, sisRW));
            } while (RW.moveToNext());
        }
        if (VO != null && VO.getCount() > 0) {
            VO.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto Ficha
                String imgVO = VO.getString(VO.getColumnIndex("img"));
                String nomVO = VO.getString(VO.getColumnIndex("nom"));
                String sisVO = "Viejo Oeste";
                //Se añaden los atributos al objeto
                alFicha.add(new Ficha(imgVO, nomVO, sisVO));
            } while (VO.moveToNext());
        }
        //Cerrar cursor
        if (CF != null) {
            CF.close();
        }
        if (RW != null) {
            RW.close();
        }
        if (VO != null) {
            VO.close();
        }
        //Devuelve la ficha
        return alFicha;
    }

    //Eliminar registro en CF
    public void eliminarCF(String nom, String rasfis) {
        String[] args = new String[]{nom, rasfis};
        String cond = "nom=? AND rasfis=?";
        bd.delete("cf", cond, args);
    }

    //Eliminar registro en RW
    public void eliminarRW(String nom, String cabel) {
        String[] args = new String[]{nom, cabel};
        String cond = "nom=? AND cabel=?";
        bd.delete("rw", cond, args);
    }

    //Eliminar registro en VO
    public void eliminarVO(String nom, String clase) {
        String[] args = new String[]{nom, clase};
        String cond = "nom=? AND clase=?";
        bd.delete("vo", cond, args);
    }
}
