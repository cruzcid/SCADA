package com.example.cruzjedi.tesisprojectscada.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cruzjedi.tesisprojectscada.MainActivity;
import com.example.cruzjedi.tesisprojectscada.R;

/**
 * Created by Cruz on 10/12/2015.
 */
public class BienvenidaFragment extends Fragment {
    private ImageView imgCheck,imgSchedule;
    private View root;
    private ControlAsistenciaFragment controlAsistFr;
    private String usuarioData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_bienvenida, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handleImageViews();
    }
    public void handleImageViews(){
        imgCheck = (ImageView) root.findViewById(R.id.img_vw_content_asistencia);
        imgSchedule = (ImageView) root.findViewById(R.id.img_vw_content_horarios);

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llama a cualquier metodo de la actividad a la que se menciona
                ((MainActivity)getActivity()).openControlAsistWithBundle();
                //Forma de abrir un fragmento desde otro fragmento
                // replaceFragment(new ControlAsistenciaFragment());
            }
        });
        imgSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HypedArtistsFragment());
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
