package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBGateway {
    private static DBGateway gw;
    private SQLiteDatabase db;

    private DBGateway(Context ctx){
        CriaDB cdb = new CriaDB(ctx);
        this.db = cdb.getWritableDatabase();
    }

    public static DBGateway getInstance(Context ctx){
        if(gw == null) {
            gw = new DBGateway(ctx);
            return gw;
        }else
            return null;
    }

    public SQLiteDatabase getDatabase() {
        return this.db;
    }
}
