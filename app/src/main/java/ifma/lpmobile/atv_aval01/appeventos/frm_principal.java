package ifma.lpmobile.atv_aval01.appeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class frm_principal extends AppCompatActivity {
    private EditText etTituloEvento;
    private EditText etDescricao;
    private Spinner spnCategoria;
    private EditText etDataHoraInicio;
    private EditText etDataHoraFim;
    private ProgressBar progressBar;
    private Button btListar;
    private Button btSalvar;
    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_principal);
    }
}
