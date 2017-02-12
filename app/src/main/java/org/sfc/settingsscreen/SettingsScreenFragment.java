package org.sfc.settingsscreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import butterknife.BindView;

import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsScreenFragment extends Fragment {

    private String mUsername;
    private int mRefreshTime;

    @BindView(R.id.username_edit_text_view) EditText mUsernameEditText;
    @BindView(R.id.refresh_time_spinner) Spinner mRefreshTimeSpinner;

    @OnTextChanged(R.id.username_edit_text_view) void onTextChanged(CharSequence text){
        mUsername = text.toString();
    }

    @OnItemSelected(R.id.refresh_time_spinner) void onItemSelected(AdapterView<?> parent, int position){
        mRefreshTime = (Integer) parent.getItemAtPosition(position);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings_screen, container, false); //Inflamos la vista
        ButterKnife.bind(this,view); //Bindeo entre la instancia del fragment y la vista


//        mRefreshTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                mRefreshTime = (Integer) parent.getItemAtPosition(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        return view;
    }

    private void spinnerAdapter(){
        //Creamos un ArrayAdapter usando el array de <resources>
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.refresh_time_array, android.R.layout.simple_spinner_item);
        //Especificamos el layout a utilizar cuando la lista aparezca
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //Aplicamos el adapter al Spinner
        mRefreshTimeSpinner.setAdapter(adapter);
    }

}
