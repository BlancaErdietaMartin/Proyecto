package com.example.proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class LibrosFragment extends Fragment {

    ListView listView;
    private String[] generos = {"0-3 Años","5-8 Años","8-12 Años","Juvenil","Adulto"};
    private int[] iconos = {R.drawable.libro,R.drawable.libro,R.drawable.libro,R.drawable.libro,R.drawable.libro};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_libros, container, false);
        listView = root.findViewById(R.id.listViewLibros);
        final ArrayList<Item> libros = new ArrayList();

        for (int i = 0; i<generos.length; i++){
            libros.add(new Item(iconos[i],generos[i]));
        }

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return libros.size();
            }

            @Override
            public Object getItem(int position) {
                return libros.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.fila,parent,false);
                ImageView imageViewIcono = view.findViewById(R.id.imageViewIcono);
                TextView textViewTitulo = view.findViewById(R.id.textViewTitulo);

                Item item = libros.get(position);
                textViewTitulo.setText(item.getTitulo());
                imageViewIcono.setImageResource(item.getIcono());

                return view;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Has pulsado "+generos[position], Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}