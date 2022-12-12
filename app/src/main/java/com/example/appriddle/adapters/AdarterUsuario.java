package com.example.appriddle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appriddle.R;
import com.example.appriddle.entity.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdarterUsuario extends BaseAdapter {
    private Context context;
    private ArrayList<Usuario> usuarios;

    public AdarterUsuario(Context context, ArrayList<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(context)
                    .inflate(R.layout.items_usuarios, null);
        }
        Usuario usuario = usuarios.get(i);
        TextView nombreUsuario = view.findViewById(R.id.nombreUsuario);
        TextView puntosUsuario = view.findViewById(R.id.puntosUsuario);

        nombreUsuario.setText(usuario.getCuenta());
        puntosUsuario.setText(String.valueOf(usuario.getPuntos()));
        return view;
    }
}
