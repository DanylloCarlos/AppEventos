package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {
    private int idEvento;
    private String tituloEvento;
    private String descricao;
    private String categoria;
    private SimpleDateFormat dataHoraInicio;
    private SimpleDateFormat dataHoraFim;

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public SimpleDateFormat getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(SimpleDateFormat dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public SimpleDateFormat getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(SimpleDateFormat dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}
