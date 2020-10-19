package com.example.proyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MaterialFragment extends Fragment {


    ListView listView;
    private String[] tipos = {"Escolar","De Oficina"};
    private int[] iconos = {R.drawable.materialescolar,R.drawable.materialoficina};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_material, container, false);
        listView = root.findViewById(R.id.listViewMaterial);
        final ArrayList<Item> materiales = new ArrayList();

        for (int i = 0; i< tipos.length; i++){
            materiales.add(new Item(iconos[i], tipos[i]));
        }

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return materiales.size();
            }

            @Override
            public Object getItem(int position) {
                return materiales.get(position);
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

                Item item = materiales.get(position);
                textViewTitulo.setText(item.getTitulo());
                imageViewIcono.setImageResource(item.getIcono());

                return view;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        break;
                }

            }
        });
        return root;
    }
}