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

public class OtrosFragment extends Fragment {

    ListView listView;
    private String[] opciones = {"Bolsos","Carteras","Mochilas","Portadocumentos","Paraguas","Marcos"};
    private int[] iconos = {R.drawable.libro,R.drawable.libro,R.drawable.libro,R.drawable.libro,R.drawable.libro,R.drawable.libro};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_otros, container, false);
        listView = root.findViewById(R.id.listViewOtros);
        final ArrayList<Item> varios = new ArrayList();

        for (int i = 0; i< opciones.length; i++){
            varios.add(new Item(iconos[i], opciones[i]));
        }

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return varios.size();
            }

            @Override
            public Object getItem(int position) {
                return varios.get(position);
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

                Item item = varios.get(position);
                textViewTitulo.setText(item.getTitulo());
                imageViewIcono.setImageResource(item.getIcono());

                return view;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Has pulsado "+ opciones[position], Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}