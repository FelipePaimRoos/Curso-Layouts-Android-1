package com.example.myapplication.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.model.Pacote;
import com.example.myapplication.util.DiasUtil;
import com.example.myapplication.util.MoedaUtil;
import com.example.myapplication.util.ResourceUtil;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "@drawable/ic_launcher_background", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.NomeCidadeResumo);
        local.setText(pacoteSaoPaulo.getLocal());
        ImageView imagem = findViewById(R.id.imagemCidadeResumo);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.QuantidadeDiasResumo);
        String diasEmTexto = DiasUtil.formataEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.precoResumo);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);
    }
}
