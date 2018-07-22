package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "bdEventos.db";
    private static final int DB_VERSION = 1;
    private String sql;

    public CriaDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "create table Evento ("+
                "idEvento INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "tituloEvento VARCHAR (100),"+
                "descricao VARCHAR (100),"+
                "categoria VARCHAR (60),"+
                "dataHoraInicio DATETIME,"+
                "dataHoraFim DATETIME)";

        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int older, int newer){
        db.execSQL("DROP TABLE IF EXISTS Evento");
        onCreate(db);
    }

}
