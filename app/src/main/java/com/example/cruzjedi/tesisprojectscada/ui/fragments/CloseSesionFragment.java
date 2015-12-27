package com.example.cruzjedi.tesisprojectscada.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.cruzjedi.tesisprojectscada.LoginActivity;
import com.example.cruzjedi.tesisprojectscada.R;

/**
 * Created by Cruz on 11/12/2015.
 */
public class CloseSesionFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.close_sesion)
                .setPositiveButton(R.string.acept, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(),"Sesión finalizada", Toast.LENGTH_SHORT).show();
                        Intent sendUser = new Intent(getContext(), LoginActivity.class);
                        startActivity(sendUser);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}