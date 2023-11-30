package com.example.examenandroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.ComponentActivity;
public class MainActivity extends ComponentActivity{
    Menu_Principal menuPrincipal = new Menu_Principal();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        showMenu();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showMenu();
            loadFragment_secundario(new Menu_Secundario("data"));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showMenu();
        }
    }

    private void loadFragment_principal(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Menu_Principal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void loadFragment_secundario(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Menu_Secundario, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void showSubMenu(String plant) {
        loadFragment_principal(new Menu_Secundario(plant));
    }

    public void showSubMenu_land(String plant){
        loadFragment_secundario(new Menu_Secundario(plant));
    }
    public void showMenu(){
        loadFragment_principal(menuPrincipal);
    }
}
