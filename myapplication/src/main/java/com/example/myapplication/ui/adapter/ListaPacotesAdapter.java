package com.example.myapplication.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Pacote;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }
    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        Pacote pacote = pacotes.get(posicao);
        TextView local = viewCriada.findViewById(R.id.local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.imagemCidade);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.dias);
        String diasEmTexto = "";
        int quantidadeDeDias = pacote.getDias();
        if(quantidadeDeDias > 1) {
            diasEmTexto = quantidadeDeDias + " dias";
        } else {
            diasEmTexto = quantidadeDeDias + " dia";
        }
        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.preco);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        BigDecimal precoDoPacote = pacote.getPreco();
        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote).replace("R$", "R$ ");

        preco.setText(moedaBrasileira);

        return viewCriada;
    }
}
