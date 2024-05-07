package com.example.myapplication.activity;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.dao.PacoteDAO;
import com.example.myapplication.model.Pacote;
import com.example.myapplication.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);

        configurarLista();
    }

    private void configurarLista(){
            ListView listaDePacotes = findViewById(R.id.listaPacotes);
            List<Pacote> pacotes = new PacoteDAO().lista();
            listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

    }

}
