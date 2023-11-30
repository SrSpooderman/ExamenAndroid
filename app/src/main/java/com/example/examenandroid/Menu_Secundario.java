package com.example.examenandroid;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("ValidFragment")
public class Menu_Secundario extends Fragment {
    String plant;

    public Menu_Secundario(String plant) {
        this.plant = plant;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plant_submenu, container, false);
        Button backButton = view.findViewById(R.id.back_button);

        TextView menuText = view.findViewById(R.id.title);
        TextView infoText = view.findViewById(R.id.info);
        ImageView image = view.findViewById(R.id.image);

        if (plant.equals("LanzaGuisantes")){
            menuText.setText("LANZAGUISANTES");
            infoText.setText("¿Cómo puede una planta crecer y disparar guisantes tan rápido?\n" + "Lansaguisantes dice: \"Entrega, trabajo duro y una dieta rica en rayos de sol y saludable en dióxido de carbono lo hacen posible\".");
            image.setImageResource(R.mipmap.peashooter_foreground);
        } else if (plant.equals("Girasol")) {
            menuText.setText("GIRASOL");
            infoText.setText("El Girasol no puede resistir moverse al son de la melodía.\n" +
                    "¿Cuál? La melodía de la orquesta de la vida en la Tierra, una melodía en una frecuencia que solo los Girasoles pueden oir");
            image.setImageResource(R.mipmap.girasol_foreground);
        }else if (plant.equals("MelonPulta")) {
            menuText.setText("MELONPULTA");
            infoText.setText("Nada de falsas modestias con Melonpulta. \"Yo reparto la mejor leña de todo el jardín\", asegura. \"No me estoy echando ningún farol: Saca cuentas tú mismo.");
            image.setImageResource(R.mipmap.melonpulta_foreground);
        }else if (plant.equals("Cactus")) {
            menuText.setText("CACTUS");
            infoText.setText("Últimamente la vida de Cactus cambio. Contratos de libros, películas, apariciones en espectáculos de camiones... Intenta centrarse en seguir siendo humilde y en lanzar espinas como siempre.");
            image.setImageResource(R.mipmap.foreground_cactus);
        }else {
            menuText.setText("Plantas");
            infoText.setText("");
            image.setImageResource(R.mipmap.arbol_foreground);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() instanceof MainActivity) {
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        ((MainActivity) getActivity()).showSubMenu_land("data");
                    } else {
                        ((MainActivity) getActivity()).showMenu();
                    }
                }
            }
        });

        return view;
    }
}
