package com.example.examenandroid;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class Menu_Principal extends Fragment implements View.OnClickListener{
    private int lanzaGuisantesId;
    private int girasolId;
    private int melonPultaId;
    private int cactusId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plants_menu, container, false);

        lanzaGuisantesId = R.id.Layout_LanzaGuisantes;
        girasolId = R.id.Layout_Girasol;
        melonPultaId = R.id.Layout_MelonPulta;
        cactusId = R.id.Layout_Cactus;

        LinearLayout lanzaGuisantesLayout = view.findViewById(R.id.Layout_LanzaGuisantes);
        LinearLayout girasolLayout = view.findViewById(R.id.Layout_Girasol);
        LinearLayout melonPultaLayout = view.findViewById(R.id.Layout_MelonPulta);
        LinearLayout cactusLayout = view.findViewById(R.id.Layout_Cactus);

        lanzaGuisantesLayout.setOnClickListener(this);
        girasolLayout.setOnClickListener(this);
        melonPultaLayout.setOnClickListener(this);
        cactusLayout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String plant = "";

        if (view.getId() == lanzaGuisantesId) {
            plant = "LanzaGuisantes";
        } else if (view.getId() == girasolId) {
            plant = "Girasol";
        } else if (view.getId() == melonPultaId) {
            plant = "MelonPulta";
        } else if (view.getId() == cactusId) {
            plant = "Cactus";
        }

        if (!plant.isEmpty() && getActivity() instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) getActivity();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                mainActivity.showSubMenu_land(plant);
            } else {
                mainActivity.showSubMenu(plant);
            }
        }
    }
}
