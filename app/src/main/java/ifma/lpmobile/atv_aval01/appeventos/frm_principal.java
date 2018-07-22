package ifma.lpmobile.atv_aval01.appeventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import controller.EventoDAO;
import model.Evento;

public class frm_principal extends AppCompatActivity implements OnClickListener {
    private EditText etTituloEvento;
    private EditText etDescricao;
    private Spinner spnCategoria;
    private EditText etDataHoraInicio;
    private EditText etDataHoraFim;
    private ProgressBar progBar;
    private Button btListar;
    private Button btSalvar;
    private Button btSair;
    private EventoDAO evtDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_principal);

        String categorias[] = {"Entretenimento", "Ciência", "Cultura", "Esporte", "Lazer"};

        etTituloEvento = findViewById(R.id.etTituloEvento);
        etDescricao = findViewById(R.id.etDescricao);
        spnCategoria = findViewById(R.id.spnCategoria);
        etDataHoraInicio = findViewById(R.id.etDataHoraInicio);
        etDataHoraFim = findViewById(R.id.etDataHoraFim);
        btListar = findViewById(R.id.btListar);
        btSalvar = findViewById(R.id.btSalvar);
        btSair = findViewById(R.id.btSair);

        btListar.setOnClickListener(this);
        btSalvar.setOnClickListener(this);
        btSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String tituloEvento
                ,descricao
                ,categoria
                ,dataHoraInicio
                ,dataHoraFim;

        if(v.getId() == btSalvar.getId()){
            tituloEvento = etTituloEvento.getText().toString();
            descricao = etDescricao.getText().toString();
            categoria = spnCategoria.getSelectedItem().toString();
            dataHoraInicio = etDataHoraInicio.getText().toString();
            dataHoraFim = etDataHoraFim.getText().toString();

            Intent it = new Intent(this, MostrarDados.class);
            Bundle params = new Bundle();
            params.putString("tituloEvento", tituloEvento);
            params.putString("descricao", descricao);
            params.putString("categoria", categoria);
            params.putString("dataHoraInicio", dataHoraInicio);
            params.putString("dataHoraFim", dataHoraFim);

            it.putExtras(params);
            startActivity(it);
        }

        if(v.getId() == btListar.getId()){
        ArrayList<Evento> listEvt = evtDAO.listarEventos();

        for(Evento evt:listEvt){
        Toast.makeText(this, evt.getTituloEvento(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, evt.getDescricao(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, evt.getCategoria(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, evt.getDataHoraInicio(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, evt.getDataHoraFim(), Toast.LENGTH_SHORT).show();
        }

        }

        if(v.getId() == btSair.getId()){
            System.exit(0);
        }
    }
}
