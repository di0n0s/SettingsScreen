package org.sfc.settingsscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment); //Despliga la vista contenedora

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container); //Solicitamos a FragmentManager el fragment por su ID

        if(fragment == null){ //Si ningún fragment se corresponde con el ID...
            fragment = createFragment(); //Se crea un nuevo Fragment
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit(); //Crea una transacción de Fragment que lo añada a la lista, añade el fragment y confirma la transacción
        }
    }
}
