package ifma.lpmobile.atv_aval01.appeventos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import controller.EventoDAO;
import model.Evento;

public class MostrarDados extends AppCompatActivity {

    private SQLiteDatabase db;
    private TextView tvTituloEvento;
    private TextView tvDescricao;
    private Spinner spnCategoria;
    private TextView tvDataHoraInicio;
    private TextView tvDataHoraFim;
    private EventoDAO evtDAO;
    private Evento evt;

    String tituloEvento
            ,descricao
            ,categoria
            ,dataHoraInicio
            ,dataHoraFim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_mostrar_dados);

        tvTituloEvento = findViewById(R.id.etTituloEvento);
        tvDescricao = findViewById(R.id.etDescricao);
        spnCategoria = findViewById(R.id.spnCategoria)
        tvDataHoraInicio = findViewById(R.id.etDataHoraInicio);


        Intent it = getIntent();
        Bundle param = it.getExtras();
        tituloEvento = param.getString("tituloEvento");
        descricao = param.getString("descricao");
        categoria = param.getString("categoria");
        dataHoraInicio = param.getString("dataHoraInicio");
        dataHoraFim = param.getString("dataHoraFim");
    }
}
