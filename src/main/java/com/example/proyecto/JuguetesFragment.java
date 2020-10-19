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

public class JuguetesFragment extends Fragment {

    //Puzzles, juegos, muñecos

    ListView listView;
    private String[] tiposJuguetes = {"Puzzles","Juegos","Muñecos"};
    private int[] iconos = {R.drawable.libro,R.drawable.libro,R.drawable.libro};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_juguetes, container, false);
        listView = root.findViewById(R.id.listViewJuguetes);
        final ArrayList<Item> juguetes = new ArrayList();

        for (int i = 0; i< tiposJuguetes.length; i++){
            juguetes.add(new Item(iconos[i], tiposJuguetes[i]));
        }

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return juguetes.size();
            }

            @Override
            public Object getItem(int position) {
                return juguetes.get(position);
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

                Item item = juguetes.get(position);
                textViewTitulo.setText(item.getTitulo());
                imageViewIcono.setImageResource(item.getIcono());

                return view;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Has pulsado "+ tiposJuguetes[position], Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}