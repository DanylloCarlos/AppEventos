package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import model.Evento;
import util.DBGateway;

public class EventoDAO {
    private final String TABLE = "Evento";
    private DBGateway gw;
    private ArrayList<Evento> listEvt;

    public EventoDAO(Context ctx) {
        gw = DBGateway.getInstance(ctx);
    }

    public ArrayList<Evento> listarEventos(){
        String col[] = {
                "tituloEvento",
                "descricao",
                "categoria",
                "dataHoraInicio",
                "dataHoraFim"};
        listEvt = new ArrayList<Evento>();

        Cursor c = gw.getDatabase().query(TABLE, col, null, null, null, null,null);

        while (c.moveToNext()){
            Evento evt = new Evento();
            evt.setTituloEvento(c.getString(1));
            evt.setDescricao(c.getString(2));
            evt.setCategoria(c.getString(3));
            evt.setDataHoraInicio(c.getString(4));
            evt.setDataHoraFim(c.getString(5));
            listEvt.add(evt);
        }

        return listEvt;
    }

    public boolean salvarEvento(Evento evt){
        ContentValues cv = new ContentValues();
        cv.put("tituloEvento", evt.getTituloEvento());
        cv.put("descricao", evt.getDescricao());
        cv.put("categoria", evt.getCategoria());
        cv.put("dataHoraInicio", evt.getDataHoraInicio());
        cv.put("dataHoraFim", evt.getDataHoraFim());

        if(gw.getDatabase().insert(TABLE, null, cv) != 0){
            System.out.println("Dados salvos com sucesso!");
            return true;
        }else{
            System.out.println("Erro ao salvar os dados.");
        }
        return false;
    }
}
