package com.example.cruzjedi.tesisprojectscada.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cruzjedi.tesisprojectscada.R;

/**
 * Created by cruzjedi on 5/11/15.
 */
public class MuestraHorarioFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_muestra_horario, container,false);
        return root;
    }
}
