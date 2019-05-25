package edith.example.viejooeste;

public class VODatos {
   //general
    String clase;
    String n;
    int px;
    int nivel;
    String transfondo1;
    String talento1;
    String talento2;

   //rasgos
    //estadistica
    int stdFue;
    int stdDes;
    int stdCon;
    int stdInt;
    int stdSab;
    int stdCar;
    //modificador
    int modFue;
    int modDes;
    int modCon;
    int modInt;
    int modSab;
    int modCar;

    //habilidades
    boolean alerta;
    boolean comunicacion;
    boolean manipulacion;
    boolean erudicion;
    boolean subterfugio;
    boolean supervivencia;

    //otros
    int pvTot;//14 - stdFue
    int pvAct; // va cambiando máximo pvTot
    int def; //14 - stdDes
    byte atq; // 0 a 7
    byte inst;// 0 a 11
    final int mov=10; //siempre 10 en ficha
}
